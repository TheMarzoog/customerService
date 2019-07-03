package tech.marzoog.model;


public class Node {

    Customer customer;
    Node next;

    public Node(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return customer.toString();
    }
}
