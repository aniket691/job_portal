import React, { useState } from "react";
import Navbar from "../shared/Navbar";
import { Link } from "react-router-dom";
import axios from "axios";
import countries from "@/utils/countries"; // Import the countries list

const Label = ({ children }) => (
  <label className="block font-medium text-gray-700 mb-2">{children}</label>
);

const Input = (props) => (
  <input
    className="w-full px-3 py-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500"
    {...props}
  />
);

const Textarea = (props) => (
  <textarea
    className="w-full px-3 py-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500"
    {...props}
  />
);

const Select = (props) => (
  <select
    className="w-full px-3 py-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500"
    {...props}
  />
);

function Signup() {
  const [fullName, setFullName] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [mobileNumber, setMobileNumber] = useState("");
  const [resume, setResume] = useState(null); // Updated to handle file uploads
  const [profileSummary, setProfileSummary] = useState("");
  const [experience, setExperience] = useState(0);
  const [skillId, setSkillId] = useState(1);
  const [location, setLocation] = useState("");
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState("");
  const [success, setSuccess] = useState("");

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    switch (name) {
      case "fullName":
        setFullName(value);
        break;
      case "email":
        setEmail(value);
        break;
      case "password":
        setPassword(value);
        break;
      case "mobileNumber":
        setMobileNumber(value);
        break;
      case "profileSummary":
        setProfileSummary(value);
        break;
      case "experience":
        setExperience(parseInt(value, 10));
        break;
      case "skillId":
        setSkillId(parseInt(value, 10));
        break;
      case "location":
        setLocation(value);
        break;
      default:
        break;
    }
  };

  const handleFileChange = (e) => {
    setResume(e.target.files[0]); // Handle file selection
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    if (
      !fullName ||
      !email ||
      !password ||
      !mobileNumber ||
      !profileSummary ||
      experience < 0 ||
      !location
    ) {
      setError("Please fill all required fields.");
      return;
    }

    setLoading(true);
    setError("");
    setSuccess("");

    // Create a FormData object to handle the multipart request
    const formData = new FormData();
    formData.append("jobSeekerDTO", JSON.stringify({
      jobSeekerId: 0,
      jobSeekerFullName: fullName,
      jobSeekerMobileNumber: mobileNumber,
      jobSeekerProfileSummary: profileSummary,
      jobSeekerExperience: experience,
      jobSeekerEmail: email,
      jobSeekerPassword: password,
      skillId: skillId,
      location: location,
    }));
    formData.append("resumeFile", resume); // Append the file

    try {
      const response = await axios.post(
        "http://localhost:8080/api/jobseekers/createJobSeeker",
        formData,
        {
          headers: {
            "Content-Type": "multipart/form-data",
          },
        }
      );
      setSuccess("Job Seeker created successfully!");
    } catch (error) {
      setError("Error creating job seeker. Please try again.");
    } finally {
      setLoading(false);
    }
  };

  return (
    <div>
      <Navbar />
      <div className="flex items-center justify-center max-w-7xl mx-auto">
        <form
          className="w-full max-w-md bg-[#eff1f3] border border-gray-200 rounded-md p-8 shadow-lg my-10"
          onSubmit={handleSubmit}
        >
          <h1 className="font-bold text-xl mb-5">Job Seeker Sign up</h1>

          {/* Full Name */}
          <div className="my-2">
            <Label>Full Name</Label>
            <Input
              type="text"
              name="fullName"
              placeholder="Enter your full name"
              value={fullName}
              onChange={handleInputChange}
            />
          </div>

          {/* Email */}
          <div className="my-2">
            <Label>Email</Label>
            <Input
              type="email"
              name="email"
              placeholder="Enter your email"
              value={email}
              onChange={handleInputChange}
            />
          </div>

          {/* Password */}
          <div className="my-2">
            <Label>Password</Label>
            <Input
              type="password"
              name="password"
              placeholder="Enter your password"
              value={password}
              onChange={handleInputChange}
            />
          </div>

          {/* Mobile Number */}
          <div className="my-2">
            <Label>Mobile Number</Label>
            <Input
              type="tel"
              name="mobileNumber"
              placeholder="Enter your mobile number"
              value={mobileNumber}
              onChange={handleInputChange}
            />
          </div>

          {/* Resume Upload */}
          <div className="my-2">
            <Label>Resume</Label>
            <Input
              type="file" // Update to file input
              name="resume"
              onChange={handleFileChange}
            />
          </div>

          {/* Profile Summary */}
          <div className="my-2">
            <Label>Profile Summary</Label>
            <Textarea
              name="profileSummary"
              placeholder="Write a brief profile summary"
              rows="4"
              value={profileSummary}
              onChange={handleInputChange}
            />
          </div>

          {/* Experience */}
          <div className="my-2">
            <Label>Experience (years)</Label>
            <Input
              type="number"
              name="experience"
              placeholder="Enter your experience"
              value={experience}
              onChange={handleInputChange}
            />
          </div>

          {/* Skill ID */}
          <div className="my-2">
            <Label>Skill ID</Label>
            <Input
              type="number"
              name="skillId"
              placeholder="Enter your skill ID"
              value={skillId}
              onChange={handleInputChange}
            />
          </div>

          {/* Location */}
          <div className="my-2">
            <Label>Location</Label>
            <Select
              name="location"
              value={location}
              onChange={handleInputChange}
            >
              <option value="">Select your location</option>
              {countries.map((country) => (
                <option key={country} value={country}>
                  {country}
                </option>
              ))}
            </Select>
          </div>

          {/* Error and Success Messages */}
          {error && <div className="text-red-500 mb-2">{error}</div>}
          {success && <div className="text-green-500 mb-2">{success}</div>}

          {/* Submit Button */}
          <div className="my-2">
            <button
              type="submit"
              className={`w-full px-4 py-2 bg-[#02367B] text-white font-bold rounded-md focus:outline-none ${loading ? "opacity-50 cursor-not-allowed" : ""
                }`}
              disabled={loading}
            >
              {loading ? "Submitting..." : "Submit"}
            </button>
          </div>
          <div className="my-2">
            <Link to="/login" className="text-blue-500 hover:underline">
              Already have an account? Login
            </Link>
          </div>
        </form>
      </div>
    </div>
  );
}

export default Signup;
