import java.util.Scanner;

public class Game {

    private Grid grid;
    private Player[] players;
    private Scanner userInput;
    private boolean runGame = true;

    public Game() {
        players = new Player[2];
        grid = new Grid();

        for (int i = 0; i < players.length; i++) {
            players[i] = new Player();
        }

        userInput = new Scanner(System.in);
    }

    public void run() {

        initPlayers();
        grid.initGrid();
        grid.printResults();


        while (runGame) {

            System.out.println("Player " + players[0].getName() + " turn");
            userInputTurn("P1");

            System.out.println("Player " + players[1].getName() + " turn");
            userInputTurn("P2");

            grid.printResults();

        }

    }


    private void userInputTurn(String player) {

        if (!userInput.hasNextInt()) {
            //if the user has entered the non-integer, then warn the user
            System.out.println("Please enter a positive integer");
            userInput.next();
        }
        //if the user has not entered wrong input, then curry on
        else {

            int number = userInput.nextInt(); //take user input as integer

            if (number > 0 && number < 7) {
                grid.updateGrid(number, player);
            } else {
                System.out.println("Please enter a number between 1 to 6");
            }


        }


    }

    private void initPlayers() {

        boolean run = true;

        while (run) {

            System.out.println("Welcome to connect 4");
            System.out.println("Player 1 please enter your name?");
            players[0].setType("P1");
            players[0].setName(userInput.next());

            System.out.println("Player 2 please enter your name?");
            players[1].setType("P2");
            players[1].setName(userInput.next());


            if (players[0].getName().length() > 0 && players[1].getName().length() > 0) {
                run = false;
            }
        }
    }


}
