import java.util.ArrayList;
import java.util.List;

public class Customers {
    static int nextId = 1;
    static final List<Customer> list = new ArrayList<>();

    static Customer find(int id) {
        for (Customer customer : list) {
            boolean foo = true;
            if (customer.getId() == id) {
                return customer;
            }
        }
        return null;
    }

    static List<Customer> getDummyData() {
        Customer customer = Customer.factory(Customer.EType.PRIVATE);
        customer.setId(nextId++);
        customer.setName("Ole Olsen Lorem Ipsumius");
        customer.setPhoneNumber("4121412");
        Seat[] sp = new Seat[1];
        sp[0] = new Seat(0, 0, 0, Seat.STATE.reserved, customer);
//        sp[1] = new Seat(0, 0, 1, customer);
//        sp[2] = new Seat(0, 0, 2, customer);
        customer.setSeats(sp);
        list.add(customer);

        customer = Customer.factory(Customer.EType.RANDOM);
        customer.setId(nextId++);
        customer.setName("Bolle mann");
        customer.setPhoneNumber("113");
        list.add(customer);

        customer = Customer.factory(Customer.EType.COMPANY);
        customer.setId(nextId++);
        customer.setName("Oskar");
        customer.setPhoneNumber("5123124");
        Seat[] sc = new Seat[2];
        sc[0] = new Seat(0, 4, 6, Seat.STATE.reserved, customer);
        sc[1] = new Seat(0, 4, 7, Seat.STATE.reserved, customer);
        customer.setSeats(sc);
        ((Customer.Company) customer).setContactPerson("Sander"); //CASTING
        list.add(customer);

        return list;
    }
}
