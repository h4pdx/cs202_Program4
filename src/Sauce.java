package cs202_program4;

/* Ryan Hoover
 * CS 202 - Fant
 * Program 4 - 06/02/2017
 */
/**
 * Created by ryan on 6/1/17.
 * Sauce subclass, one per Pizza
 * Input() presents user with options and allows customization of Sauce object
 * User picks from pre-determined options, not making up their own sauces
 */

public class Sauce extends Ingredient {
    private String amount;

    public Sauce() {
        //super.name = null;
        this.amount = new String();
    }

    // argument constructor
    public Sauce(Sauce source) {
        //super.name = new String(source.name);
        super(source);
        this.amount = new String(source.amount);
    }

    // argument constructor
    public Sauce(String name, boolean isVegan, int price, String amount) {
        super(name, isVegan, price);
        this.amount = new String(amount);
    }

    // user picks from multiple possible combinations
    public void Input() {
        super.price = 0;// reset super.price before each new order
        int userChoice = 0, price = 0; // userChoice will be used for the switch statements
        String name, amount;
        boolean isVegan;
        System.out.println("\nSauce options:" +
                "\n>>\t(1) Classic Tomato" +
                "\n>>\t(2) Ranch (+$1.00)" +
                "\n>>\t(3) Barbecue (+$2.00)");
        do {
            price = 0; // reset each loop, prevent accumulating $50 pizzas if !Confirm()
            System.out.print("\nEnter a number: ");
            userChoice = input.nextInt();
            input.nextLine();
            // assign fields based on number selected
            switch (userChoice) {
                case 1:
                    name = "Classic Tomato";
                    isVegan = true;
                    price = 0;
                    break;
                case 2:
                    name = "Ranch";
                    isVegan = false;
                    price = 1;
                    break;
                case 3:
                    name = "Barbecue";
                    isVegan = false;
                    price = 2;
                    break;
                default:
                    name = "Classic Tomato";
                    isVegan = true;
                    price = 0;
                    break;
            }
            // review of choices
            System.out.print("\nYou chose: " + name);
            if (price > 0) {
                System.out.println(" (+$" + price + ".00)");
            }
            else System.out.println(); // just for the newline, if added price isn't displayed
        } while (!Confirm());
        // if user confirms choices, add to class fields
        super.name = new String(name);
        super.isVegan = isVegan;
        if (price > 0) super.price += price;
        // second and final option for sauce
        System.out.println("\nSauce amount:" +
                "\n\t(1) Normal " +
                "\n\t(2) Light " +
                "\n\t(3) Extra (+$1.00)");
        do {
            price = 0; // reset for next use
            System.out.print("\nEnter a number: ");
            userChoice = input.nextInt(); // take user input based on menu selection
            input.nextLine();
            // assign fields based on number selected
            switch (userChoice) {
                case 1:
                    amount = "Normal";
                    break;
                case 2:
                    amount = "Light";
                    break;
                case 3:
                    amount = "Extra";
                    price = 1;
                    break;
                default:
                    amount = "Normal";
                    break;
            }
            // review of choices
            System.out.println("\nYou chose: " + amount);
            if (price > 0) {
                System.out.println(" (+$" + price + ".00)");
            }
            else System.out.println(); // just for the newline, if added price isn't displayed
        } while (!Confirm());
        // update fields
        this.amount = new String(amount);
        if (price > 0) super.price += price;
    }

    // Display Sauce object fields
    public void Display() {
        System.out.print("\n" + super.name + " Sauce, " +
            this.amount + " Amount");
        // only display added price if there is one
        if (super.price > 0) {
            System.out.print(" (+ $" + super.price +".00)");
        }
    }

}
