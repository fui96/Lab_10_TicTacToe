import java.util.Scanner;


public class Main{
    //Constants
    private static final int ROWS = 3;
    private static final int COLS = 3;
    private static String board [][] = new String[ROWS][COLS];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Boolean Cont = true;
        Boolean PlayerX = true;
        do{
            ClearBoard();
            int moveCount = 0;
            Boolean GameIsWon = false;
            PlayerX = true;
            do{
                /*
                if(PlayerX){
                    int row = 0;
                    int col = 0;
                    Boolean ValidMove = false;
                    while(!ValidMove){
                        row = (SafeInput.getRangedInt(in,"Please select the row you would like",1,3) - 1);
                        col = (SafeInput.getRangedInt(in,"Please select the column you would like",1,3) -1);
                        ValidMove = isValidMove(row,col);
                    }
                    board[row][col] = "X";
                    moveCount++;
                    PlayerX = false;
                    DisplayBoard();

                }
                else{
                    int row = 0;
                    int col = 0;
                    Boolean ValidMove = false;
                    while(!ValidMove){
                        row = (SafeInput.getRangedInt(in,"Please select the row you would like",1,3) - 1);
                        col = (SafeInput.getRangedInt(in,"Please select the column you would like",1,3) -1);
                        ValidMove = isValidMove(row,col);
                    }
                    board[row][col] = "O";
                    moveCount++;
                    PlayerX = true;
                    DisplayBoard();
                }
                */
                 int row = 0;
                 int col = 0;
                 Boolean ValidMove = false;
                 while(!ValidMove){
                     row = (SafeInput.getRangedInt(in,"Please select the row you would like",1,3) - 1);
                     col = (SafeInput.getRangedInt(in,"Please select the column you would like",1,3) - 1);
                     ValidMove = isValidMove(row, col);
                     if(!ValidMove){
                         System.out.println("Invalid Move");
                     }
                 }
                 if(PlayerX){
                     board[row][col] = "X";
                     moveCount++;
                 }
                 else{
                     board[row][col] = "O";
                     moveCount++;
                 }
                 DisplayBoard();
                 PlayerX = !PlayerX;

                if(moveCount >= 5){

                }

            }while(!GameIsWon && moveCount < 9);







            SafeInput.getYNConfirm(in, "Would you like to play again? (Y/N)");
        }while(Cont);


    }


    //Clear the board
    private static void ClearBoard() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                board[i][j] = " ";

            }
        }
    }
    //Show the board
    private static void DisplayBoard() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                System.out.print( " | "+ board[i][j]);
                if(j == 2){
                    System.out.println();
                }
            }
        }
    }

    //Valid Move Check
    private static Boolean isValidMove(int row, int col) {
        Boolean RetBool = false;
        if(board[row][col].equals(" ")){
            RetBool = true;
        }
        return RetBool;
    }
    /*
    //Win Check
    private static Boolean isWin(String Player){

    }
    //Column Check
    private static Boolean isColWin(String Player){

    }
    //Row Check
    private static Boolean isRowWin(String Player){

    }
    //Diagonal Check
    private static Boolean isDiagonalWin(String Player){

    }
    //Check for tie
    private static Boolean isTie(){

    }
*/
}

