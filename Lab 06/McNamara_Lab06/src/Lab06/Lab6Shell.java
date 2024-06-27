// Timothy McNamara
// Lab 06
// 5/27/2024
// CIT 27000

package Lab06;

import java.util.Scanner;

public class Lab6Shell {

	public static void main(String[] args) {
		// variables
		// I changed some variable names to add a challenge.
        Scanner input = new Scanner(System.in);
        char[][] board = new char[7][8];
        boolean exitGame = false;
        boolean gameOver = false;
        char currentPlayer = 'X';
        int numMoves = 0;

        // loop until user wants to stop
        do {
            // init game board
            for (int i = 1; i <= 6; i++) {
                for (int j = 1; j <= 7; j++) {
                    board[i][j] = ' ';
                }
            }

            // display the board
            DisplayBoard(board);

            // loop until this game is over
            do {
                // get the next move for the current player
                int columnChosen = 0;
                do {
                    System.out.println("Enter the column you want to place your piece.");
                    columnChosen = input.nextInt();
                } while (columnChosen < 1 || columnChosen > 7 || board[1][columnChosen] != ' ');

                // place piece
                for (int i = 6; i >= 1; i--) {
                    if (board[i][columnChosen] == ' ') {
                        board[i][columnChosen] = currentPlayer;
                        break;
                    }
                }

                // increment number of moves
                numMoves++;

                // display the board
                DisplayBoard(board);

                // check for win
                if (CheckForWin(board)) {
                    // if winner, display congratulations and set gameOver true
                    System.out.println("Congratulations! You win " + currentPlayer );
                    gameOver = true;
                } else if (numMoves == 42) {
                    // if tie, display result and set gameOver true
                    System.out.println("Sorry, this game ends in a tie.");
                    gameOver = true;
                } else {
                    // switch current player
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                }

            } while (!gameOver);

            // ask if user wants to play again, set finished accordingly
            System.out.println("Do you want to play again? (yes/no)");
            String playAgainInput = input.next();
            // exitGame becomes true if the string returned to the variable 
            // playAgain is true and does't equal yes.
            exitGame = !playAgainInput.equalsIgnoreCase("yes");

        } while (!exitGame);
    }

    // this method displays the board passed in
    public static void DisplayBoard(char[][] board) {
        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= 7; j++) {
                System.out.print("|" + board[i][j]);
            }
            System.out.println("|");
        }
    }

    // this method determines if a game has been won
    public static boolean CheckForWin(char[][] board) {
        // check for horizontal
        for (int r = 1; r <= 6; r++) {
            for (int c = 1; c <= 4; c++) {
                if (board[r][c] == board[r][c+1] &&
                    board[r][c] == board[r][c+2] &&
                    board[r][c] == board[r][c+3] &&
                    board[r][c] != ' ') {
                    return true;
                }
            }
        }

        // check for vertical
        for (int r = 1; r <= 3; r++) {
            for (int c = 1; c <= 7; c++) {
                if (board[r][c] == board[r+1][c] &&
                    board[r][c] == board[r+2][c] &&
                    board[r][c] == board[r+3][c] &&
                    board[r][c] != ' ') {
                    return true;
                }
            }
        }

        // check for diagonal up
        for (int r = 4; r <= 6; r++) {
            for (int c = 1; c <= 4; c++) {
                if (board[r][c] == board[r-1][c+1] &&
                    board[r][c] == board[r-2][c+2] &&
                    board[r][c] == board[r-3][c+3] &&
                    board[r][c] != ' ') {
                    return true;
                }
            }
        }

        // check for diagonal down
        for (int r = 1; r <= 3; r++) {
            for (int c = 1; c <= 4; c++) {
                if (board[r][c] == board[r+1][c+1] &&
                    board[r][c] == board[r+2][c+2] &&
                    board[r][c] == board[r+3][c+3] &&
                    board[r][c] != ' ') {
                    return true;
                }
            }
        }

        return false;

	}

}
