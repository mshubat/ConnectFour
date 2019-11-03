package src;

import java.lang.Math;

public class GameAI extends Player {

    /**
     * AI constructor, inherits from Player class.
     */
    public GameAI() {
        super("AI", false, 2);
    }

    /**
     * GameAI's move method. Just makes a random move.
     * @param board
     * @return
     */
    public int aiMove(Board board) {
        int choice;
        do {
            double dec = Math.random();
            choice = (int) Math.ceil(board.getCols() * dec);

        } while (board.col_counts[choice-1] == board.getRows());

        return choice;
    }

}