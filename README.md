🐾 PAWS - Pet Activity & Wellness System

A Java-based desktop application that allows pet owners to log, monitor, and analyze their pet’s daily wellbeing. PAWS helps identify trends in a pet’s health, highlight potential issues early, and maintain detailed records over time — all stored locally on the user’s machine.

✨ Features
Core Functionality (Must-Haves)

Pet Profiles: Create and manage one or more pet profiles (name, breed, age, weight, date of birth, etc.), saved with SQLite.

Daily Log Entries: Record daily wellbeing data such as mood, energy level, appetite, symptoms, notes, and custom tags.

Log Storage & Retrieval: All logs are stored in SQLite and retrieved per pet profile; prevents duplicate entries for the same day.

View Past Logs: Review logs in a table or list format with sorting and filtering by date, mood, or energy level.

CSV Export: Export selected logs to a CSV file with headers, formatted for easy sharing with a veterinarian.

Pattern & Trend Analyzer: Detect recurring issues (e.g., low energy 3+ days, loss of appetite, repeated symptoms) and highlight potential health risks or conditions. Provides non-diagnostic suggestions to help owners decide if a vet visit may be needed.

Basic JavaFX UI: Simple, clean interface for pet profiles, logging, log viewing, exporting, and navigation. Includes optional light/dark theme toggle.

Nice-to-Haves (Future Additions)

Data Visualizations: Charts for mood and energy trends over time.

Multi-Day Summary: Weekly/monthly summaries showing averages and common tags.

Advanced Search & Filters: Filter logs by keyword, date range, or symptom.

Reminders & Notifications: Alerts for missed entries or daily reminders.

Data Backup & Restore: Export/import the full database for backups.

Stretch Goals

Login System (Local): Optional secure login with hashed passwords.

Multi-Language Support: Resource bundles to support multiple languages.

Expanded Pet Support: Extend beyond dogs to include cats and other species.

🧱 Tech Stack

Java (main language)

JavaFX (UI)

SQLite (local database)

JDBC (database connection)

File I/O (CSV export)

OOP design principles

Git/GitHub (version control)

🧠 Skills Demonstrated

Object-Oriented Programming (OOP)

GUI design with JavaFX

Data persistence with SQLite

Database integration with JDBC

Pattern detection and basic data analysis

File handling for CSV export and backups

MVC-inspired design for organization

Git for version control and collaboration

🚶 How It Works (User Walkthrough)

Launch the app.

Create a pet profile with details like name, breed, age, and weight.

Each day, log your pet’s mood, appetite, energy, and symptoms.

View entries in a clean table or list with filtering and sorting.

Get alerts if recurring patterns or potential risks are detected.

Export logs to CSV to share with your veterinarian.
