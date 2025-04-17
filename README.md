# 🐶 Dog Wellness Tracker

A desktop application built in Java and JavaFX that allows dog owners to log, monitor, and analyze their pet’s daily health and behavior. This app helps identify patterns in your dog's well-being, detect potential issues early, and maintain detailed records over time — all in one place.

---

## Features

### Core Functionality (Must-Haves)
- **Multi-Dog Support:** Add and manage multiple dogs with their unique profiles.
- **Daily Log Entries:** Track appetite, mood, symptoms, medications, and more.
- **Calendar View:** Visualize logs over time with an intuitive calendar interface.
- **Database Storage:** All entries are stored locally using SQLite.
- **Pattern Detection:** Identify recurring symptoms or missed meals to flag potential health issues.
- **Offline Use:** No internet connection required — all data stays on your machine.

###  Bonus Features (Nice-to-Haves)
- **CSV Export:** Export logs for vet visits or long-term storage.
- **Trend Analysis:** Visual summaries of patterns (e.g. mood over time).

---

## 🖼️ Screenshots (optional)
*(Add some screenshots of the UI here to show off the interface)*

---

## 🧱 Tech Stack

- **Java 17**
- **JavaFX (UI)**
- **SQLite (Local Database)**
- **JDBC (Java-Database Connectivity)**
- **MVC Architecture**
- **Git/GitHub (Version Control)**

---

## 🧠 Skills Demonstrated

- Object-Oriented Programming (OOP)
- GUI Design with JavaFX
- Data Persistence using SQLite
- MVC (Model-View-Controller) Pattern
- File I/O for export features
- Pattern recognition logic based on user-generated data
- Clean code practices and modular class design
- Git for source control and branching

---

## 🚶‍♂️ How It Works (User Walkthrough)

1. Launch the app.
2. Create your dog's profile.
3. Each day, log information like mood, appetite, symptoms, and medication.
4. View entries over time in a calendar or list format.
5. Receive alerts if patterns emerge (e.g. three consecutive days of poor appetite).
6. Export logs if needed for vet consultations or analysis.

---

## 🗂️ Folder Structure

```bash
src/
├── controller/
│   └── LogEntryController.java
│   └── DogProfileController.java
├── model/
│   └── LogEntry.java
│   └── DogProfile.java
├── view/
│   └── main.fxml
│   └── log_entry.fxml
├── database/
│   └── DatabaseManager.java
└── Main.java
