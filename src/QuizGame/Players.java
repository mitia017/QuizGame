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
        String Response = scanner.nextLine().trim();
        return Response;
    }

    public static ArrayList<Players> players(){
        System.out.println("==================================================");
        System.out.println("           WELCOME TO THE QUIZ GAME               ");
        System.out.println("==================================================");

        boolean isNotValide = true;
        int nbrPlayer = 1;

        System.out.println("How many player(s) want to play ? (1 - 3): ");
        while(isNotValide){
            System.out.print("> ");
            try {
                nbrPlayer = Integer.parseInt(scanner.nextLine());
                if (nbrPlayer > 3 || nbrPlayer < 1) {
                    System.out.println("Please choose between 1 and 3 !!!");
                }else{
                    isNotValide = false;
                }
            } catch (Exception e) {
                System.out.println("Please enter a number!!!");
            }
        }
        ArrayList<Players> gamePlayers = new ArrayList<>();

        if(nbrPlayer==1){
            System.out.println("Enter player's name: ");
            System.out.print("> ");
            String name = scanner.nextLine();
            Players player1 = new Players(name);
            gamePlayers.add(player1);
        }
        else if (nbrPlayer==2) {
            System.out.println("Enter player1's name: ");
            System.out.print("> ");
            String name1 = scanner.nextLine();
            Players player1 = new Players(name1);
            System.out.println("Enter player2's name: ");
            System.out.print("> ");
            String name2 = scanner.nextLine();
            Players player2 = new Players(name2);
            gamePlayers.add(player1);
            gamePlayers.add(player2);
        } else if (nbrPlayer==3) {
            System.out.println("Enter player1's name: ");
            System.out.print("> ");
            String name1 = scanner.nextLine();
            Players player1 = new Players(name1);
            System.out.println("Enter player2's name: ");
            System.out.print("> ");
            String name2 = scanner.nextLine();
            Players player2 = new Players(name2);
            System.out.println("Enter player3's name: ");
            System.out.print("> ");
            String name3 = scanner.nextLine();
            Players player3 = new Players(name3);
            gamePlayers.add(player1);
            gamePlayers.add(player2);
            gamePlayers.add(player3);
        }
        return gamePlayers;
    }
}

