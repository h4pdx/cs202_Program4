package cs202_program4;

/* Ryan Hoover
 * CS 202 - Fant
 * Program 4 - 06/02/2017
 */
/**
 * Created by ryan on 6/1/17.
 * One type of crust per Pizza
 * Input() and Display are main functionality
 * user customizes Crust options based on a series of prompts
 */
public class Crust extends Ingredient {
    private String cut;
    private String size;

    public Crust() {
        this.cut = new String();
        this.size = new String();

    }

    public Crust(Crust source) {
        super(source);
        this.cut = new String(source.cut);
        this.size = new String(source.size);
    }

    public void Input() {
        super.price = 0; // reset, to prevent accumulating $50 pizzas
        int userChoice = 0, price = 0;
        boolean isVegan = false;
        String name, size, cut;
        System.out.println("\nWhat size?: " +
                "\n>>\t(1) Large (16\") - $14.00" +
                "\n>>\t(2) Medium (14\") - $12.00" +
                "\n>>\t(3) Small (12\") - $10.00");
        do {
            System.out.print("\nEnter a number: ");
            userChoice = input.nextInt(); // user input for menu choices
            input.nextLine();
            // assign fields based on number selected
            switch (userChoice) {
                case 1:
                    size = "Large";
                    price = 14;
                    break;
                case 2:
                    size = "Medium";
                    price = 12;
                    break;
                case 3:
                    size = "Small";
                    price = 10;
                    break;
                default:
                    size = "Large";
                    price = 14;
                    break;
            }
            // review choices
            System.out.println("\nYou chose: (" + userChoice + ") " + size +
                    " - $" + price + ".00");
        } while (!Confirm()); // repeat size portion
        // if confirm, copy into class fields
        this.size = new String(size);
        super.price += price;
        // user decides more crust options
        System.out.println("\nCrust options:" +
                "\n>>\t(1) Classic Crust" +
                "\n>>\t(2) Crispy Thin Crust" +
                "\n>>\t(3) Chicago Deep Dish (+$2.00)" +
                "\n>>\t(4) Gluten-Free (+$1.00)");
        do {
            price = 0; // reset price if user !Confirm()
            System.out.print("\nEnter a number: ");
            userChoice = input.nextInt(); // another user option
            input.nextLine();
            // assign fields based on number selected
            switch (userChoice) {
                case 1:
                    name = "Classic";
                    isVegan = true;
                    break;
                case 2:
                    name = "Thin";
                    isVegan = true;
                    break;
                case 3:
                    name = "Deep-Dish";
                    isVegan = false;
                    price = 2;
                    break;
                case 4:
                    name = "Gluten-Free";
                    isVegan = true;
                    price = 1;
                    break;
                default:
                    name = "Classic";
                    isVegan = true;
                    break;
            }
            // review choices
            System.out.print("\nYou chose: (" + userChoice + ") " + name);
            // only display price if added to it
            if (price > 0) {
                System.out.println(" (+$" + price + ".00)");
            }
            else System.out.println(); // just for the newline, if added price isn't displayed
        } while (!Confirm()); // repeat crust portion
        // update fields if choices confirmed
        super.name = new String(name);
        super.isVegan = isVegan;
        super.price += price;
        // final crust options
        System.out.println("\nHow do you want it cut?: " +
                "\n>>\t(1) Classic Triangle Cut" +
                "\n>>\t(2) Square Cut" +
                "\n>>\t(3) Special Request - Pizza Art (+$2.00)");
        do {
            price = 0; // reset since last use
            System.out.print("\nEnter a number: ");
            userChoice = input.nextInt(); // last crust option
            input.nextLine();
            // assign fields based on number selected
            switch (userChoice) {
                case 1:
                    cut = "Classic";
                    break;
                case 2:
                    cut = "Square";
                    break;
                case 3:
                    // user can order a custom Pizza shape or something
                    do {
                        System.out.print("\nSpecial Request (within reason, plz): ");
                        cut = input.nextLine();
                        System.out.println("\nYou entered:\n" + cut);
                    } while (!Confirm());
                    // charge for parts & labor
                    price = 2;
                    break;
                default:
                    cut = "Classic";
                    break;
            }
            // review of choices, final confirmation
            System.out.print("\nYou chose: ("+ userChoice +") " + cut);
            if (price > 0) {
                System.out.println(" (+$" + price + ".00)");
            }
            else System.out.println(); // just for the newline, if extra price wasn't displayed
        } while (!Confirm()); // repeat cut portion
        // update fields upon confirmation
        this.cut = new String(cut);
        super.price += price;
    }

    // Crust data display
    public void Display() {
        System.out.print("\n" + this.size + " Size - $" + super.price + ".00" +
                "\n" + super.name + " Crust, " + this.cut + " Cut.");
    }
}
