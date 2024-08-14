import React, { useEffect, useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom"; // Import useNavigate for redirection
import {
  Table,
  TableCaption,
  TableHeader,
  TableBody,
  TableRow,
  TableCell,
} from "../ui/table";
import { Button } from "../ui/button";

const CompaniesTable = () => {
  const [jobListings, setJobListings] = useState([]);
  const [showForm, setShowForm] = useState(false);
  const [formData, setFormData] = useState({
    jobTitle: "",
    jobDescription: "",
    skillName: "",
  });
  const navigate = useNavigate(); // Initialize useNavigate

  useEffect(() => {
    const fetchJobListings = async () => {
      const recruiter = sessionStorage.getItem("recruiter");
      if (!recruiter) {
        // If recruiter is not logged in, redirect to login page
        navigate("/loginrecruiter");
        return;
      }
      try {
        const recruiterId = JSON.parse(recruiter).recruiterId;
        const response = await axios.get(
          `http://localhost:8080/api/joblistings/recruiter/${recruiterId}`
        );
        setJobListings(response.data); // Set job listings directly
      } catch (error) {
        console.error("There was an error fetching the job listings!", error);
      }
    };

    fetchJobListings();
  }, [navigate]);

  const handleAddNewClick = () => {
    setShowForm(true);
  };

  const handleFormChange = (e) => {
    const { name, value } = e.target;
    setFormData((prev) => ({ ...prev, [name]: value }));
  };

  const handleFormSubmit = async (e) => {
    e.preventDefault();
    const recruiterId = JSON.parse(
      sessionStorage.getItem("recruiter")
    ).recruiterId;
    try {
      // Make an API call to add a new job listing
      await axios.post("http://localhost:8080/api/joblistings", {
        jobTitle: formData.jobTitle,
        jobDescription: formData.jobDescription,
        recruiterId, // Include recruiter ID
        skillName: formData.skillName, // Include skillName if required
      });

      // Optionally fetch the updated list of job listings
      const response = await axios.get(
        `http://localhost:8080/api/joblistings/recruiter/${recruiterId}`
      );
      setJobListings(response.data); // Update the job listings state

      // Clear form data and hide the form
      setShowForm(false);
      setFormData({
        jobTitle: "",
        jobDescription: "",
        skillName: "",
      });
    } catch (error) {
      console.error(
        "There was an error adding the job listing!",
        error.response || error.message
      );
    }
  };

  return (
    <div className="overflow-x-auto">
      <Button
        onClick={handleAddNewClick}
        className="mb-4 p-2 text-white rounded"
      >
        Add New Job
      </Button>
      {showForm && (
        <form
          onSubmit={handleFormSubmit}
          className="mb-4 p-4 border border-gray-300 rounded bg-white"
        >
          <div className="mb-2">
            <label className="block text-sm font-medium mb-1">Job Title</label>
            <input
              type="text"
              name="jobTitle"
              value={formData.jobTitle}
              onChange={handleFormChange}
              className="border p-2 w-full"
              required
            />
          </div>
          <div className="mb-2">
            <label className="block text-sm font-medium mb-1">
              Job Description
            </label>
            <textarea
              name="jobDescription"
              value={formData.jobDescription}
              onChange={handleFormChange}
              className="border p-2 w-full"
              required
            />
          </div>
          <div className="mb-2">
            <label className="block text-sm font-medium mb-1">Skill Name</label>
            <input
              type="text"
              name="skillName"
              value={formData.skillName}
              onChange={handleFormChange}
              className="border p-2 w-full"
            />
          </div>
          <button type="submit" className="bg-blue-500 text-white p-2 rounded">
            Submit
          </button>
          <button
            type="button"
            onClick={() => setShowForm(false)}
            className="ml-2 bg-gray-500 text-white p-2 rounded"
          >
            Cancel
          </button>
        </form>
      )}
      <Table className="min-w-full bg-white">
        <TableCaption>A List Of Your Recent Job Listings</TableCaption>
        <TableHeader>
          <TableRow>
            <TableCell className="font-semibold">Job ID</TableCell>
            <TableCell className="font-semibold">Job Title</TableCell>
            <TableCell className="font-semibold">Job Description</TableCell>
            <TableCell className="font-semibold">Recruiter Name</TableCell>
            <TableCell className="font-semibold">Skill Name</TableCell>
          </TableRow>
        </TableHeader>
        <TableBody>
          {jobListings.length > 0 ? (
            jobListings.map((job) => (
              <TableRow key={job.jobId}>
                <TableCell>{job.jobId}</TableCell>
                <TableCell>{job.jobTitle}</TableCell>
                <TableCell>{job.jobDescription}</TableCell>
                <TableCell>{job.recruiter?.companyName || "N/A"}</TableCell>
                <TableCell>{job.skill?.skillName || "N/A"}</TableCell>
              </TableRow>
            ))
          ) : (
            <TableRow>
              <TableCell colSpan="5" className="text-center py-4">
                No job listings available
              </TableCell>
            </TableRow>
          )}
        </TableBody>
      </Table>
    </div>
  );
};

export default CompaniesTable;
