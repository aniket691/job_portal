# Job Portal System

## Overview

This project is a Job Portal System that allows job seekers and recruiters to interact seamlessly. Job seekers can search and apply for jobs, while recruiters can post and manage job listings. The platform ensures secure registration, login, and profile management for both job seekers and recruiters.

## Features

### For Job Seekers:
- **Registration & Login**: Secure account creation and login functionality.
- **Profile Management**: Job seekers can create and manage their profiles, including their skills, experience, and resume.
- **Job Search**: Search for job listings using filters such as job title, location, and required skills.
- **Job Application**: Apply for jobs directly through the platform and track application status.

### For Recruiters:
- **Registration & Login**: Secure account creation and login functionality.
- **Profile Management**: Recruiters can manage their company profiles.
- **Job Posting**: Post job openings with details like title, description, required skills, and location.
- **Job Management**: Manage, update, and monitor job postings efficiently.

## Technology Stack

- **Frontend**: React.js
- **Backend**: Spring Boot
- **Database**: MySQL

## Installation & Setup

### Prerequisites
- Node.js and npm (for frontend)
- Java and Maven (for backend)
- MySQL Server

### Backend Setup (Spring Boot)
1. Clone the repository:
    ```bash
    git clone https://github.com/yourusername/job-portal.git
    ```
2. Navigate to the backend directory:
    ```bash
    cd job-portal/backend
    ```
3. Update the `application.properties` file with your MySQL database credentials:
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/job_portal
    spring.datasource.username=root
    spring.datasource.password=yourpassword
    ```
4. Build and run the Spring Boot application:
    ```bash
    mvn clean install
    mvn spring-boot:run
    ```

### Frontend Setup (React.js)
1. Navigate to the frontend directory:
    ```bash
    cd job-portal/frontend
    ```
2. Install the required npm packages:
    ```bash
    npm install
    ```
3. Start the React development server:
    ```bash
    npm start
    ```

### Database Setup (MySQL)
1. Create a new database in MySQL:
    ```sql
    CREATE DATABASE job_portal;
    ```
2. The database schema will be automatically created by the Spring Boot application when it runs.

## Usage

- Access the application through `http://localhost:3000` (React frontend).
- Register as a job seeker or recruiter.
- Job seekers can search for jobs, apply, and track applications.
- Recruiters can post and manage job listings.

## Contributing

Contributions are welcome! Please fork the repository and submit a pull request with your improvements.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Contact

For any questions or suggestions, feel free to reach out at [your.email@example.com](mailto:your.email@example.com).
