# 🚨 Student-SOS

A real-time campus emergency request system that allows students to instantly broadcast SOS alerts when they urgently need essential items during exams, practicals, or class sessions.

---

# ✨ Features

- 📡 Real-time SOS broadcasting using WebSocket (STOMP over SockJS)
- 📱 Phone-number-based identity system with zero password friction
- 🧮 Karma discipline system where each SOS costs 5 karma points
- 🏆 Live leaderboard ranking students by remaining karma
- 🗂️ Persistent SOS history stored in MySQL
- 👥 Student directory with karma standings
- 🔒 Optimistic locking using `@Version` for safe concurrent updates

---

# 🏗️ Tech Stack

| Layer | Technology |
|---|---|
| Backend | Java 17, Spring Boot |
| Database | MySQL, Spring Data JPA, Hibernate |
| Real-Time Communication | Spring WebSocket, STOMP, SockJS |
| Concurrency Handling | JPA Optimistic Locking (`@Version`) |
| Build Tool | Maven |
| Frontend | HTML, CSS, JavaScript |

---

# 🚀 Quick Start

## Prerequisites

- Java 17+
- MySQL Server
- Maven

---

## Setup

### 1. Clone Repository

```bash
git clone <repo-url>
cd studentsos
```

### 2. Create Database

```sql
CREATE DATABASE studentsos;
```

### 3. Configure `application.properties`

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/studentsos
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
```

### 4. Run Backend

```bash
mvn spring-boot:run
```

Backend will start at:

```text
http://localhost:8080
```

### 5. Launch Frontend

Open:

```text
index.html
```

directly in the browser.

No frontend server required.

---

# 📡 API Reference

## Student APIs

| Endpoint | Method | Description |
|---|---|---|
| `/students` | POST | Register new student |
| `/students` | GET | Get all students |
| `/students/phone/{phone}` | GET | Get student by phone number |
| `/students/leaderboard` | GET | Get students ranked by karma |

---

## SOS APIs

| Endpoint | Method | Description |
|---|---|---|
| `/sos/{phoneNumber}?item=&location=` | POST | Trigger SOS and deduct karma |
| `/sos` | GET | Retrieve all SOS requests |

---

# 📡 WebSocket Configuration

| Property | Value |
|---|---|
| Endpoint | `/ws` |
| Protocol | STOMP over SockJS |
| Topic Subscription | `/topic/sos` |
| Payload Format | Plain Text |

---

# 📊 Data Models

## Student Entity

| Field | Type | Description |
|---|---|---|
| id | Long | Auto-generated primary key |
| name | String | Required |
| phoneNumber | String | Unique 10-digit number |
| karma | Integer | Default value: `100` |
| version | Long | Optimistic locking field |

---

## SosRequest Entity

| Field | Type | Description |
|---|---|---|
| id | Long | Auto-generated primary key |
| student | Student | Foreign key reference |
| timestamp | LocalDateTime | Automatically generated |

> `item` and `location` are intentionally not persisted in the entity.
> They are passed as request parameters and broadcast through WebSocket in real time.

---

# 📂 Project Structure

```text
studentsos/
│
├── src/main/java/com/studentsos/studentsos/
│   ├── config/
│   │   └── WebSocketConfig.java
│   │
│   ├── controller/
│   │   ├── StudentController.java
│   │   └── SosController.java
│   │
│   ├── dto/
│   │   ├── StudentDTO.java
│   │   └── SosRequestDTO.java
│   │
│   ├── entity/
│   │   ├── Student.java
│   │   └── SosRequest.java
│   │
│   ├── repository/
│   │   ├── StudentRepository.java
│   │   └── SosRepository.java
│   │
│   ├── service/
│   │   ├── StudentService.java
│   │   ├── SosService.java
│   │   └── NotificationService.java
│   │
│   └── StudentsosApplication.java
│
├── src/main/resources/
│   └── application.properties
│
├── index.html
└── pom.xml
```

---

# ⚡ System Logic

```text
Student Registers
      │
      ▼
Initial Karma = 100
      │
      ▼
Student Sends SOS
      │
      ├── If karma < 5
      │       → Request Rejected
      │
      └── If karma ≥ 5
              → Deduct 5 Karma
              → Save SOS Record
              → Broadcast Alert via WebSocket
```

All connected clients instantly receive the SOS notification.

Leaderboard rankings automatically update based on remaining karma.

---

# 🎯 Workflow

```text
Register
   ↓
Login
   ↓
Enter Item + Location
   ↓
Broadcast SOS
   ↓
5 Karma Deducted
   ↓
SOS Stored in MySQL
   ↓
Real-Time WebSocket Broadcast
   ↓
All Connected Students Receive Alert
```

---

# 🧠 Core Design Concepts

- Karma functions as a natural rate limiter
- No admin moderation required
- Optimistic locking prevents lost concurrent updates
- Real-time communication minimizes response delay
- Minimal-friction authentication improves usability during emergencies

---

# 🔮 Future Scope

- ✅ Lender acceptance workflow
- ✅ Karma rewards for successful fulfillment
- ✅ SOS auto-expiry using Spring `@Scheduled`
- ✅ Urgency levels (Low / Medium / High)
- ✅ SMS fallback notifications
- ✅ Android / iOS mobile application

---

# 👥 Team

Built as a Semester IV Mini Project  
Department of Computer Engineering  
University of Mumbai

---
