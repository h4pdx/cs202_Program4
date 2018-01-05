package cs202_program4;

/* Ryan Hoover
 * CS 202 - Fant
 * Program 4 - 06/02/2017
 */
import java.util.Scanner;
/**
 * Created by ryan on 6/1/17.
 * Utility methods usable by all classes,
 * loop controls (Again, Confirm, BackToMenu)
 * universal input object
 */

public class Util {
    protected Scanner input;
    public static int SIZE = 25; // global constant
    public Util() {input = new Scanner(System.in);}

    // used as loop control for user to add more ingredients, add another Pizza, etc.
    public boolean Again() {
        String response;
        do {
            System.out.print(" >> Again? (y,n): ");
            response = input.next();
            input.nextLine();
        } while (!response.toUpperCase().equals("Y") && !response.toUpperCase().equals("N"));
        return (response.toUpperCase().equals("Y"));
    }

    // used as loop condition for user input, if !Confirm, start loop over
    public boolean Confirm() {
        String response;
        do {
            System.out.print(" >> Confirm? (y,n): ");
            response = input.next();
            input.nextLine();
        } while ((!response.toUpperCase().equals("Y")) && (!response.toUpperCase().equals("N")));
        return (response.toUpperCase().equals("Y"));
    }

    // used in menu system to let user go back to the menu selection, 'No' quits program
    public boolean BackToMenu() {
        String response;
        do {
            System.out.print(" >> Back to menu? (y,n): ");
            response = input.next();
            input.nextLine();
        } while (!response.toUpperCase().equals("Y") && !response.toUpperCase().equals("N"));
        return (response.toUpperCase().equals("Y"));
    }

    // Capitalize input,
    public String Capitalize(String source) {
        char [] array = source.toCharArray();
        array[0] = Character.toUpperCase((array[0]));
        return new String(array);
    }

    // display a main menu from the program boot
    public int Menu() {
        int userChoice = 0;
        System.out.println("\n+ + Main Menu + + + +" +
                "\nPress > 1 < To Order a Pizza!" +
                "\nPress > 2 < To See All orders, starting from most Recent." +
                "\nPress > 3 < To See All orders, starting at the Oldest." +
                "\nPress > 4 < To Quit Program.");
        do {
            System.out.print("\n >> Enter a number: ");
            userChoice = input.nextInt();
            input.nextLine();
        } while (userChoice > 4);
        return userChoice;
    }
}
