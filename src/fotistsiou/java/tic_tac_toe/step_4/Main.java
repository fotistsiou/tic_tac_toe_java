package fotistsiou.java.tic_tac_toe.step_4;

import java.util.Scanner;

/**
 * First move!
 * -----------
 * Description
 * It's time to make our game interactive! Now we're going to add the ability for a user to make a move.
 * To do this, we need to divide the grid into cells.
 * Suppose the top left cell has the coordinates (1, 1) and the bottom right cell has the coordinates (3, 3):
 * (1, 1) (1, 2) (1, 3)
 * (2, 1) (2, 2) (2, 3)
 * (3, 1) (3, 2) (3, 3)
 * The program should ask the user to enter the coordinates of the cell where they want to make a move.
 * In this stage, the user plays as X, not O.
 * Keep in mind that the first coordinate goes from top to bottom and the second coordinate goes from left to right.
 * The coordinates can include the numbers 1, 2, or 3.
 * What happens if the user enters incorrect coordinates?
 * The user could enter symbols instead of numbers,
 * or enter coordinates representing occupied cells or cells that aren't even on the grid.
 * You need to check the user's input and catch possible exceptions.
 * -----------
 * Objectives
 * The program should work as follows:
 * 1. Get the initial 3x3 grid from the input as in the previous stages.
 *    Here the user should input 9 symbols representing the field, for example, _XXOO_OX_.
 * 2. Output this 3x3 grid as in the previous stages.
 * 3. Prompt the user to make a move. The user should input 2 coordinate numbers that represent the cell
 *    where they want to place their X, for example, 1 1.
 * 4. Analyze user input. If the input is incorrect, inform the user why their input is wrong:
 *    - Print This cell is occupied! Choose another one! if the cell is not empty.
 *    - Print You should enter numbers! if the user enters non-numeric symbols in the coordinates input.
 *    - Print Coordinates should be from 1 to 3! if the user enters coordinates outside the game grid.
 *    - Keep prompting the user to enter the coordinates until the user input is valid.
 * 5. If the input is correct, update the grid to include the user's move and print the updated grid to the console.
 * To summarize, you need to output the field 2 times: once before the user's move (based on the first line of input)
 * and once after the user has entered valid coordinates (then you need to update the grid to include that move).
 */

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to make a 3x3 grid and output this grid
        String input = scanner.nextLine();
        char[][] board = new char[3][3];
        System.out.println("---------");
        int index = 0;
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                char inputChar = input.charAt(index++);
                board[i][j] = inputChar == 'X' || inputChar == 'O' ? inputChar : ' ';
                System.out.print(board[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");

        // Prompt the user to make a move & analyze user input
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
                    board[xAxis-1][yAxis-1] = 'X';
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

        // Output the grid with user input
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");

        scanner.close();
    }
}
