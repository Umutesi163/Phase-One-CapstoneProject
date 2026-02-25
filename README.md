# phase one capstone project
# Phase One Capstone Project: University Management System

A logic-driven academic system built with **Java OOP & Collections**, featuring student enrollment, course management, tuition calculation, and file persistence.

# Learning Outcomes
- Applied **OOP principles**: inheritance, polymorphism, encapsulation.
- Used **Java Collections** (`List`, `Map`) to model student-course relationships.
- Implemented **custom exceptions** for enrollment rules.
- Enabled **file persistence** using `java.io`.
- Practiced **Git/GitHub** workflows with branching and merging.

#  Features
- Register students and instructors.
- Create and manage courses.
- Enroll students with validation.
- View student records and grades.
- Generate Dean’s List (GPA > 3.5).
- Save/load data via `students.dat` and `courses.dat`.
  #  why serializable (person class)
  | Concept            | Explanation                                                                 |
| ------------------ | --------------------------------------------------------------------------- |
| `serialVersionUID` | Unique identifier for serialized class versions                             |
| Purpose            | Ensure deserialization matches the right class version                      |
| When to define     | Always, if class implements `Serializable` and you persist objects          |
| Recommended value  | Start with `1L`; increment if class changes break compatibility             |
| Optional?          | Yes, Java will generate one automatically, but explicit definition is safer |




# Project Structure  
Phase-One-CapstoneProject/ ├── Lab1/ # OOP Design: Person, Student, Course and instructor ├── Lab2/ # Business Logic: UniversityManager, Exceptions ├── Lab3/ # File I/O: FileManager, Console Menu ├── src/ # Main application classes └── README.md # This file

#  How to Run
1. Clone the repo:
   `bash'
   git clone https://github.com/Umutesi163/Phase-One-CapstoneProject.git   
#  compile and run Main.java in IntelliJ or via terminal:
javac Main.java
java Main
#  Persistence
Data is saved to students.dat and courses.dat on exit.
Files are auto-loaded on startup.
#  Version Control
Branches: Lab1, Lab2, Lab3
Merged into main for final submission.
#  License
This project is open-source and available for educational use.
