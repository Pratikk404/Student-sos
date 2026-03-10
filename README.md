# Student-SOS 🚨

A real-time campus emergency request system that allows students to send SOS alerts when they urgently need essential items during exams or practical sessions.

## ✨ Key Features

📡 **Real-time SOS Alerts** | 📱 **Phone-based Student Identity** | 🧮 **Karma Discipline System** | 🏆 **Leaderboard**

* Student registration using phone number
* SOS request creation
* Karma deduction when SOS is triggered
* Leaderboard based on remaining karma
* Real-time SOS broadcast using WebSockets
* MySQL database persistence
* Clean layered Spring Boot architecture

---

## 🏗️ Tech Stack

| Component      | Technology           |
| -------------- | -------------------- |
| **Backend**    | Spring Boot, Java 17 |
| **Database**   | MySQL, JPA/Hibernate |
| **Realtime**   | Spring WebSocket     |
| **Build Tool** | Maven                |
| **Port**       | 8080                 |

---

## 🚀 Quick Start

### Prerequisites

```
Java 17+ | MySQL Server | Maven
```

### Setup

```bash
# 1. Clone repository
git clone <repo-url>
cd studentsos

# 2. Create database
mysql -u root -p
> CREATE DATABASE studentsos;

# 3. Configure database
Update src/main/resources/application.properties

spring.datasource.url=jdbc:mysql://localhost:3306/studentsos
spring.datasource.username=root
spring.datasource.password=your_password

# 4. Build and run
mvn clean package
mvn spring-boot:run

# 5. Server runs at
http://localhost:8080
```

---

## 📡 Core API

| Endpoint                  | Method | Description                   |
| ------------------------- | ------ | ----------------------------- |
| `/students`               | POST   | Register a student            |
| `/students`               | GET    | Fetch all students            |
| `/students/phone/{phone}` | GET    | Fetch student by phone        |
| `/sos`                    | POST   | Trigger SOS request           |
| `/leaderboard`            | GET    | View students ranked by karma |

---

## 📊 Data Models

| Entity      | Fields                                  |
| ----------- | --------------------------------------- |
| **Student** | id, name, phoneNumber, karma            |
| **SOS**     | id, studentId, itemRequested, timestamp |

---

## 📂 Project Structure

```
studentsos/
├── src/main/java/com/studentsos/
│   ├── controller/        (StudentController, SOSController)
│   ├── service/           (StudentService, SOSService, NotificationService)
│   ├── repository/        (StudentRepository, SOSRepository)
│   ├── entity/            (Student, SOS)
│   ├── config/            (WebSocketConfig)
│   └── StudentsosApplication.java
│
├── src/main/resources/
│   └── application.properties
│
├── pom.xml
└── README.md
```

---

## ⚡ System Logic

* Each student has **karma points**
* When a student **triggers an SOS**, karma **decreases**
* Students who rarely trigger SOS maintain **higher karma**
* The **leaderboard ranks students by remaining karma**
* SOS requests are **broadcast instantly via WebSockets**

---

## 🎯 Workflow

Student registers → Logs into system → Presses **SOS** when item is needed →
System deducts karma → SOS alert is broadcast to other students →
Leaderboard reflects student discipline based on karma.
