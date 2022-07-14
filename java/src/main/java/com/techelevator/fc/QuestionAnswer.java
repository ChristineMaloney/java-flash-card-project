package com.techelevator.fc;

public class QuestionAnswer {

    private int id;

    private String question;

    private String answer;

    private DifficultyLevel difficultyLevel;

    public QuestionAnswer() {}

    public QuestionAnswer(int id, String question, String answer, DifficultyLevel difficultyLevel) {
        this.id = id;
        this.question = question;
        this.answer = answer;
        this.difficultyLevel = difficultyLevel;
    }

    public QuestionAnswer(int id, String question, DifficultyLevel difficultyLevel) {
        this(id, question, null, difficultyLevel);
    }

    public QuestionAnswer(String question, String answer) {
        this(0, question, answer, DifficultyLevel.BASIC);
    }

    public int getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public DifficultyLevel getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(DifficultyLevel difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    @Override
    public String toString() {
        return "QuestionAnswer{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", difficultyLevel=" + difficultyLevel +
                '}';
    }
}
