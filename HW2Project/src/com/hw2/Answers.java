package com.hw2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Manages a collection of Answer objects and supports CRUD operations.
 */
public class Answers {
    private Map<Integer, Answer> answerMap;

    public Answers() {
        answerMap = new HashMap<>();
    }

    /**
     * Adds a new answer to the collection.
     * @param answer The Answer object to add.
     */
    public void addAnswer(Answer answer) {
        if (answer == null) {
            throw new IllegalArgumentException("Answer cannot be null.");
        }
        if (answerMap.containsKey(answer.getId())) {
            throw new IllegalArgumentException("Answer with id " + answer.getId() + " already exists.");
        }
        answerMap.put(answer.getId(), answer);
    }

    /**
     * Retrieves an answer by its ID.
     * @param id The unique identifier for the answer.
     * @return The Answer object or null if not found.
     */
    public Answer getAnswer(int id) {
        return answerMap.get(id);
    }

    /**
     * Updates the text of an answer.
     * @param id The ID of the answer to update.
     * @param newText The new text for the answer.
     */
    public void updateAnswer(int id, String newText) {
        Answer a = answerMap.get(id);
        if (a == null) {
            throw new IllegalArgumentException("Answer not found.");
        }
        a.setText(newText);
    }

    /**
     * Deletes an answer from the collection.
     * @param id The ID of the answer to delete.
     */
    public void deleteAnswer(int id) {
        if (!answerMap.containsKey(id)) {
            throw new IllegalArgumentException("Answer not found.");
        }
        answerMap.remove(id);
    }

    /**
     * Retrieves all answers for a given question.
     * @param questionId The ID of the question.
     * @return A collection of Answer objects associated with the question.
     */
    public Collection<Answer> getAnswersByQuestionId(int questionId) {
        Collection<Answer> result = new ArrayList<>();
        for (Answer a : answerMap.values()) {
            if (a.getQuestionId() == questionId) {
                result.add(a);
            }
        }
        return result;
    }
}
