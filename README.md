# Advanced Programming Final Project

## Student Information
- Name: [Samir Khalaf]
- ID: [241008009]
- Course: Advanced Programming

## Project Description
A Multi-Threaded File Processing System that reads student grade data from multiple files concurrently using threads, processes and validates the grades, calculates statistics, and generates formatted reports. The system demonstrates OOP principles, exception handling, multi-threading with synchronization, and file I/O operations.

## How to Compile and Run

### Using IntelliJ IDEA:
1. Open IntelliJ IDEA → `File` → `Open` → select the project folder
2. Right-click the `src` folder → **Mark Directory as → Sources Root**
3. Open `Main.java` (in `src/`)
4. Click the green ▶ **Run** button
5. Reports will be generated in the `reports/` folder

### Using Command Line:
```bash
cd adv-programming-final-project
javac -d out -sourcepath src src/Main.java
java -cp out Main
```

## Features Implemented
- [x] Encapsulation and OOP Relationships (Association, Aggregation, Composition)
- [x] Abstraction and Polymorphism (Abstract GradeProcessor, GradeAnalyzer override)
- [x] Exception Handling (InvalidDataException, InvalidGradeException, FileProcessingException)
- [x] Multi-threading and Synchronization (StudentFileReader, GradeCalculatorTask)
- [x] File I/O Operations (FileInputService with Scanner, ReportGenerator with PrintWriter)
- [x] Thread Safety and Deadlock Prevention (ThreadSafeGradeRepository, ResourceManager)

## Project Structure
```
adv-programming-final-project/
├── src/
│   ├── model/
│   │   ├── Student.java
│   │   └── Course.java
│   ├── processor/
│   │   ├── GradeProcessor.java   (abstract)
│   │   └── GradeAnalyzer.java
│   ├── exception/
│   │   ├── InvalidDataException.java
│   │   ├── InvalidGradeException.java
│   │   └── FileProcessingException.java
│   ├── thread/
│   │   ├── StudentFileReader.java     (extends Thread)
│   │   ├── GradeCalculatorTask.java   (implements Runnable)
│   │   ├── ThreadSafeGradeRepository.java
│   │   └── ResourceManager.java
│   ├── io/
│   │   ├── FileInputService.java
│   │   ├── ReportGenerator.java
│   │   └── GradeReportGenerator.java
│   └── Main.java
├── data/
│   ├── students_1.txt
│   ├── students_2.txt
│   └── students_3.txt
├── reports/
│   └── (generated reports appear here)
├── README.md
└── .gitignore
```

## Sample Output
```
==========================================
  Student Grade Processing System
==========================================

[Setup] Sample files created in data/

--- Reading student files ---
[Thread] Starting to read: data/students_1.txt
[Thread] Starting to read: data/students_2.txt
[Thread] Starting to read: data/students_3.txt
[Repository] Stored: Asaad Rami
...
Total students loaded: 9

--- Validating and Analyzing Grades ---
Asaad Rami -> Highest: 92.0 | Lowest: 78.0 | Average: 86.25 | Std Dev: 5.15
...

==========================================
         GRADE SUMMARY REPORT
==========================================
Course: CS244 - Advanced Programming
Total Students: 9
Class Average: 74.5

Grade Distribution:
A: 2 students (22%)
B: 3 students (33%)
...
Top Student: S009 - Ziad Tarek (94.0)
==========================================
```

## Challenges Faced
- **Thread synchronization**: Making sure data added by reader threads is visible to the reporter thread. Solved by using `synchronized` methods with `wait()` and `notifyAll()`.
- **Deadlock prevention**: Understanding lock ordering and always acquiring locks in the same order across all threads.
- **File parsing**: Handling malformed lines and invalid grade values gracefully using try-catch for `NumberFormatException`.
