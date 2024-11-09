import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {
    //Constants
    private static final int ROWS = 3;
    private static final int COLS = 3;
    private static String board[][] = new String[ROWS][COLS];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Boolean Cont = true;
        Boolean PlayerX = true;
        //Main Game Loop
        do {
            ClearBoard();
            int moveCount = 0;
            Boolean GameIsWon = false;
            PlayerX = true;
            do {
                DisplayBoard();
                if (PlayerX) {
                    System.out.println("Player X it is your turn please select your move");
                } else {
                    System.out.println("Player O it is your turn please select your move");
                }
                int row = 0;
                int col = 0;
                Boolean ValidMove = false;
                while (!ValidMove) {
                    row = (SafeInput.getRangedInt(in, "Please select the row you would like", 1, 3) - 1);
                    col = (SafeInput.getRangedInt(in, "Please select the column you would like", 1, 3) - 1);
                    ValidMove = isValidMove(row, col);
                    if (!ValidMove) {
                        System.out.println("Invalid Move");
                    }
                }
                if (PlayerX) {
                    board[row][col] = "X";
                    moveCount++;
                } else {
                    board[row][col] = "O";
                    moveCount++;
                }

                if (moveCount >= 5) {
                    if (PlayerX) {
                        GameIsWon = isWin("X");
                    } else {
                        GameIsWon = isWin("O");
                    }

                }
                PlayerX = !PlayerX;
            } while (!GameIsWon && moveCount < 9);

            SafeInput.getYNConfirm(in, "Would you like to play again? (Y/N)");
        } while (Cont);


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
                System.out.print(board[i][j] + "|");
            }
            System.out.println();
        }
    }

    //Valid Move Check
    private static Boolean isValidMove(int row, int col) {
        Boolean RetBool = false;
        if (board[row][col].equals(" ")) {
            RetBool = true;
        }
        return RetBool;
    }

    //Win Check
    private static Boolean isWin(String Player) {
        if(isRowWin(Player) || isColWin(Player) || isDiagonalWin(Player)) {
            DisplayBoard();
            System.out.println("Congratulations! Player "+ Player +" you won!");
        }
        else if(isTie()){
            DisplayBoard();
            System.out.println("The game is a Tie!");
        }
        return isRowWin(Player) || isColWin(Player) || isDiagonalWin(Player) || isTie();
    }

    //Column Check

    private static Boolean isColWin(String Player) {
        for (int i = 0; i < ROWS; i++) {
            if (board[i][0].equals(Player) && board[i][1].equals(Player) && board[i][2].equals(Player)) {
                return true;
            }
        }
        return false;
    }

    //Row Check
    private static Boolean isRowWin(String Player) {
        for (int i = 0; i < COLS; i++) {
            if (board[0][i].equals(Player) && board[1][i].equals(Player) && board[2][i].equals(Player)) {
                return true;
            }
        }
        return false;
    }

    //Diagonal Check
    private static Boolean isDiagonalWin(String Player) {
        if(board[0][0].equals(Player) && board[1][1].equals(Player) && board[2][2].equals(Player)) {
            return true;
        } else if(board[0][2].equals(Player) && board[1][1].equals(Player) && board[2][0].equals(Player)) {
            return true;
        }
        return false;
    }

    //Check for tie
    private static Boolean isTie() {
        Pattern pattern = Pattern.compile(".*X.*O.*|.*O.*X.*");

        for (int i = 0; i < ROWS; i++) {

            // Row Check
            String row = board[i][0] + board[i][1] + board[i][2];
            if (!pattern.matcher(row).find()) {
                return false;
            }
            //Column Check
            String col  = board[0][i] + board[1][i] + board[2][i];
            if (!pattern.matcher(col).find()) {
                return false;
            }
        }
        //Diagonal Check
        String Diagonal1 =  board[0][0] + board[1][1] + board[2][2];
        String Diagonal2 =  board[0][2] + board[1][1] + board[2][0];
        if (!pattern.matcher(Diagonal1).find() || !pattern.matcher(Diagonal2).find()) {
            return false;
        }
        return true;
    }

}

