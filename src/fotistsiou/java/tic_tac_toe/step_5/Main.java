package fotistsiou.java.tic_tac_toe.step_5;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Fight!
 * ------
 * Description
 * Our game is almost ready! Now let's combine what we’ve learned in the previous stages to make a game of tic-tac-toe
 * that two players can play from the beginning (with an empty grid) through to the end (until there is a draw,
 * or one of the players wins).
 * The first player has to play as X and their opponent plays as O.
 * ------
 * Objectives
 * In this stage, you should write a program that:
 * 1. Prints an empty grid at the beginning of the game.
 * 2. Creates a game loop where the program asks the user to enter the cell coordinates,
 *    analyzes the move for correctness and shows a grid with the changes if everything is okay.
 * 3. Ends the game when someone wins or there is a draw.
 * You need to output the final result at the end of the game. Good luck!
 */

public class Main {

    public static void main(String[] args) {
        // 1. Print an empty grid at the beginning of the game.
        char[][] board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            Arrays.fill(board[i], ' ');
        }
        printBoard(board);

        // 2. Create a game loop with user movements and analyze them.
        // 3. Ends the game when someone wins or there is a draw.
        char player = 'X';
        String status = "";
        while (!status.contains("wins") && !status.equals("Game not finished")) {
            analyzeMove(board, player);
            printBoard(board);
            status = setStatus(board);
            player = selectPlayer(player);
        }
        System.out.println(status);
    }

    static void printBoard(char[][] board) {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    static void analyzeMove(char[][] board, char player) {
        Scanner scanner = new Scanner(System.in);
        int xAxis, yAxis;
        while (true) {

            // Check 1 for xAxis: The type of input
            if (scanner.hasNextInt()) {
                xAxis = scanner.nextInt();

                // Check 2 for xAxis: The grid boundaries
                if (xAxis < 1 || xAxis > 3) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    scanner.nextLine(); // Clear invalid input from the scanner buffer
                    continue;
                }

                // Check 1 for yAxis: The type of input
                if (scanner.hasNextInt()) {
                    yAxis = scanner.nextInt();

                    // Check 2 for yAxis: The grid boundaries
                    if (yAxis < 1 || yAxis > 3) {
                        System.out.println("Coordinates should be from 1 to 3!");
                        scanner.nextLine(); // Clear invalid input from the scanner buffer
                        continue;
                    }

                    // Check 3 for xAxis & yAxis: Cell Occupied
                    if (board[xAxis-1][yAxis-1] != ' ') {
                        System.out.println("This cell is occupied! Choose another one!");
                        scanner.nextLine(); // Clear invalid input from the scanner buffer
                        continue;
                    }

                    // Update the grid and exit from while loop
                    board[xAxis-1][yAxis-1] = player;
                    break;
                } else {
                    System.out.println("You should enter numbers!");
                    scanner.nextLine(); // Clear invalid input from the scanner buffer
                }
            } else {
                System.out.println("You should enter numbers!");
                scanner.nextLine(); // Clear invalid input from the scanner buffer
            }
        }
    }

    static String setStatus(char[][] board) {
        // Define variables
        int xCount = 0, oCount = 0;
        boolean xWins = false, oWins = false, hasEmpty = false;
        String status;

        // Check if the game is over
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 'X') xCount++;
                if (board[i][j] == 'O') oCount++;
                if (board[i][j] == '_') hasEmpty = true;
            }
        }

        // Check rows and columns for a win
        for (int i = 0; i < 3; i++) {
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

        // Determine and return the status
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

        return status;
    }

    static char selectPlayer(char player) {
        return player == 'X' ? 'O' : 'X';
    }
}
