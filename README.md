# 🔐 JWT Authentication & Email OTP Verification Project

## 📌 Project Overview

This project is a **Spring Boot JWT Security Application** that provides:

* ✅ User Registration
* ✅ Email OTP Verification
* ✅ User Login with JWT
* ✅ Forgot Password (Email-based)
* ✅ Reset Password
* ✅ Secure API Access using JWT Authentication

The system uses **JWT (JSON Web Token)** for authentication and **SMTP email service** for sending OTP and password reset emails.

---

# 🚀 Features

## 🔹 1. User Registration

* User registers with email and password.
* OTP is generated and sent to the registered email.
* User must verify OTP to activate account.

## 🔹 2. Email OTP Verification

* OTP is sent via email.
* OTP has expiration time.
* On successful verification, user account becomes active.

## 🔹 3. User Login

* User logs in with email and password.
* If credentials are valid, a JWT token is generated.
* Token must be used for accessing secured APIs.

## 🔹 4. JWT Authentication

* JWT is generated after login.
* Token is sent in request header:

  ```
  Authorization: Bearer <your_token>
  ```
* Custom `JwtFilter` validates token before allowing access.

## 🔹 5. Forgot Password

* User enters registered email.
* Password reset link or OTP is sent to email.

## 🔹 6. Reset Password

* User submits new password with valid reset token/OTP.
* Password gets updated securely (encrypted).

---

# 🏗 Project Architecture

```
controller
service
repository
entity
dto
security
util
```

### 🔹 Controller

Handles API requests.

### 🔹 Service

Contains business logic.

### 🔹 Repository

Handles database operations using Spring Data JPA.

### 🔹 Security

Contains:

* Security Configuration
* JWT Filter
* Authentication handling

### 🔹 Util

Contains:

* JwtUtil (Generate & Validate JWT)

---

# 🛠 Technologies Used

* Java 17+
* Spring Boot
* Spring Security
* Spring Data JPA
* MySQL
* JWT (jjwt library)
* SMTP (Email Service)
* Maven

---

# 🔐 Security Flow

### 🔑 Registration Flow

1. User registers
2. OTP sent to email
3. User verifies OTP
4. Account activated

### 🔑 Login Flow

1. User logs in
2. JWT token generated
3. Token returned to client
4. Client sends token in every secured request

### 🔑 Protected API Flow

1. Client sends JWT in header
2. JwtFilter validates token
3. If valid → Request allowed
4. If invalid → 401 Unauthorized

---

# 📡 API Endpoints

## 🔓 Public APIs

| Method | Endpoint                   | Description      |
| ------ | -------------------------- | ---------------- |
| POST   | /api/users/register        | Register user    |
| POST   | /api/users/verify-otp      | Verify email OTP |
| POST   | /api/users/login           | Login user       |
| POST   | /api/users/forgot-password | Send reset email |
| POST   | /api/users/reset-password  | Reset password   |

---

## 🔒 Protected APIs

| Method | Endpoint       | Description                  |
| ------ | -------------- | ---------------------------- |
| GET    | /api/users/all | Get all users (JWT required) |

---

# ⚙️ Configuration

## 🔹 Database Configuration

`application.properties`

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/your_db
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

---

## 🔹 JWT Configuration

* Secret Key
* Expiration Time (1 hour default)

---

## 🔹 SMTP Configuration (Example for Gmail)

```properties
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=your-email@gmail.com
spring.mail.password=your-app-password
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
```

---

# ▶️ How to Run the Project

1. Clone the repository
2. Open in IntelliJ / STS
3. Configure MySQL database
4. Configure SMTP email
5. Run main Spring Boot application
6. Test APIs using Postman

---

# 📌 Important Notes

* Do NOT push real database credentials to GitHub.
* Do NOT expose JWT secret key publicly.
* Always use strong secret keys in production.
* Enable HTTPS in production environment.

---

# 🎯 Conclusion

This project demonstrates:

* Secure authentication using JWT
* Email OTP verification system
* Password reset functionality
* Role-based secured endpoints
* Stateless authentication architecture

---

👨‍💻 Developed as a secure authentication system using Spring Boot and JWT.
