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
                System.out.printf("%s's turn : %n", player.getName());
            }
            int qCount = 1;
            for (GenerateQuestion.Question question : questions) {
                System.out.printf("Question %d/%d: %s%n", qCount++, QuestionNbr, question.getQuestion());
                System.out.print("> ");
                String Answer = player.play();

                if (Answer.equalsIgnoreCase(question.getAnswers())) {
                    System.out.println("Correct answer... Good job");
                    Score++;
                } else {
                    System.out.printf("Bad answer !!! The correct one is : %s%n", question.getAnswers());
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
        if (players.size() == 1){
            System.out.printf("Your score is %d/%d !!", players.get(0).getScore(),nbrQuestion);
        }else if(players.size() == 2){
            int score1 =players.get(0).getScore();
            int score2 =players.get(1).getScore();

            System.out.printf("%s's score is %d/%d !!%n", players.get(0).getName(), score1,nbrQuestion);
            System.out.printf("%s's score is %d/%d !!%n", players.get(1).getName(), score2,nbrQuestion);

            if(score1>score2) {
                System.out.printf("%s win the game!!%n",players.get(0).getName());
            }else if (score2>score1) {
                System.out.printf("%s win the game!!%n",players.get(1).getName());
            }else {
                System.out.println("It's a tie !!!");
            }
        }else{
            int score1 = players.get(0).getScore();
            int score2 = players.get(1).getScore();
            int score3 = players.get(2).getScore();

            String name1 = players.get(0).getName();
            String name2 = players.get(1).getName();
            String name3 = players.get(2).getName();


            System.out.printf("%n%s's score is %d !!!%n", name1, score1);
            System.out.printf("%s's score is %d !!!%n", name2, score2);
            System.out.printf("%s's score is %d !!!%n%n", name3, score3);

            if(score1 > score2 && score1 > score3){
                System.out.printf("%s is the winner!!!%n",name1);
            } else if (score2 > score1 && score2 > score3) {
                System.out.printf("%s is the winner!!!%n",name2);
            } else if (score3>score1 && score3>score2){
                System.out.printf("%s is the winner!!!%n",name3);
            }else{
                System.out.println("It's a tie!!!");
            }
        }

    }

}
