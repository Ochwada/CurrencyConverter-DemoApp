# 🌍 Currency Converter App – Java Spring Boot Project

## Project Overview:
A **full-featured Currency Converter App** using **Spring Boot**, designed to help users convert currencies in real-time 
using up-to-date exchange rates from an external API. The app will also allow users to **save their conversions** for later 
reference, stored securely in **MongoDB Atlas**.

Applying best practices in **Java backend development**, including **RESTful API design**, **input validation**, and a **clean 
architectural structure**. This project is ideal for developers looking to strengthen their Spring Boot skills while 
working on a practical, real-world financial tool.

##  Background & Purpose
Every day, people and businesses need to convert money from one currency to another:

- Tourists need to know the exchange rate before traveling. 
- Online shoppers want to see prices in their own currency. 
- Businesses handle invoices in multiple currencies.

Currency conversion is one of the most common, essential backend tasks. But you can't just "hard-code" rates—you need to 
fetch them from a reliable, live source. That's where external APIs come in.

## Key Features
1. **Live Exchange Rate Fetching:**
Integrate with a real external API - i.e. [FreeCurrency API](https://freecurrencyapi.com/) to fetch up-to-date conversion 
rates i.e. Call the external API to get the latest rates
2. **Currency Conversion Logic:**
Provide endpoints to convert a given amount from one currency to another using real-time data i.e. Calculate the converted amount.
3. **User-Saved Conversions:**
Allow users to save conversion results (e.g., amount, from, to, rate, timestamp) into a MongoDB Atlas database i.e. Store 
the conversion record in MongoDB Atlas.
4. **REST API with Input Validation:**
Create well-structured endpoints with request validation using DTOs, custom exception handling, and global error responses.
5. **Clean Architecture:**
Follow separation of concerns by structuring the project with Controllers, Services, Repositories, and  Data Transfer Objects (DTOs).

## Project Dependencies
To build and run the Currency Converter App, the following dependencies are included in the `pom.xml`:

| Dependency                         | Purpose                                                                                       |
|------------------------------------|-----------------------------------------------------------------------------------------------|
| `spring-boot-starter-data-mongodb` | Enables MongoDB support with Spring Data (repositories, templates, etc.)                      |
| `spring-boot-starter-validation`   | Adds Java Bean validation support for annotations like `@NotNull`, `@Size`, etc.              |
| `spring-boot-starter-web`          | Sets up Spring MVC, embedded Tomcat, and JSON support for building REST APIs                  |
| `lombok`                           | Reduces boilerplate code by using annotations like `@Getter`, `@Setter`, `@Builder`, etc.     |
| `spring-boot-starter-test`         | Provides testing support using JUnit, Mockito, and Spring Test for unit and integration tests |
| `dotenv-java`                      | Loads environment variables from a `.env` file for secure configuration management            |



## Tech Stack
- Java 21+ 
- Spring Boot 3.x 
- MongoDB Atlas 
- Spring Data MongoDB 
- Spring Web (REST API)
- External Currency Exchange API 
- Maven / Gradle 
- JUnit & Mockito (Optional: for Testing)

##  API Endpoint Documentation
Briefly explanation of the available REST endpoints:


| Method | Endpoint       | Description                                     |
|--------|----------------|-------------------------------------------------|
| `POST` | `/api/convert` | Converts an amount from one currency to another |

<br>
<br>
<br>
<br>
<br>
<br>
<br>

# 🚀 Getting Started

#### Prerequisites
- Java 21+
- Maven or Gradle
- MongoDB Atlas account
- `.env` file with your API key and MongoDB URI

#### Steps to Run

```bash
# Clone the repository
git clone https://github.com/your-username/currency-converter-app.git
cd currency-converter-app

# Run the app
./mvnw spring-boot:run
```
