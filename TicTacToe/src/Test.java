import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        TicTacToeBoard game = new TicTacToeBoard();
        game.computerTurn();
        Scanner myObj = new Scanner(System.in);
        do{
            game.printBoard();
            System.out.print("Enter row: ");
            int row = myObj.nextInt();
            System.out.print("Enter col: ");
            int col = myObj.nextInt();
            if(!game.playerTurn(row, col)){
                System.out.println("****** Please choose different row and col ******");
            }else{
                game.computerTurn();
            }
            System.out.println();
        }while (!game.isWinner());
        game.printBoard();
    }
}
