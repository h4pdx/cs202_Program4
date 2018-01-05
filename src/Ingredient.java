package cs202_program4;

import java.io.*;

/**
 * Created by ryan on 6/1/17.
 * Abstract base class for pizza ingredients (topping, sauce, crust
 */
abstract public class Ingredient extends Util {
    protected String name;
    protected boolean isVegan;
    protected int price;

    public Ingredient() {
        this.name = new String();
        this.isVegan = false;
        this.price = 0;
    }

    public Ingredient(String name, boolean isVegan, int price) {
        this.name = new String(name);
        this.isVegan = isVegan;
        this.price = price;
    }
    public Ingredient(Ingredient source) {
        this.name = new String(source.name);
        this.isVegan = source.isVegan;
        this.price = source.price;
    }

    /*
    public void WriteFile() {
        String fileName = "ingredient.txt";
        FileWriter writer = null;
        try {
            writer = new FileWriter(fileName);
            BufferedWriter output = null;
            if (writer != null)
                output = new BufferedWriter(writer);
            output.write(this.name);
            output.flush();
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    */


    //abstract public void ReadFile();

    //abstract public int input();
    //as long as class is abstract, the methods can be mimicked in the subclasses
    abstract public void Input();

    abstract public void Display();

    public boolean equals(String toMatch) {
        boolean isMatch = false;
        if (this.name.equals(toMatch)) {
            isMatch = true;
        }
        return isMatch;
    }

    public boolean isVegan() {return this.isVegan;}

    public int getPrice() {return this.price;}



}
