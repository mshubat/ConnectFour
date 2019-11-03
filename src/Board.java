public class Board {
    private int rows;
    private int cols;
    public int[] col_counts;
    private int[][] grid;
    public int spotsRemaining;

    /**
     * Constructor to create and initialize the board.
     *
     * @param rows num rows for board
     * @param cols num cols for board
     */
    public Board(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.col_counts = new int[cols];
        this.grid = new int[rows][cols];
        this.spotsRemaining = rows * cols;

    }

    /**
     * Initialize the board
     * - use all 0's as default values
     */
    private void initalizeBoard() {
        for (int row = 0; row < this.rows; row++) {
            for (int col = 0; col < this.cols; col++) {
                this.grid[row][col] = 0;
            }
        }
    }

    /**
     * Print the board to the console.
     */
    public void printBoard() {
        for (int row = 0; row < this.rows; row++) {
            for (int col = 0; col < this.cols; col++) {
                System.out.print(this.grid[row][col] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Check if the board has a connect four.
     *
     * @return 0 - no win, 1 - player1 wins, 2 - players2 wins
     */
    public int checkWin() {

        int[][] directions = {{1, 0}, {1, 1}, {1, -1}, {0, -1}};

        for (int c = 0; c < cols; c++) {
            for (int r = 0; r < rows; r++) {

                for (int[] d : directions) {
                    int dx = d[0];
                    int dy = d[1];

                    if (r + 3 * dy < rows && r + 3 * dy > 0 && c + 3 * dx < cols) {

                        if (grid[r][c] != 0 &&
                                grid[r+1*dy][c+1*dx] == grid[r][c] &&
                                grid[r+2*dy][c+2*dx] == grid[r][c] &&
                                grid[r+3*dy][c+3*dx] == grid[r][c]) {
                            return grid[r][c];
                        }

                    }
                }
            }
        }

        return 0;
    }


    // Getters and Setters

    public boolean hasSpotsRemaining() {
        return (this.spotsRemaining > 0);

    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getCols() {
        return cols;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }

    public int[][] getGrid() {
        return grid;
    }

    public void setGrid(int[][] grid) {
        this.grid = grid;
    }
}