package com.hw2;

import java.util.Scanner;

/**
 * Interactive main class to demonstrate CRUD operations for questions and answers.
 */
public class HW2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Questions questions = new Questions();
        Answers answers = new Answers();

        while (true) {
            System.out.println("Select an option:");
            System.out.println("1. Create Question");
            System.out.println("2. View All Questions");
            System.out.println("3. Update Question");
            System.out.println("4. Delete Question");
            System.out.println("5. Create Answer");
            System.out.println("6. View Answers for a Question");
            System.out.println("7. Update Answer");
            System.out.println("8. Delete Answer");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch(choice) {
                case 1:
                    // Create a new Question
                    try {
                        System.out.print("Enter Question ID (integer): ");
                        int qid = scanner.nextInt();
                        scanner.nextLine(); // consume newline
                        System.out.print("Enter Question Text: ");
                        String qtext = scanner.nextLine();
                        Question newQuestion = new Question(qid, qtext);
                        questions.addQuestion(newQuestion);
                        System.out.println("Question created successfully.");
                    } catch(Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 2:
                    // View all Questions
                    if(questions.getAllQuestions().isEmpty()){
                        System.out.println("No questions available.");
                    } else {
                        System.out.println("=== All Questions ===");
                        for(Question q : questions.getAllQuestions()){
                            System.out.println(q);
                        }
                    }
                    break;
                case 3:
                    // Update a Question
                    try {
                        System.out.print("Enter Question ID to update: ");
                        int qid = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter new Question Text: ");
                        String newText = scanner.nextLine();
                        questions.updateQuestion(qid, newText);
                        System.out.println("Question updated successfully.");
                    } catch(Exception e){
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 4:
                    // Delete a Question (and its associated answers)
                    try {
                        System.out.print("Enter Question ID to delete: ");
                        int qid = scanner.nextInt();
                        scanner.nextLine();
                        Question qToDelete = questions.getQuestion(qid);
                        if(qToDelete != null) {
                            // Remove all associated answers
                            for(Answer a : qToDelete.getAnswers()){
                                answers.deleteAnswer(a.getId());
                            }
                        }
                        questions.deleteQuestion(qid);
                        System.out.println("Question deleted successfully.");
                    } catch(Exception e){
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 5:
                    // Create a new Answer
                    try {
                        System.out.print("Enter Answer ID (integer): ");
                        int aid = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter Question ID for this answer: ");
                        int qid = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter Answer Text: ");
                        String atext = scanner.nextLine();
                        Answer newAnswer = new Answer(aid, qid, atext);
                        answers.addAnswer(newAnswer);
                        // If the question exists, add the answer to it
                        Question q = questions.getQuestion(qid);
                        if(q != null){
                            q.addAnswer(newAnswer);
                        } else {
                            System.out.println("Warning: Question with ID " + qid + " not found. Answer stored only in Answers collection.");
                        }
                        System.out.println("Answer created successfully.");
                    } catch(Exception e){
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 6:
                    // View Answers for a specific Question
                    try {
                        System.out.print("Enter Question ID: ");
                        int qid = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("=== Answers for Question " + qid + " ===");
                        if(answers.getAnswersByQuestionId(qid).isEmpty()){
                            System.out.println("No answers available for this question.");
                        } else {
                            for(Answer a : answers.getAnswersByQuestionId(qid)){
                                System.out.println(a);
                            }
                        }
                    } catch(Exception e){
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 7:
                    // Update an Answer
                    try {
                        System.out.print("Enter Answer ID to update: ");
                        int aid = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter new Answer Text: ");
                        String newText = scanner.nextLine();
                        answers.updateAnswer(aid, newText);
                        System.out.println("Answer updated successfully.");
                    } catch(Exception e){
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 8:
                    // Delete an Answer
                    try {
                        System.out.print("Enter Answer ID to delete: ");
                        int aid = scanner.nextInt();
                        scanner.nextLine();
                        Answer aToDelete = answers.getAnswer(aid);
                        if(aToDelete != null){
                            Question q = questions.getQuestion(aToDelete.getQuestionId());
                            if(q != null){
                                q.getAnswers().remove(aToDelete);
                            }
                        }
                        answers.deleteAnswer(aid);
                        System.out.println("Answer deleted successfully.");
                    } catch(Exception e){
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 9:
                    System.out.println("Exiting application.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
            System.out.println(); // blank line for formatting
        }
    }
}