import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";
import {
  Table,
  TableCaption,
  TableHeader,
  TableBody,
  TableRow,
  TableCell,
} from "../ui/table";

function ShowAppliedApplications() {
  const [applications, setApplications] = useState([]);
  const [error, setError] = useState(null);
  const navigate = useNavigate();

  useEffect(() => {
    const recruiter = sessionStorage.getItem("recruiter");

    if (!recruiter) {
      navigate("/loginrecruiter");
      return;
    }

    const fetchApplications = async () => {
      try {
        const recruiterId = JSON.parse(recruiter).recruiterId;
        const response = await axios.get(
          `http://localhost:8080/applications/recruiter/${recruiterId}`
        );
        setApplications(response.data);
      } catch (error) {
        setError("Error fetching applications");
      }
    };

    fetchApplications();
  }, [navigate]);

  const handleStatusChange = async (applicationId, newStatus) => {
    try {
      await axios.put(
        `http://localhost:8080/applications/${applicationId}/status`,
        newStatus
      );
      setApplications((prevApplications) =>
        prevApplications.map((application) =>
          application.applicationId === applicationId
            ? { ...application, applicationStatus: newStatus }
            : application
        )
      );
    } catch (error) {
      console.error("Error updating application status:", error);
      setError("Error updating application status");
    }
  };

  const jobListings = applications.reduce((acc, application) => {
    const job = application.jobListing;
    if (!acc.some((existingJob) => existingJob.jobId === job.jobId)) {
      acc.push({
        jobId: job.jobId,
        jobTitle: job.jobTitle,
        jobDescription: job.jobDescription,
        applications: applications.filter(
          (app) => app.jobListing.jobId === job.jobId
        ),
      });
    }
    return acc;
  }, []);

  return (
    <div>
      {error && <p>{error}</p>}
      <div className="overflow-x-auto">
        <Table className="min-w-full bg-white">
          <TableCaption>Job Listings with Applications</TableCaption>
          <TableHeader>
            <TableRow>
              <TableCell className="font-semibold">Job ID</TableCell>
              <TableCell className="font-semibold">Job Title</TableCell>
              <TableCell className="font-semibold">Job Description</TableCell>
              <TableCell className="font-semibold">Applications</TableCell>
            </TableRow>
          </TableHeader>
          <TableBody>
            {jobListings.length > 0 ? (
              jobListings.map((job) => (
                <TableRow key={job.jobId}>
                  <TableCell>{job.jobId}</TableCell>
                  <TableCell>{job.jobTitle}</TableCell>
                  <TableCell>{job.jobDescription}</TableCell>
                  <TableCell>
                    <ul>
                      {job.applications.map((application) => (
                        <li key={application.applicationId}>
                          {application.jobSeeker.jobSeekerFullName} -{" "}
                          <select
                            value={application.applicationStatus}
                            onChange={(e) =>
                              handleStatusChange(
                                application.applicationId,
                                e.target.value
                              )
                            }
                          >
                            <option value="APPLIED">APPLIED</option>
                            <option value="INTERVIEWED">INTERVIEWED</option>
                            <option value="SELECTED">SELECTED</option>
                            <option value="REJECTED">REJECTED</option>
                          </select>
                        </li>
                      ))}
                    </ul>
                  </TableCell>
                </TableRow>
              ))
            ) : (
              <TableRow>
                <TableCell colSpan="4" className="text-center py-4">
                  No job listings with applications available
                </TableCell>
              </TableRow>
            )}
          </TableBody>
        </Table>
      </div>
    </div>
  );
}

export default ShowAppliedApplications;
