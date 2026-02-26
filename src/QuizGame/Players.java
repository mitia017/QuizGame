package QuizGame;

import java.util.ArrayList;
import java.util.Scanner;

public class Players {
    public static final Scanner scanner = new Scanner(System.in);
    private String name;
    private int score = 0;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Players(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String play(){
        String Response = scanner.nextLine();
        return Response;
    }

    public static ArrayList<Players> players(){

        System.out.println("**************************************************");
        System.out.println("*           WELCOME TO THE QUIZ GAME!            *");
        System.out.println("*        Test your knowledge of capitals!        *");
        System.out.println("**************************************************\n");

        boolean isNotValide = true;
        int nbrPlayer = 1;

        System.out.println("How many player(s) want to play ? (1 - 3): ");
        while(isNotValide){
            System.out.print("> ");
            try {
                nbrPlayer = Integer.parseInt(scanner.nextLine());
                if (nbrPlayer > 3 || nbrPlayer < 1) {
                    System.out.println("Please choose a number between 1 and 3.");
                }else{
                    isNotValide = false;
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
        ArrayList<Players> gamePlayers = new ArrayList<>();

        for (int i = 1; i <= nbrPlayer; i++) {
            if (nbrPlayer == 1) {
                System.out.println("Enter player's name: ");
            } else {
                System.out.printf("Enter player %d's name: %n", i);
            }
            System.out.print("> ");
            String name = scanner.nextLine();
            gamePlayers.add(new Players(name));
        }
        return gamePlayers;
    }
}

