package com.techelevator.fc;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.io.*;

public class FlashCardManager {

    private Map<Integer, QuestionAnswer> flashcards;

    private Random random;

    private int totalNumberOfQuestions;

    private double score=0;

    public FlashCardManager() {
        random = new Random();
        loadFlashCards();
    }

    public void loadFlashCards(){
        flashcards = new HashMap<>();
        try(BufferedReader br =
                    new BufferedReader(new FileReader(
                            "C:\\Users\\Chase Java\\workspace\\christinemaloney-java\\course-extras\\flash-cards\\FlashCardData.txt"));)

        {
            String line = null;
            boolean isQuestion = true;
            int counter = 1;
            QuestionAnswer qa = null;
            while ((line = br.readLine()) != null) {
                if(line.length()<5){
                    continue;
                }
                if (isQuestion){
                    qa = new QuestionAnswer(counter, line, DifficultyLevel.BASIC);
                } else {
                    qa.setAnswer(line);
                    flashcards.put(qa.getId(), qa);
                    counter++;
                }
                isQuestion = !isQuestion;
            }
        } catch (IOException e){
            System.out.println("Error opening file: " + e.getMessage());
            createMockFlashCards();
        }
        totalNumberOfQuestions = flashcards.size();
    }

    public QuestionAnswer getNextFlashCard(){
        int index = 0;
        do {
            index = random.nextInt(totalNumberOfQuestions);
        } while (!(index > 0));
        return flashcards.get(index);
    }

    private void createMockFlashCards(){
        for (int i=0; i < 100; i++){
            createMockFlashCard(i);
        }
    }

    private void createMockFlashCard(int key){
        QuestionAnswer qa = new QuestionAnswer(key,
            "Question " + key,
            "Answer " + key,
            DifficultyLevel.BASIC);
        flashcards.put(key, qa);
    }




}
