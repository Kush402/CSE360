package com.hw2;

/**
 * Represents an answer with a unique ID, associated question ID, and answer text.
 */
public class Answer {
    private int id;
    private int questionId;
    private String text;

    /**
     * Constructor for creating an Answer.
     * @param id Unique identifier for the answer.
     * @param questionId The ID of the question this answer is associated with.
     * @param text The text of the answer.
     * @throws IllegalArgumentException if text is null or empty.
     */
    public Answer(int id, int questionId, String text) {
        if (text == null || text.trim().isEmpty()) {
            throw new IllegalArgumentException("Answer text cannot be empty.");
        }
        this.id = id;
        this.questionId = questionId;
        this.text = text;
    }

    // Getters and Setters
    public int getId() { return id; }
    
    public int getQuestionId() { return questionId; }
    
    public String getText() { return text; }
    
    public void setText(String text) {
        if (text == null || text.trim().isEmpty()) {
            throw new IllegalArgumentException("Answer text cannot be empty.");
        }
        this.text = text;
    }
    
    @Override
    public String toString() {
        return "Answer [id=" + id + ", questionId=" + questionId + ", text=" + text + "]";
    }
}
