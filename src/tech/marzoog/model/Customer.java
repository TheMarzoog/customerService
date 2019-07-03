package tech.marzoog.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Customer {

    private Date customerArrivalTime;
    private Date customerLeavingTime;
    private int customerNumber;
    private static DateFormat dateFormat = new SimpleDateFormat("HH:mm");
    private Calendar calendar = Calendar.getInstance();

    public Customer(int customerNumber, int minutesAfter, Date timeZero){
        this.customerNumber = customerNumber;
        calendar.setTime(timeZero);
        calendar.add(Calendar.MINUTE, minutesAfter);
        customerArrivalTime = calendar.getTime();
    }


    public String getCustomerArrivalTime (){
        String date = dateFormat.format(customerArrivalTime);
        return String.format("%s customer number %d arrived.", date, customerNumber);
    }

    public void setCustomerLeavingTime(int minutes, Date timeZero) {
        calendar.setTime(timeZero);
        calendar.add(Calendar.MINUTE, minutes);
        customerLeavingTime = calendar.getTime();
    }

    public String getCustomerLeavingTime() {
        String date = dateFormat.format(customerLeavingTime);
        return String.format("%s customer number %d leaved.", date, customerNumber);
    }

    public int getCustomerNumber(){
        return customerNumber;
    }

    @Override
    public String toString() {
        return String.format(
                "%d)customer%nArrived at: %s%nLeaved at: %s",
                customerNumber,
                getCustomerArrivalTime(),
                getCustomerLeavingTime()
        );
    }
}
