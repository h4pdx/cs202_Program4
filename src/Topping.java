package cs202_program4;

/* Ryan Hoover
 * CS 202 - Fant
 * Program 4 - 06/02/2017
 */
/**
 * Created by ryan on 6/1/17.
 * Topping subclass, multiple per Pizza
 * Input is not used, since user will select from an existing array of toppings,
 * not inputting new toppings themselves.
 * Argument constructor and display used in Pizza.BuildPizza(), in conjunction with Pizza.Find()
 */

public class Topping extends Ingredient {
    private int calories; // additional topping info

    public Topping() {
        super();
        this.calories = 0;
    }

    // argument constructor
    public Topping(String name, boolean isVegan, int price, int calories) {
        super(name, isVegan, price);
        this.calories = calories;
    }

    // copy constructor
    public Topping(Topping source) {
        super(source);
        this.calories = source.calories;
    }

    // not needed for topping class (user selects from list of pre-determined items)
    public void Input() {
        System.out.print("\nTopping: ");
        super.name = input.nextLine();
        System.out.print("\nIs vegan?");
        if (Confirm()) {
            super.isVegan = true;
        } else super.isVegan = false;
        System.out.print("\nPrice: ");
        super.price = input.nextInt();
        input.nextLine();
        System.out.print("\nCalories: ");
        this.calories = input.nextInt();
        input.nextLine();
    }

    // display fields, called by Pizza class display
    public void Display() {
        System.out.print(super.name + "\t");
        if (super.price == 0) {
            System.out.print("(No added charge)");
        } else {
            System.out.print("+ $" + super.price + ".00");
        }
        System.out.print("\n\t\t\t" + this.calories + " calories");
    }
}
