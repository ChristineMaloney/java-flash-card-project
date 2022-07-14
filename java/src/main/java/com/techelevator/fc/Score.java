package com.techelevator.fc;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Score {

    private int correctCount;
    private int incorrectCount;
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
    private LocalDateTime now = LocalDateTime.now();
    private String dateTime = dtf.format(now);
    private List< String> logList = new ArrayList<>();
    private double score;
    private File newFile;
    private File reportFile;

    public int getCorrectCount() {
        return correctCount;
    }

    public void setCorrectCount(int correctCount) {
        this.correctCount = correctCount;
    }

    public int getIncorrectCount() {
        return incorrectCount;
    }

    public void setIncorrectCount(int incorrectCount) {
        this.incorrectCount = incorrectCount;
    }

    public void correctTally(String line){
        if (line.equals("y")) {
            System.out.println("Yay! Good job!");
            correctCount= getCorrectCount()+1;
        }else {
            System.out.println("Better Luck Next Time!");
            incorrectCount= getIncorrectCount()+1;
        }
    }

    public void score(){
        if(incorrectCount+correctCount == 0){
            System.out.println("answer more questions first!");
        } else {
            score= ((double) correctCount/(double)(incorrectCount+correctCount))*100;
            System.out.println();
            System.out.println("----------------------------------------------------");
            System.out.println("Score " + score+"%");
            System.out.println("Correct Answers " + correctCount);
            System.out.println("Incorrect Answers " + incorrectCount);
            System.out.println("----------------------------------------------------");
        }
    }

    public void logEndScore() {
        String line = dateTime + " Correct Answers:" + correctCount + " Incorrect Answers: " + incorrectCount +  " Score: "+ score + "%";
        logList.add(line);
    }
    public void printScoreHistory(){
        logEndScore();

        try (FileWriter pwFile = new FileWriter("ScoreHistory.txt",true)) {
            for(String s: logList) {
                pwFile.append(s+"\r\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
