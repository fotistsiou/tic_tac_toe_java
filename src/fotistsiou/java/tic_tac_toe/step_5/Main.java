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
        // 1. Initialize an empty 3x3 2D character array
        char[][] board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            Arrays.fill(board[i], ' ');
        }

        // 2. Prints the beginning board.
        printBoard(board);

        // 3. Prompt the user to make a move & analyze user input
        char player = 'X';
        analyzesTheMove(board, player);

        // 4. Prints the modified board.
        printBoard(board);
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

    static void analyzesTheMove(char[][] board, char player) {
        Scanner scanner = new Scanner(System.in);
        int xAxis, yAxis;
        while (true) {
            // Check 1 for xAxis: The type of input
            if (scanner.hasNextInt()) {
                xAxis = scanner.nextInt();

                // Check 2 for xAxis: The grid boundaries
                if (xAxis < 1 || xAxis > 3) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    scanner.nextLine();
                    continue;
                }

                // Check 1 for yAxis: The type of input
                if (scanner.hasNextInt()) {
                    yAxis = scanner.nextInt();

                    // Check 2 for yAxis: The grid boundaries
                    if (yAxis < 1 || yAxis > 3) {
                        System.out.println("Coordinates should be from 1 to 3!");
                        scanner.nextLine();
                        continue;
                    }

                    // Check 3 for xAxis & yAxis: Cell Occupied
                    if (board[xAxis-1][yAxis-1] != ' ') {
                        System.out.println("This cell is occupied! Choose another one!");
                        scanner.nextLine();
                        continue;
                    }

                    // Add the player character to the cell coordinates of the user input
                    board[xAxis-1][yAxis-1] = player;
                    break;
                } else {
                    System.out.println("You should enter numbers!");
                    scanner.nextLine();
                }
            } else {
                System.out.println("You should enter numbers!");
                scanner.nextLine();
            }
        }
    }
}
