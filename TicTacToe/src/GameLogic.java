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
     * @precondition human == 'X' && opponentHardAi == 'O'
     * @precondition human == 'O' && opponentHardAi == 'X'
     */
    public GameLogic(char human, char opponentHardAi) {
        assert ensureHumanAndComputerChooseCorrectRole(human, opponentHardAi) :
                "Violate precondition: human == 'X' && opponentHardAi == 'O' OR human == 'O' && opponentHardAi == 'X'";
        this.human = human;
        this.opponentHardAi = opponentHardAi;
    }

    /**
     *
     * @param human the human input the char
     * @param opponentHardAi the computer input the char
     * @return true or false
     */
    private boolean ensureHumanAndComputerChooseCorrectRole(char human, char opponentHardAi){
        if ((human == 'X') && (opponentHardAi == 'O')) {
            return true;
        }
        if ((human == 'O') && (opponentHardAi == 'X')) {
            return true;
        }
        return false;
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
     * @precondition piece == 'X' || piece == 'O'
     * @precondition position >= 0 && position < 9
     */
    public void generateNewPiece(char piece, int position) {
        assert piece == 'X' || piece == 'O' : "Violate precondition: piece == 'X' || piece == 'O'";
        assert position >= 0 && position < 9 : "Violate precondition: position >= 0 && position < 9";
        this.board[position] = piece;
    }

    /**
     * True if the position on the board is available.
     *
     * @param position the position in the board.
     * @precondition position >= 0 && position < 9
     * @return whether it is a valid position.
     */
    public boolean isPositionAvailable(int position) {
        assert position >= 0 && position < 9 : "Violate precondition: position >= 0 && position < 9";
        return this.board[position] != this.human && this.board[position] != this.opponentHardAi;
    }

    /**
     * True if piece is the winner of the game.
     *
     * @param piece the character.
     * @precondition piece == 'X' || piece == 'O'
     * @return whether the game is over.
     */
    public boolean isWinner(char piece) {
        assert piece == 'X' || piece == 'O' : "Violate precondition: piece == 'X' || piece == 'O'";
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