# Pincode Distance API

This Spring Boot application provides a REST API to calculate the distance and duration between two Indian pin codes using the Google Maps API. The application caches responses for efficiency and stores the route information in a database.

## Features

- Fetches distance and duration between two pin codes using Google Maps API.
- Caches results to reduce API calls and improve performance.
- Stores the distance, duration, and route information in a database.
- REST-compliant API, testable with Postman or other HTTP clients.
- Unit testing using JUnit.

## Technologies Used

- **Spring Boot** - Backend framework
- **Google Maps API** - For fetching distance and duration
- **JPA (Java Persistence API)** - For database interaction
- **H2 Database** - In-memory database (or configure your own database)
- **EhCache** - For caching API responses
- **JUnit** - For unit testing
- **Jackson** - For JSON serialization

## Requirements

- Java 17 or higher
- Maven
- A Google Maps API key (see below for instructions)

##Key Sections:## 
Features:  This section explains what the project is about and highlights the core functionality of the application. It tells users what they can expect from using the project.

Technologies Used: Lists all major frameworks, libraries, and tools used in the project. This helps developers quickly understand the stack and know if they are familiar with the technologies or need to get up to speed on any new ones.

Setup and Installation: Provides clear, step-by-step instructions on how to get the project running locally. This section is crucial for developers or contributors who want to quickly start working on the project.

API Endpoints: Detailed documentation of the API endpoints helps users understand how to interact with the service. It should include method types (GET, POST), request parameters, and response formats.

Database Configuration: Explains how to set up the database. By default, the application uses H2 (in-memory), but this section also provides instructions for switching to more robust options like MySQL or PostgreSQL.

Running Tests: Explains how to run unit or integration tests. Providing commands to run tests ensures the project is maintainable and reliable, and developers can verify their changes don't break the existing functionality.

Future Enhancements: Lists potential improvements or features that could be added later. This encourages collaboration by giving contributors ideas of what to work on next.

## Setup and Installation

### 1. Clone the Repository
```bash
https://github.com/vikashkumar7254/PincodeDistance.git
cd pincode-distance-api
