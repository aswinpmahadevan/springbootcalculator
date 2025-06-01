# Spring Boot Calculator API

This project is a simple Spring Boot application that provides a RESTful API for performing basic arithmetic operations: addition, subtraction, multiplication, and division. The application is designed to run on port 9200 and includes CORS configuration for development purposes.

## Features

- **Addition**: Perform addition of two numbers.
- **Subtraction**: Perform subtraction of two numbers.
- **Multiplication**: Perform multiplication of two numbers.
- **Division**: Perform division of two numbers.

## Technologies Used

- Spring Boot
- Java
- Maven
- JUnit for testing

## Setup Instructions

1. **Clone the repository**:
   ```
   git clone <repository-url>
   cd spring-boot-calculator
   ```

2. **Build the project**:
   ```
   mvn clean install
   ```

3. **Run the application**:
   ```
   mvn spring-boot:run
   ```

4. **Access the API**:
   The API will be available at `http://localhost:9200`.

## API Endpoints

- **Addition**: `POST /api/add`
- **Subtraction**: `POST /api/subtract`
- **Multiplication**: `POST /api/multiply`
- **Division**: `POST /api/divide`

## Testing

Unit tests are included in the project to ensure the functionality of the application. You can run the tests using the following command:

```
mvn test
```

## License

This project is licensed under the MIT License.# springbootcalculator
