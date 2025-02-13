# CSE360
360 projects
Question-Answer Management System

Project Overview

This is a standalone Java console application that allows users to manage questions and answers using CRUD (Create, Read, Update, Delete) operations. The system includes interactive input handling to add, modify, and remove both questions and answers while ensuring proper validation.

Features

✅ Create, View, Update, and Delete Questions
✅ Create, View, Update, and Delete Answers (linked to specific questions)
✅ Data Storage Using HashMap Collections
✅ User Input Validation (No Empty Entries, Unique IDs, etc.)
✅ Interactive Console-Based Menu for User Interaction

Project Structure

📂 src/com/hw2
   ├── Answer.java        # Defines the Answer class
   ├── Answers.java       # Manages a collection of answers
   ├── Question.java      # Defines the Question class
   ├── Questions.java     # Manages a collection of questions
   ├── HW2.java           # Main interactive program with menu-based input
Class Descriptions

1. Question.java
Represents a question with an ID, text, and a list of answers.
Ensures text is not empty and maintains a list of related answers.
2. Answer.java
Represents an answer linked to a question.
Stores answer ID, question ID, and the answer text.
Ensures text is not empty.
3. Questions.java
Manages a collection of Question objects using a HashMap.
Supports CRUD operations (add, get, update, delete).
Allows retrieval of all questions.
4. Answers.java
Manages a collection of Answer objects using a HashMap.
Supports CRUD operations (add, get, update, delete).
Retrieves all answers associated with a specific question.
5. HW2.java
Main entry point of the application.
Provides an interactive console menu for users to:
Create, view, update, or delete questions.
Create, view, update, or delete answers.
Handle validation (e.g., unique IDs, empty text handling).
Installation & Setup

Prerequisites
Ensure you have the following installed:

Java Development Kit (JDK) 8 or later
Eclipse IDE (Optional, for development)
Steps to Run
Clone the Repository
git clone https://github.com/yourusername/QuestionAnswerSystem.git
cd QuestionAnswerSystem
Compile the Java Files
javac -d bin src/com/hw2/*.java
Run the Application
java -cp bin com.hw2.HW2
Usage Guide

Interactive Menu Options
1. Create Question
2. View All Questions
3. Update Question
4. Delete Question
5. Create Answer
6. View Answers for a Question
7. Update Answer
8. Delete Answer
9. Exit
Example Interactions
Creating a Question

Enter your choice: 1
Enter Question ID (integer): 1
Enter Question Text: What is Merge Sort?
Question created successfully.
Viewing All Questions

Enter your choice: 2
=== All Questions ===
Question [id=1, text=What is Merge Sort?]
Creating an Answer

Enter your choice: 5
Enter Answer ID (integer): 1
Enter Question ID for this answer: 1
Enter Answer Text: Merge Sort is a divide-and-conquer sorting algorithm.
Answer created successfully.
Updating a Question

Enter your choice: 3
Enter Question ID to update: 1
Enter new Question Text: What is Quick Sort?
Question updated successfully.
Deleting a Question

Test Cases

Ensure unique question IDs are enforced.
Ensure unique answer IDs are enforced.
Ensure empty questions and answers are not allowed.
Verify CRUD operations for both questions and answers.
Confirm that deleting a question removes its associated answers.
Validate that searching for answers to a deleted question returns an empty result.
