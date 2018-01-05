package cs202_program4;

/* Ryan Hoover
 * CS 202 - Fant
 * Program 4 - 06/02/2017
 */
import java.io.IOException;

/**
 * Created by ryan on 6/1/17.
 * Derived from Pizza, the list of orders will manipulate node object
 * all setters and getters for next and previous references
 * argument constructor is available but not currently used
 */

public class Node extends Pizza {
    private Node next;
    private Node prev;

    public Node() throws IOException {this.next = this.prev = null;}

    public Node(Pizza source) {super(source);}

    public Node getNext() {return this.next;} // simple getters, manipulated by list class (Orders)

    public Node getPrev() {return this.prev;}

    public void setNext(Node next) {this.next = next;} // simple setters

    public void setPrev(Node prev) {this.prev = prev;}
}
