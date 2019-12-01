import javax.swing.*;
import java.util.Scanner;

public class Test {
    private static Scanner myObj = new Scanner(System.in);
    public static void main(String[] args) {
//        start();
        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.setTitle("TicTacToe Game");
        ticTacToe.setSize(420, 420);
        ticTacToe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ticTacToe.setLocationRelativeTo(null);
        ticTacToe.setVisible(true);
    }
//
//    /**
//     * Initialize the constructor and also decide who is the first player.
//     */
//    private static void start(){
//        TicTacToeBoard game = new TicTacToeBoard();
//        int whoFirst = game.firstTurn();
//        if(whoFirst == 0){
//            game.computerTurn();
//        }else{
//            userInput(game);
//        }
//        do{
//            userInput(game);
//        }while (!game.isWinner());
//        game.printBoard();
//    }
//
//    /**
//     * read the user's input
//     * @param game the instance of the TicTacToeBoard
//     */
//    private static void userInput(TicTacToeBoard game){
//            game.printBoard();
//            System.out.print("Enter row: ");
//            int row = myObj.nextInt();
//            System.out.print("Enter col: ");
//            int col = myObj.nextInt();
//            if(!game.playerTurn(row, col)){
//                System.out.println("****** Please choose different row and col ******");
//            }else{
//                game.computerTurn();
//            }
//            System.out.println();
//    }
}
