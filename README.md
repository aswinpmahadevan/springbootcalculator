# Spring Boot Calculator

A secure, Naruto-themed calculator web application built with Spring Boot.  
Features user registration, login, and a stylish calculator UI that calls backend APIs for arithmetic operations.

---

## Features

- **User Registration & Login**: Secure authentication with password hashing.
- **Naruto-Themed UI**: Fun, animated calculator and registration/login pages.
- **Calculator Operations**: Addition, subtraction, multiplication, division, power, root, log, ln, exp, factorial, mod, abs.
- **RESTful API**: All calculations are performed via `/api/calc/*` endpoints.
- **Logout**: Secure logout option on the calculator page.
- **Sound Effects**: Plays a jutsu sound on calculation.

---

## Project Structure

```
spring-boot-calculator/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/calculator/
│   │   │       ├── config/
│   │   │       │   └── SecurityConfig.java
│   │   │       ├── controller/
│   │   │       │   ├── CalculatorController.java
│   │   │       │   └── UserController.java
│   │   │       ├── model/
│   │   │       │   └── User.java
│   │   │       ├── repository/
│   │   │       │   └── UserRepository.java
│   │   │       └── service/
│   │   │           └── CustomUserDetailsService.java
│   │   └── resources/
│   │       └── static/
│   │           ├── calculator.html
│   │           ├── login.html
│   │           ├── register.html
│   │           ├── js/
│   │           │   └── calculator.js
│   │           ├── images/
│   │           │   └── naruto.png
│   │           └── sounds/
│   │               └── jutsu.mp3
│   └── test/
│       └── java/
│           └── com/example/calculator/
│               └── CalculatorApplicationTests.java
├── pom.xml
└── README.md
```

---

## How to Run

1. **Clone the repository**
2. **Configure your database** (see `application.properties`)
3. **Build and run**
   ```sh
   mvn clean spring-boot:run
   ```
4. **Access the app**
   - Open [http://localhost:9200/login.html](http://localhost:9200/login.html) in your browser.

---

## Usage

- **Register** a new user via the registration page.
- **Login** with your credentials.
- After login, you will be redirected to the calculator page.
- Use the calculator UI to perform operations. Results are fetched from the backend.
- Click **Logout** to end your session.

---

## API Endpoints

- `POST /register` — Register a new user
- `POST /login` — Login (handled by Spring Security)
- `GET /api/calc/add?a=1&b=2` — Add
- `GET /api/calc/subtract?a=5&b=3` — Subtract
- ...and similar for other operations

---

## Customization

- **Images**: Place your Naruto images in `src/main/resources/static/images/`.
- **Sounds**: Place your sound effects in `src/main/resources/static/sounds/`.
- **UI**: Edit `calculator.html`, `login.html`, and `register.html` for further customization.

---

## License

This project is for educational/demo purposes.

---
