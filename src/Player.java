package src;

import java.util.Scanner;

public class Player {
    private String name;
    private Boolean human;
    private int sym;

    /**
     * Player Constructor
     * @param name
     * @param Human
     * @param sym
     */
    public Player(String name, Boolean Human, int sym) {
        this.name = name;
        this.human = Human;
        this.sym = sym;
    }

    // Player Operations

    /**
     * Method to get the users next move.
     * row and col will be requested until valid input is received.
     *
     * @return array of user choices. index 0 = row, index 1 = col.
     */
    public int getUserInput(Board board, Scanner input) {
        Integer col;
        int count = 0;

        do {
            System.out.print(name + " enter your move.\ncol: ");
            col = input.nextInt();
            count += 1;
        } while (col > board.getCols() || col < 1 || board.col_counts[col-1] == board.getRows());

        return col;
    }

    /**
     * Make move in a given column
     *
     * @param col
     * @param board
     * @return
     */
    public boolean makeMove(int col, Board board) {
        // Adjusted since column names start at 1, but indices at 0.
        int colIndex = col-1;
        // Check col is not full
        if (board.col_counts[colIndex] < board.getRows()) {
            int[][] grid = board.getGrid();


            grid[board.getRows() - 1 - board.col_counts[colIndex]][colIndex] = this.sym;
            board.col_counts[colIndex] += 1;
            board.spotsRemaining -= 1;
        }
        return false;
    }


    // Getters and Setters

    public Boolean isHuman() {
        return human;
    }

}