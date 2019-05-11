
import java.util.Scanner;

public class Game {

    private Grid grid;
    private Player[] players;
    private Scanner userInput;
    private Rule rule;
    private boolean runGame = true;
    private final int ROWS = 5;
    private final int COLUMNS = 5;

    public Game() {
        players = new Player[2];
        grid = new Grid(this.ROWS, this.COLUMNS);
        rule = new Rule(grid);
        for (int i = 0; i < players.length; i++) {
            players[i] = new Player();
        }

        userInput = new Scanner(System.in);
    }

    public void run() {

        initPlayers();
        grid.initGrid();
        grid.printGridResults();


        while (runGame) {

            System.out.println("Player " + players[0].getName() + " turn");
            processChecks();
            userInputTurn("P1");


            System.out.println("Player " + players[1].getName() + " turn");
            processChecks();
            userInputTurn("P2");

        }

    }

    public void processChecks(){
        System.out.println("Please enter a number between 1 to 5");
        grid.printGridResults();
        rule.checkDraw();
    }


    private void userInputTurn(String player) {

        boolean process = true;

        while (process) {

            if (!userInput.hasNextInt()) {
                //if the user has entered the non-integer, then warn the user
                System.out.println("Wrong, " + player + " please enter a positive integer between 1 to 5");
                userInput.next();
            }
            //if the user has not entered wrong input, then curry on updating the grid
            else {

                int number = userInput.nextInt(); //take user input as integer

                if (number > 0 && number < COLUMNS + 1) {


                    if (rule.illegalColumnInput(number)) {
                        System.out.println("Wrong, " + player + " the column " + number
                                + " already full, try a different column number");
                    } else {
                        grid.updateGrid(number, player);
                        process = false; // close

                    }
                } else {
                    System.out.println("Wrong, " + player + " please enter a number between 1 to 5");
                }


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
