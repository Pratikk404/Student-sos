# Student-SOS 🚨

Student-SOS is a web-based emergency item borrowing system designed for college campuses.  
It enables students to post urgent requests for essential items such as calculators, chargers, or stationery during time-sensitive situations like exams or practicals. Other students can accept and fulfill these requests through a structured workflow.

> ⚠️ **Status: UNDER ACTIVE DEVELOPMENT**  
> This project is currently in progress. Features, APIs, and structure may evolve.

---

## ✨ Current Features (Phase 1)

- Student registration (phone-based identity)  
- Full CRUD operations for students  
- SOS trigger creation  
- Basic SOS status tracking  
- MySQL database persistence  
- Layered architecture (Controller → Service → Repository)

---

## 🏗️ Tech Stack

- Java 17  
- Spring Boot  
- MySQL  
- JPA / Hibernate  
- Maven  

---

## 📂 Project Structure (Current)
```
studentsos/
├── entity/ → Database models (Student, SOS)
├── repository/ → JPA repositories
├── service/ → Business logic layer
├── controller/ → REST API endpoints
└── resources/
└── application.properties (excluded from Git)
```
---

## 🎯 Project Goal

To incrementally build a scalable and efficient real-time emergency response system.
