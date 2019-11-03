package src;

import java.util.Scanner;

public class ConnectFour {
    // Connect Four Attributes
    private Board board;
    private int players;
    private Player player1;
    private Player player2;
    private GameAI computer;

    public ConnectFour(int numPlayers, int rows, int cols) {
        this.board = new Board(rows, cols);
        this.players = numPlayers;

        if (numPlayers <= 1) {
            numPlayers = 1;
            System.out.println("One player game: You VS. AI!");
            player1 = new Player("Player1", true, 1);
            computer = new GameAI();

        } else if (numPlayers >= 2) {
            numPlayers = 2;
            System.out.println("Two player game, double the trouble!");
            player1 = new Player("Player1", true, 1);
            player2 = new Player("Player2", true, 2);
        }

    }

    /**
     * Main method of ConnectFour
     *
     * @param args
     */
    public static void main(String[] args) {
        Integer numPlayers = Integer.parseInt(args[0]);
        Integer rows = Integer.parseInt(args[1]);
        Integer cols = Integer.parseInt(args[2]);
        int turn = 1;
        int col_choice;

        ConnectFour game = new ConnectFour(numPlayers, rows, cols);
        game.board.printBoard();

        Scanner input = new Scanner(System.in);
        int winner = 0;

        do {

            if (turn == 1) {
                col_choice = game.player1.getUserInput(game.board, input);
                game.player1.makeMove(col_choice, game.board);
            } else {
                // Player 2 turn: either AI or human
                if (game.players == 1) {
                    col_choice = game.computer.aiMove(game.board);
                    game.computer.makeMove(col_choice, game.board);
                    System.out.println("AI chose column " + col_choice + "\n");
                } else if (game.players == 2) {
                    col_choice = game.player2.getUserInput(game.board, input);
                    game.player2.makeMove(col_choice, game.board);
                }
            }
            if (turn == 1) {
                turn = 2;
            } else {
                turn = 1;
            }

            game.board.printBoard();
            winner = game.board.checkWin();

        } while (game.board.hasSpotsRemaining() && winner == 0);

        input.close();
        game.board.printBoard();

        // End of Game Message
        if (winner == 1) {
            System.out.println("Player 1 wins!!");
        } else if (game.player2.isHuman()) {
            System.out.println("Player 2 wins!!");
        } else {
            System.out.println("The AI overlord wins :|");
        }

    } // end of main
} // end of class