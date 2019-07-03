package tech.marzoog.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CustomerService {

    private  Date timeZero;
    private int runningTime;
    private LinkedListQueue customerLine;
    private List<String> report = new ArrayList<>();
    private Calendar calendar = Calendar.getInstance();

    public CustomerService(int runningTime) {
        this.runningTime = runningTime;
        timeZero = new Date();
        customerLine = new LinkedListQueue();
    }

    public void addingCustomers(){
        for (int i = 0, j =1; i < runningTime; j++, i+=4) {
            Node adding = customerLine.enqueue(new Customer(j, i, timeZero));
            report.add(adding.customer.getCustomerArrivalTime());
        }
    }

    public void removingCustomers(){
        for(int i = 7; i< runningTime; i+=7){
            Node removing = customerLine.dequeue(i, timeZero);
            report.add(removing.customer.getCustomerLeavingTime());
        }
    }

    public void printReport(){
        report.stream()
                  .sorted()
                .map(s -> String.format("___________________________________%n%s", s))
                .forEach(System.out::println);
        System.out.printf("%nCustomer number %d is the current serving customer.%n", customerLine.servingCustomer());
        System.out.printf("There are %d customers in the line.%n", customerLine.getSize()-1);
    }

    public static void getReport(int minutes){
        CustomerService customerService = new CustomerService(minutes);
        customerService.calendar.setTime(customerService.timeZero);
        customerService.calendar.add(Calendar.MINUTE, -1 * minutes);
        customerService.timeZero = customerService.calendar.getTime();
        customerService.addingCustomers();
        customerService.removingCustomers();
        customerService.printReport();
    }
}
