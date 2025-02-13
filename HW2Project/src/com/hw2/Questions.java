package com.hw2;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Manages a collection of Question objects and supports CRUD operations.
 */
public class Questions {
    private Map<Integer, Question> questionMap;

    public Questions() {
        questionMap = new HashMap<>();
    }

    /**
     * Adds a new question to the collection.
     * @param question The Question object to add.
     */
    public void addQuestion(Question question) {
        if (question == null) {
            throw new IllegalArgumentException("Question cannot be null.");
        }
        if (questionMap.containsKey(question.getId())) {
            throw new IllegalArgumentException("Question with id " + question.getId() + " already exists.");
        }
        questionMap.put(question.getId(), question);
    }

    /**
     * Retrieves a question by its ID.
     * @param id The unique identifier for the question.
     * @return The Question object or null if not found.
     */
    public Question getQuestion(int id) {
        return questionMap.get(id);
    }

    /**
     * Updates the text of a question.
     * @param id The ID of the question to update.
     * @param newText The new text for the question.
     */
    public void updateQuestion(int id, String newText) {
        Question q = questionMap.get(id);
        if (q == null) {
            throw new IllegalArgumentException("Question not found.");
        }
        q.setText(newText);
    }

    /**
     * Deletes a question from the collection.
     * @param id The ID of the question to delete.
     */
    public void deleteQuestion(int id) {
        if (!questionMap.containsKey(id)) {
            throw new IllegalArgumentException("Question not found.");
        }
        questionMap.remove(id);
    }

    /**
     * Returns all stored questions.
     * @return A collection of Question objects.
     */
    public Collection<Question> getAllQuestions() {
        return questionMap.values();
    }
}
