package QuizGame;


import java.util.ArrayList;
import java.util.Scanner;
import QuizGame.GenerateQuestion;
import QuizGame.Players;

import static QuizGame.Players.players;


public class Game {

    public static void Start(int QuestionNbr){
        int Score = 0;
        GenerateQuestion quiz = new GenerateQuestion();

        ArrayList<Players> players = players();

        for(Players player : players){

            ArrayList<GenerateQuestion.Question> questions = quiz.Generate(QuestionNbr);

            System.out.println("--------------------------------------------------");
            if (players.size()>1) {
                System.out.printf(">>> %s's turn! Press Enter to start...%n", player.getName());
                Players.scanner.nextLine();
            }
            int qCount = 1;
            for (GenerateQuestion.Question question : questions) {
                System.out.printf("Question %d/%d: %s%n", qCount++, QuestionNbr, question.getQuestion());
                System.out.print("> ");
                String Answer = player.play();

                if (Answer.equalsIgnoreCase(question.getAnswers())) {
                    System.out.println("Correct! Well done.");
                    Score++;
                } else {
                    System.out.printf("Incorrect. The correct answer was: %s%n", question.getAnswers());
                }
            }
            player.setScore(Score);
            questions.clear();
            Score = 0;
        }
        System.out.println("--------------------------------------------------");
        displayResult(players,QuestionNbr);
        System.out.println("\nGame ended ...... \n Press Enter to exit");
        Players.scanner.nextLine();
    }

    public static void displayResult(ArrayList<Players> players, int nbrQuestion){
        System.out.println("\n==================================================");
        System.out.println("                FINAL STANDINGS");
        System.out.println("==================================================");

        if (players.size() == 1){
            System.out.printf("Your final score is: %d/%d%n", players.get(0).getScore(), nbrQuestion);
        } else {
            Players winner = players.get(0);
            boolean tie = false;

            for (Players player : players) {
                System.out.printf("%s's score: %d/%d%n", player.getName(), player.getScore(), nbrQuestion);
                if (player != winner) {
                    if (player.getScore() > winner.getScore()) {
                        winner = player;
                        tie = false;
                    } else if (player.getScore() == winner.getScore()) {
                        tie = true;
                    }
                }
            }

            System.out.println("--------------------------------------------------");
            if (tie) {
                System.out.println("It's a tie!");
            } else {
                System.out.printf("Congratulations %s, you won!%n", winner.getName());
            }
        }
    }

}
