package cs202_program4;

/* Ryan Hoover
 * CS 202 - Fant
 * Program 4 - 06/02/2017
 */
import java.io.IOException;

public class Main extends Util {

    public static void main(String[] args) throws IOException {
	// write your code here
        /*
        Pizza myPizza = new Pizza();
        myPizza.BuildPizza();
        myPizza.Display();
        */
        Util myUtil = new Util();
        System.out.println("\nWelcome to Papa Bless® Pizza!");
        Orders myOrder = new Orders();
        int menu = 0;
        //myOrder.OrderPizza();
        //myOrder.AllOrders();
        //myOrder.OldestOrders();

        do {
            menu = myUtil.Menu();
            switch (menu) {
                case 1:
                    myOrder.OrderPizza();
                    break;

                case 2:
                    myOrder.AllOrders();
                    break;

                case 3:
                    myOrder.OldestOrders();
                    break;

            }
        } while (menu != 4 && myUtil.BackToMenu());


    }
}
