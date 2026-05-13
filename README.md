# 🐾 PAWS — Pet Activity & Wellness System

PAWS is a **local-first full-stack pet wellness application** built with **Java, Spring Boot, React, and SQLite**. It helps pet owners record daily wellness logs, view health trend dashboards, and maintain detailed pet health records locally on their machine.

The goal of PAWS is to give pet owners a structured way to track patterns in their pet’s wellbeing over time. The app is **non-diagnostic** and is designed to surface wellness trends, repeated symptoms, and potential health-related concerns that may help users decide when to seek veterinary advice.

---

## Key Features

- **Pet Profiles**  
  Create and manage pet profiles with details such as name, species, breed, age, weight, and date of birth.

- **Daily Wellness Logs**  
  Record daily information including mood, energy level, appetite, symptoms, notes, and custom observations.

- **Local Data Storage**  
  Store pet profiles and daily logs locally using SQLite, keeping records on the user’s machine instead of relying on cloud storage.

- **Trend Dashboards**  
  View trends over time for wellness factors such as energy, appetite, mood, weight, and repeated symptoms.

- **PatternAnalyzer System**  
  Analyze logged symptoms against species-specific illness datasets to surface non-diagnostic wellness insights and potential health-related risks.

- **Species-Specific Illness Datasets**  
  Support symptom-pattern analysis using structured datasets for different pet species.

- **REST API Backend**  
  Use Spring Boot REST API endpoints to manage pets, logs, trend metrics, and analysis results.

- **React Frontend**  
  Provide a clean user interface for creating profiles, entering logs, viewing records, and reviewing trend-based insights.

---

## Tech Stack

### Frontend
- React
- JavaScript / TypeScript
- HTML/CSS
- Tailwind CSS

### Backend
- Java
- Spring Boot
- REST APIs
- Maven
- JUnit

### Database
- SQLite
- JDBC

### Tools
- Git/GitHub
- IntelliJ IDEA
- VS Code

---

## Skills Demonstrated

- Java backend development
- Spring Boot REST API design
- Full-stack application architecture
- React frontend development
- SQLite/JDBC database persistence
- Object-oriented programming
- MVC-inspired application structure
- Data modeling
- JUnit testing
- Local-first software design
- Non-diagnostic pattern analysis
- Git/GitHub version control

---

## Application Architecture

PAWS uses a local-first full-stack architecture:

```text
React Frontend  →  Spring Boot REST API  →  SQLite Database
