package com.hw2;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a question with a unique ID, text, and associated answers.
 */
public class Question {
    private int id;
    private String text;
    private List<Answer> answers;

    /**
     * Constructor for creating a Question.
     * @param id Unique identifier for the question.
     * @param text The text of the question.
     * @throws IllegalArgumentException if text is null or empty.
     */
    public Question(int id, String text) {
        if (text == null || text.trim().isEmpty()) {
            throw new IllegalArgumentException("Question text cannot be empty.");
        }
        this.id = id;
        this.text = text;
        this.answers = new ArrayList<>();
    }

    // Getters and Setters
    public int getId() { return id; }
    
    public String getText() { return text; }
    
    public void setText(String text) {
        if (text == null || text.trim().isEmpty()) {
            throw new IllegalArgumentException("Question text cannot be empty.");
        }
        this.text = text;
    }
    
    public List<Answer> getAnswers() { return answers; }
    
    /**
     * Adds an answer to the question.
     * @param answer The Answer object to add.
     */
    public void addAnswer(Answer answer) {
        if (answer == null) {
            throw new IllegalArgumentException("Answer cannot be null.");
        }
        answers.add(answer);
    }
    
    /**
     * Removes an answer from the question.
     * @param answer The Answer object to remove.
     * @return true if the answer was removed; false otherwise.
     */
    public boolean removeAnswer(Answer answer) {
        return answers.remove(answer);
    }
    
    @Override
    public String toString() {
        return "Question [id=" + id + ", text=" + text + "]";
    }
}
