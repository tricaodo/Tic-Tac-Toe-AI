public class TicTacToeBoard {

    private char[][] board;
    private final int ROWS = 3;
    private final int COLS = 3;
    private boolean isGameOver = false;

    /**
     * Constructor which initializes the board.
     */
    public TicTacToeBoard(){
        this.board = new char[ROWS][COLS];
        for(int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                board[i][j] = '-';
            }
        }
    }

    /**
     * Print the board to the console.
     */
    public void printBoard(){
        for(int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print("|" + board[i][j] + "|");
            }
            System.out.println();
        }
    }

    public int firstTurn(){
        int player = (int) Math.floor(Math.random() * 2);
        return player;
    }

    /**
     * Check either rows, cols, or diagonals were filled with same character or not.
     * @return true if same character on one of them (rows, cols, diagonals), otherwise false.
     */
    public boolean isWinner(){
        if(checkRows() || checkCols() || checkDiagonals() ) {
            return true;
        }
        return false;
    }

    /**
     * Check if same character (X or O) on the same row.
     * @return true if same character(X or O) on the row. Otherwise, false
     */
    private boolean checkRows(){
        for(int i = 0; i < ROWS; i++){
            if(board[i][0] == board[i][1] && board[i][1]== board[i][2] && board[i][0] != '-'){
                return true;
            }
        }
        return false;
    }

    /**
     * Check if same character (X or O) on the same column.
     * @return true if same character(X or O) on the column. Otherwise, false
     */
    private boolean checkCols(){
        for(int i = 0; i < COLS; i++){
            if(board[0][i] == board[1][i] && board[1][i]== board[2][i] && board[0][i] != '-'){
                return true;
            }
        }
        return false;
    }

    /**
     * Check if same character (X or O) on the same diagonal.
     * @return true if same character(X or O) on the diagonal. Otherwise, false
     */
    private boolean checkDiagonals(){
        if(board[0][0] == board[1][1] &&
           board[1][1] == board[2][2] &&
           board[0][0] != '-' ){
            return true;
        }
        if(board[2][0] == board[1][1] &&
           board[1][1] == board[0][2] &&
           board[2][0] != '-' ){
            return true;
        }
        return false;
    }

    /**
     *  Computer automatically plays after the user's turn.
     */
    public void computerTurn(){
        while(!isGameOver){
            int row = (int)(Math.random() * 3);
            int col = (int)(Math.random() * 3);
            if(board[row][col] == '-'){
                board[row][col] = 'O';
                if(isWinner()){
                    isGameOver = true;
                    System.out.println("Computer won!!!");
                }
                break;
            }
        }
    }

    /**
     *
     * @param row: the row which the user wants to put their turn.
     * @param col: the column which the user wants to put their turn.
     * @return  true if the user enter valid row and column
     *          false if the user enter invalid or input that already exists
     */
    public boolean playerTurn(int row, int col){
        if(board[row][col] != '-'){
            return false;
        }else{
            if(!isGameOver){
                board[row][col] = 'X';
                if(isWinner()){
                    isGameOver = true;
                    System.out.println("Congratulation. You won");
                }
            }
            return true;
        }
    }
}
