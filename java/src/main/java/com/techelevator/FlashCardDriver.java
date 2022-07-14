package com.techelevator;

import com.techelevator.fc.FlashCardManager;
import com.techelevator.view.Menu;
import com.techelevator.fc.QuestionAnswer;
import com.techelevator.fc.Score;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FlashCardDriver {
    private static final String MAIN_MENU_OPTION_QUESTION = "Ask me a question";
    private static final String MAIN_MENU_OPTION_SCORE = "Tell me my score";
    private static final String MAIN_MENU_OPTION_EXIT= "I'm done for now!";

    private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_QUESTION, MAIN_MENU_OPTION_SCORE ,MAIN_MENU_OPTION_EXIT};

    private static final String QUESTION_CORRECT_YES = "My answer was correct";
    private static final String QUESTION_CORRECT_NO = "My answer was incorrrect";

    private static final String[] QUESTION_CORRECT_OPTIONS = {QUESTION_CORRECT_YES, QUESTION_CORRECT_NO};

    private Menu menu;
    private Score score;
    private File newFile;


    public FlashCardDriver(Menu menu,Score score, File newFile) {

        this.menu = menu;
        this.score= score;
        this.newFile=newFile;
    }

    public void run() {

        while (true) {
            FlashCardManager fcm = new FlashCardManager();

            String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

            if (choice.equals(MAIN_MENU_OPTION_QUESTION)) {

                QuestionAnswer currentFC = fcm.getNextFlashCard();
                System.out.print(currentFC.getQuestion() + " ");
                Scanner scanner = new Scanner(System.in);
                String answer = scanner.nextLine();
                System.out.print(currentFC.getAnswer());
                String line = scanner.nextLine();

                String choice2 = (String) menu.getChoiceFromOptions(QUESTION_CORRECT_OPTIONS);
                if(choice2.equals(QUESTION_CORRECT_YES)){
                    score.correctTally("y");
                } else if(choice2.equals(QUESTION_CORRECT_NO)){
                    score.correctTally("n");
                }
            }

            else if (choice.equals(MAIN_MENU_OPTION_SCORE)){

                score.score();

            }
            else if (choice.equals(MAIN_MENU_OPTION_EXIT)){
                score.score();
                score.printScoreHistory();
                System.exit(1);
            }
        }
    }

    public static void main(String[] args) {
        FlashCardManager fcm = new FlashCardManager();
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu(System.in, System.out);
        Score score = new Score();
        File newFile = new File("ScoreHistory.txt");

        System.out.print("Do you want to type your answers (y/n)? ");
        String line = scanner.nextLine();
        boolean isTypeAnswer = !(line.startsWith("n"));

       do {

            FlashCardDriver fcd = new FlashCardDriver(menu, score, newFile);

           try {
               newFile.createNewFile();
           } catch (IOException e) {
               System.out.println(e.getMessage());
           }

           fcd.run();
       }
            while (!(line.startsWith("n"))) ;

        }
    }

