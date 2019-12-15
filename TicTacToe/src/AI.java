/**
 * This class is used for output the AI returns.
 * This class is invoked when the user chooses the hard option to play with.
 * @author 
 *
 */
public class AI {
    /**
     * Will return the index of the best move to make.
     *
     * @param gameLogic gameLogic object
     * @return the best move.
     * @postcondition Will return a move if the game isn't finished or the board isn't full.
     */
    public int getIndexOfBestMove(GameLogic gameLogic) {
        GameLogic gameLogicCopy = gameLogic.copy();

        //Take the middle first if no one taken
        if (gameLogicCopy.isPositionAvailable(4)) {
        	
            return 4;
        } else if (gameLogicCopy.getBoard()[4] == gameLogic.getHuman()
                && gameLogicCopy.isPositionAvailable(2))
        //return the index of right top corner if middle is taken by human
        {
            return 2;
        }

        //return the index of first winning position for AI
        int hardAiIndex = findWinPosition(gameLogicCopy, gameLogic.getOpponentHardAi());
        //since I have keyword protect in super class, thus I can call findWinPosition()
        if (hardAiIndex != -1) {
            return hardAiIndex;
        }

        //return index of first winning position for human
        int humanIndex = findWinPosition(gameLogicCopy, gameLogic.getHuman());
        if (humanIndex != -1) {
            return humanIndex;
        }

        //return index of fork for AI
        hardAiIndex = findFork(gameLogicCopy, gameLogic.getOpponentHardAi(), 2);
        if (hardAiIndex != -1) {
            return hardAiIndex;
        }
        //return the index of best move against human's fork
        humanIndex = findFork(gameLogicCopy, gameLogic.getHuman(), 2);
        if (humanIndex != -1) {
            //playing two in a row to counter fork
            if (gameLogicCopy.getBoard()[4] == gameLogicCopy.getHuman()) {
                return findFork(gameLogicCopy, gameLogic.getOpponentHardAi(), 1);
                //play into fork position of human
            } else {
                return humanIndex;
            }
        }

        //return the index of opposite corners to human
        for (int i = 0; i < gameLogicCopy.getLength(); i += 2) {
            if (gameLogicCopy.getBoard()[i] == gameLogic.getHuman()
                    && i != 4 && gameLogicCopy.isPositionAvailable(8 - i)) {
                return 8 - i;
            }
        }
        return -1;
    }

    /**
     * A helper function to find the winning position for the AI (hard mode).
     *
     * @param gameLogic GameLogic object.
     * @param piece     the character of computer AI.
     * @return the move
     * @postconditon An optimal move will be returned
     */
    private int findWinPosition(GameLogic gameLogic, char piece) {
        GameLogic gameLogicCopy = gameLogic.copy();
        GameLogic newGameLogicClone;

        //Return index of first wining position for piece
        for (int i = 0; i < gameLogicCopy.getLength(); i++) {
            newGameLogicClone = gameLogicCopy.copy();
            if (newGameLogicClone.isPositionAvailable(i)) {
                newGameLogicClone.generateNewPiece(piece, i);
                if (newGameLogicClone.isWinner(piece)) {
                    return i;
                }
            }
        }
        //if no win position found
        return -1;
    }

    /**
     * A helper function to copy the new board and try to find index of optimal.
     *
     * @param gameLogic GameLogic object
     * @param piece     the character of computer AI.
     * @param wins
     * @return position that leads to a particular number of possible.
     */
    private int findFork(GameLogic gameLogic, char piece, int wins) {
        GameLogic gameLogicCopy = gameLogic.copy();
        GameLogic newGameLogicCopy;
        GameLogic newGameLogicCopy2;

        int totalWins;
        for (int i = 0; i < gameLogicCopy.getLength(); i++) {
            totalWins = 0;
            newGameLogicCopy = gameLogicCopy.copy();
            if (newGameLogicCopy.isPositionAvailable(i)) {
                newGameLogicCopy.generateNewPiece(piece, i);
            }
            for (int j = 0; j < gameLogicCopy.getLength(); j++) {
                newGameLogicCopy2 = newGameLogicCopy.copy();
                if (newGameLogicCopy2.isPositionAvailable(j)) {
                    newGameLogicCopy2.generateNewPiece(piece, j);
                    if (newGameLogicCopy2.isWinner(piece)) {
                        totalWins++;
                    }
                    if (totalWins >= wins) {
                        return i;
                    }
                }
            }
        }
        return -1;
    }

    /**
     * Generating random move for the easy AI.
     *
     * @param gameLogic GameLogic object.
     * @return random moves.
     * 
     * @postcondition will return a valid move until the game isn't finished
     */
    public int getRandomMove(GameLogic gameLogic) {
        while (true) {
            int i = (int) (Math.random() * 9);
            if (gameLogic.isPositionAvailable(i)) {
                return i;
            }
        }
    }
}