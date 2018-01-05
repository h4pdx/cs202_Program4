package cs202_program4;

/* Ryan Hoover
 * CS 202 - Fant
 * Program 4 - 06/02/2017
 */
import java.io.IOException;

/**
 * Created by ryan on 6/1/17.
 * Doubly-Linked List of Nodes (pizza)
 * Allows user to see list of orders this session, either from the oldest or the most recent
 * Inserts always new Pizza order at head
 */

// doubly linked list
public class Orders extends Util {
    private Node head;
    private Node tail;
    private int pizzaCount;

    // node of these are actually used, thought they might be worth having at first
    public Node getHead() {return this.head;}

    public Node getTail() {return this.tail;}

    public void setHead(Node head) {this.head = head;}

    public void setTail(Node tail) {this.tail = tail;}

    public int OrderPizza() throws IOException {
        int orderCount = 0;
        do { // Again()
            System.out.println("\nBuild your Pizza!");
            Node temp;
            do { // Confirm()
                temp = new Node(); // new node if !Confirm(), otherwise would rack up $50 + Pizzas upon repeat
                temp.BuildPizza(); // Pizza object takes user input for custom Pizza
                temp.Display(); // Present user with what they selected one more time, pending confirmation
            } while (!Confirm()); // last in a series of confirmations starting within Pizza.BuildPizza()
            // manage references, always insert at beginning
            temp.setNext(head); // is head == null, then temp->next is correctly null
            temp.setPrev(null); // the first node in the list is always prev==null
            // set next node's previous to current
            if (head != null) {
                head.setPrev(temp); // 2nd node now points back to first node, and so on as list grows
            }
            head = temp; // update head
            ++this.pizzaCount; // keep track of how many orders placed
            // this condition should only happen on the first insert
            if (head.getNext() == null) {
                tail = head; // will be pushed to back, as list grows
            }
        } while (Again()); // why not order more than one at a time??
        orderCount = pizzaCount;
        return orderCount;
    }

    // display list
    public void AllOrders() {
        if (head == null)
            return;
        System.out.println("\nAll Pizzas(" + pizzaCount + " Orders), starting at most recent order.");
        AllOrders(head);
        return;
    }

    // recursive
    private void AllOrders(Node head) {
        if (head == null)
            return;

        head.Display();
        AllOrders(head.getNext());
        return;
    }

    // display from the back of the list, forward (wrapper for recursive function)
    public void OldestOrders () {
        if (tail == null)
            return;
        System.out.println("\nAll Pizzas (" + pizzaCount + " Orders), starting at the oldest order.");
        OldestOrders(tail);
    }

    // recursive display
    private void OldestOrders(Node tail) {
        if (tail == null)
            return;
        tail.Display();
        OldestOrders(tail.getPrev());
    }
}
