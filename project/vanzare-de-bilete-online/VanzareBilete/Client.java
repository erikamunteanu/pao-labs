package VanzareBilete;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Client {
    protected String firstName;
    protected String lastName;
    protected int age;
    protected String phoneNo;
    protected List<Ticket> T = new ArrayList<Ticket>();

    public Client(String firstName, String lastName, int age, String phoneNo) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.phoneNo = phoneNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public void buyStandardTicket(StandardTicket x) {
        this.T.add(x);
        System.out.println("Standard ticket successfully bought!");
        System.out.println("*** Your purchase *** " + x.event.showEvent() + " for " + x.getPrice() + "$");
    }

    public void buyPremiumTicket(PremiumTicket x) {
        this.T.add(x);
        System.out.println("Premium ticket successfully bought!");
        System.out.println("*** Your purchase *** " + x.event.showEvent() + " for " + x.getPrice() + "$");
    }

    public void showMyTickets() {
        System.out.println("Tickets of " + this.getFirstName() + " " + this.getLastName() + ": ");
                for(Ticket t : T) {
                    System.out.println(t.event.showEvent());
                }
    }
}
