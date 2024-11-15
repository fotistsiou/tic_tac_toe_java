package fotistsiou.java.tic_tac_toe.step_2;

import java.util.Scanner;

/**
 * The user is the GameMaster.
 * ---------------------------
 * Description
 * Our program should be able to display the grid at all stages of the game.
 * Now we’re going to write a program that allows the user to enter a string representing the game state and correctly
 * prints the 3x3 game grid based on this input. We’ll also add some boundaries around the game grid.
 * ---------------------------
 * Objectives
 * In this stage, you will write a program that:
 * Reads a string of 9 symbols from the input and displays them to the user in a 3x3 grid.
 * The grid can contain only X, O and _ symbols.
 * Outputs a line of dashes --------- above and below the grid,
 * adds a pipe | symbol to the beginning and end of each line of the grid,
 * and adds a space between all characters in the grid.
 */

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();

        char first = input.charAt(0);
        char second = input.charAt(1);
        char third = input.charAt(2);
        char fourth = input.charAt(3);
        char fifth = input.charAt(4);
        char sixth = input.charAt(5);
        char seventh = input.charAt(6);
        char eighth = input.charAt(7);
        char ninth = input.charAt(8);
        
        System.out.println("---------");
        System.out.println("| " + first + " " + second + " " + third + " |");
        System.out.println("| " + fourth + " " + fifth + " " + sixth + " |");
        System.out.println("| " + seventh + " " + eighth + " " + ninth + " |");
        System.out.println("---------");
    }
}
