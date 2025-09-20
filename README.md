# 🐾 PAWS — Pet Activity & Wellness System

A desktop application built in **Java** and **JavaFX** that allows pet owners to log, monitor, and analyze their pet’s daily wellbeing. This app helps identify and graph patterns in your pet’s health, detect potential health risks early, and maintain detailed records over time — all on your machine.

---

## Features

### Core Functionality (Must-Haves)

- **Pet Profiles:** Create and manage one or more pet profiles (name, breed, age, weight, date of birth, etc.), saved with SQLite.
- **Daily Log Entries:** Record daily wellbeing data such as mood, energy level, appetite, symptoms, notes, and custom tags.
- **Log Storage & Retrieval:** All logs are stored in SQLite and retrieved per pet profile; prevents duplicate entries for the same day.
- **View Past Logs:** Review logs in a table or list format with sorting and filtering by date, mood, or energy level.
- **CSV Export:** Export selected logs to a CSV file with headers, formatted for easy sharing with a veterinarian.
- **Pattern & Trend Analyzer:** Detect recurring issues (e.g., low energy 3+ days, loss of appetite, repeated symptoms) and highlight potential health risks or conditions. Provides non-diagnostic suggestions to help owners decide if a vet visit may be needed.
- **Basic JavaFX UI:** Simple, clean interface for pet profiles, logging, log viewing, exporting, and navigation. Includes optional light/dark theme toggle.
- **Data Visualizations:** Charts for mood and energy trends over time.
  
### Bonus Features (Nice-to-Haves)

- **Multi-Day Summary:** Weekly/monthly summaries showing averages and common tags.
- **Advanced Search & Filters:** Filter logs by keyword, date range, or symptom.
- **Reminders & Notifications:** Alerts for missed entries or daily reminders.
- **Data Backup & Restore:** Export/import the full database for backups.

### Stretch Goals

- **Login System (Local):** Optional secure login with hashed passwords.
- **Multi-Language Support:** Resource bundles to support multiple languages.
- **Expanded Pet Support:** Extend beyond dogs to include cats and other species.

---

## 🧱 Tech Stack

- Java  
- JavaFX (UI)  
- SQLite (Local Database)  
- JDBC (Database Connectivity)  
- File I/O (CSV Export)  
- OOP Design Principles  
- Git/GitHub (Version Control)

---

## 🧠 Skills Demonstrated

- Object-Oriented Programming (OOP)  
- GUI Design with JavaFX  
- Data Persistence using SQLite  
- Database Integration with JDBC  
- Pattern Recognition and Basic Data Analysis  
- File I/O for CSV Export and Backups  
- MVC-Inspired Application Design  
- Git for Source Control and Branching

---

## 🚶 How It Works (User Walkthrough)

1. **Launch** the app.
2. **Create** a pet profile with details like name, breed, age, and weight.
3. **Log daily** information such as mood, appetite, energy, symptoms, and notes.
4. **View** entries in a clean table or list format with sorting and filtering.
5. **Receive alerts** if recurring patterns or potential health risks are detected.
6. **Export** logs to CSV for veterinary consultations or personal tracking.
