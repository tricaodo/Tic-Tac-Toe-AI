/**
 * This class handles the playing of the game.
 *
 *
 */
public class GameLogic {
    //The Tic Tac Toe board filled with the pieces
    private char[] board = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
    //initialize a 9 empty char ' '

    //Character used for the player pieces (X/0)
    private final char human;
    private final char opponentHardAi;

    /**
     * Constructor for GameLogic.
     *
     * @param human          character for player.
     * @param opponentHardAi character for computer.
     */
    public GameLogic(char human, char opponentHardAi) {
        this.human = human;
        this.opponentHardAi = opponentHardAi;
    }

    /**
     * Getting the board.
     *
     * @return board.
     * @postcondition the board will be returned.
     */
    public char[] getBoard() {
        return board;
    }

    /**
     * Getting human's character.
     *
     * @return human's character.
     */
    public char getHuman() {
        return human;
    }

    /**
     * Getting the computer's character.
     *
     * @return Computer's character.
     */
    public char getOpponentHardAi() {
        return opponentHardAi;
    }

    /**
     * Getting the length of the board from the outside class.
     *
     * @return the length of the board.
     */
    public int getLength() {
        return this.board.length;
    }

    /**
     * Reset every char is empty.
     */
    public void reset() {
        for (int i = 0; i < this.board.length; i++) {
            this.board[i] = ' ';
        }
    }

    /**
     * Will place a new piece into the board at current position of this board
     *
     * @param piece    the character.
     * @param position the position in the board.
     */
    public void generateNewPiece(char piece, int position) {
        this.board[position] = piece;
    }

    /**
     * True if the position on the board is available.
     *
     * @param position the position in the board.
     * @return whether it is a valid position.
     */
    public boolean isPositionAvailable(int position) {
        return this.board[position] != this.human && this.board[position] != this.opponentHardAi;
    }

    /**
     * True if piece is the winner of the game.
     *
     * @param piece the character.
     * @return whether the game is over.
     */
    public boolean isWinner(char piece) {
        for (int i = 0; i < 3; i++) {
            //Check for horizontal and vertical wins
            if (this.board[3 * i] == piece && this.board[3 * i + 1] == piece &&
                    this.board[3 * i + 2] == piece || this.board[i] == piece &&
                    this.board[i + 3] == piece && this.board[i + 6] == piece) {
                return true;
            }
        }

        //Check for diagonal wins
        if (this.board[2] == piece && this.board[4] == piece &&
                this.board[6] == piece || this.board[0] == piece &&
                this.board[4] == piece && this.board[8] == piece) {
            return true;
        }
        return false;
    }

    /**
     * Create a copy of the TicTacToe object in it's current state.
     *
     * @return the new copy of the GameLogic.
     */
    public GameLogic copy() {
        GameLogic newGameLogic = new GameLogic(this.human, this.opponentHardAi);
        for (int i = 0; i < this.board.length; i++) {
            newGameLogic.board[i] = this.board[i];
        }
        return newGameLogic;
    }
}