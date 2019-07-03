package tech.marzoog.model;

import java.util.Date;

public class LinkedListQueue {

    public Node front;
    private int size = 0;



    public Node enqueue(Customer customer){
        Node newCustomer = new Node(customer);
        if(isEmpty()){
            front = newCustomer;
        } else {
            Node pointer = front;
            while(pointer.next != null){
                pointer = pointer.next;
            }
            pointer.next = newCustomer;
        }
        size++;
        return newCustomer;
    }

    public Node dequeue(int minutes, Date timeZero) {
        if(isEmpty())
            throw new IllegalArgumentException("no customers.");
        Node remove = front;
        front = front.next;
        remove.customer.setCustomerLeavingTime(minutes, timeZero);
        size--;
        return remove;

    }

    public int getSize(){
        return size;
    }

    public int servingCustomer(){
        return front.customer.getCustomerNumber();
    }

    public boolean isEmpty(){
        return size == 0;
    }

}
