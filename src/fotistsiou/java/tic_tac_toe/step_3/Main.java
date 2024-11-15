package fotistsiou.java.tic_tac_toe.step_3;

import java.util.Scanner;

/**
 * What's up on the field?
 * -----------------------
 * Description
 * In this stage, we’re going to analyze the game state to determine if either player has already won the game
 * or it is still ongoing, if the game is a draw, or if the user has entered an impossible game state
 * (two winners, or with one player having made too many moves).
 * -----------------------
 * Objectives
 * In this stage, your program should:
 * 1. Take a string entered by the user and print the game grid as in the previous stage.
 * 2. Analyze the game state and print the result. Possible states:
 *    - Game not finished when neither side has three in a row but the grid still has empty cells.
 *    - Draw when no side has a three in a row and the grid has no empty cells.
 *    - X wins when the grid has three X’s in a row (including diagonals).
 *    - O wins when the grid has three O’s in a row (including diagonals).
 *    -Impossible when the grid has three X’s in a row as well as three O’s in a row,
 *     or there are a lot more X's than O's or vice versa (the difference should be 1 or 0;
 *     if the difference is 2 or more, then the game state is impossible).
 * In this stage, we will assume that either X or O can start the game.
 * You can choose whether to use a space or underscore _ to print empty cells.
 */

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        char[][] board = new char[3][3];
        int xCount = 0;
        int oCount = 0;
        boolean xWins = false;
        boolean oWins = false;
        boolean hasEmpty = false;

        System.out.println("---------");
        int index = 0;
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                board[i][j] = input.charAt(index++);
                System.out.print(board[i][j] + " ");

                if (board[i][j] == 'X') xCount++;
                if (board[i][j] == 'O') oCount++;
                if (board[i][j] == '_') hasEmpty = true;
            }
            System.out.println("|");
        }
        System.out.println("---------");

        // Check rows and columns for a win
        for (int i = 0; i < 3; i++) {
            // Check rows and columns for a win
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                if (board[i][0] == 'X') xWins = true;
                if (board[i][0] == 'O') oWins = true;
            }
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                if (board[0][i] == 'X') xWins = true;
                if (board[0][i] == 'O') oWins = true;
            }
        }

        // Check diagonals for a win
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            if (board[0][0] == 'X') xWins = true;
            if (board[0][0] == 'O') oWins = true;
        }
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            if (board[0][2] == 'X') xWins = true;
            if (board[0][2] == 'O') oWins = true;
        }

        // Determine game status
        String status;
        if ((xWins && oWins) || Math.abs(xCount - oCount) > 1) {
            status = "Impossible";
        } else if (xWins) {
            status = "X wins";
        } else if (oWins) {
            status = "O wins";
        } else if (hasEmpty) {
            status = "Game not finished";
        } else {
            status = "Draw";
        }

        System.out.println(status);

        scanner.close();
    }
}
