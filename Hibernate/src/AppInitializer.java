import entity.Customer;
import entity.Item;
import entity.OrderDetails;
import entity.Orders;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.FactoryConfiguration;

import java.time.LocalDate;

public class AppInitializer {
    public static void main(String[] args) {
        LocalDate x=LocalDate.now();

        Session session = FactoryConfiguration.getInstance().getSession();

        Transaction transaction = session.beginTransaction();

        /**  Customer (C R U D)  */

        session.save(new Customer("CI001","Piyal","Colombo",50000.00));
        session.save(new Customer("CI002","Nishantha","Negombo",35000.00));
        session.save(new Customer("CI003","Isuru","Colombo",80000.00));

        Customer c1 = session.get(Customer.class, "CI002");
        System.out.println(c1.getId()+" - "+c1.getName()+" - "+c1.getSalary()+" - "+c1.getAddress());

        Customer c2 = new Customer("CI003","Isuru","Bandaragama",80000.00);
        session.update(c2);

        session.delete(session.get(Customer.class,"CI003"));

        /**  Item (C R U D)  */
        session.save(new Item("II001","Rice",1500,50));
        session.save(new Item("II002","Noodles",650,80));
        session.save(new Item("II003","Milk",1700,200));

        Item i1 = session.get(Item.class, "II003");
        System.out.println(i1.getItemCode()+" - "+i1.getDescription()+" - "+i1.getUnitPrice()+" - "+i1.getQty());

        Item i2= new Item("II003","Milk",1950,250);
        session.update(i2);

        session.delete(session.get(Item.class,"II003"));

        /**  ORDERS (C R U D)  */
        session.save(new Orders("OI001",x,session.get(Customer.class,"CI001")));
        session.save(new Orders("OI002",x,session.get(Customer.class,"CI001")));
        session.save(new Orders("OI003",x,session.get(Customer.class,"CI002")));
        session.save(new Orders("OI004",x,session.get(Customer.class,"CI002")));


        Orders o1 = session.get(Orders.class, "OI004");


        session.delete(o1);

        /**  ORDER DETAILS(C R U D)  */

        Orders od1 = session.get(Orders.class, "OI001");
        Orders od2 = session.get(Orders.class, "OI002");

        Item ii1 = session.get(Item.class, "II001");
        Item ii2 = session.get(Item.class, "II002");

        session.save(new OrderDetails("ODT001",od1,ii1, ii1.getUnitPrice(),4));
        session.save(new OrderDetails("ODT002",od1,ii1, ii2.getUnitPrice(),10));

        session.save(new OrderDetails("ODT003",od1,ii2, ii2.getUnitPrice(),8));
        session.save(new OrderDetails("ODT004",od2,ii1, ii1.getUnitPrice(),10));

        session.save(new OrderDetails("ODT005",od2,ii2, ii2.getUnitPrice(),11));
        session.save(new OrderDetails("ODT006",od2,ii2, ii2.getUnitPrice(),6));

        OrderDetails dd1 = session.get(OrderDetails.class, "ODT005");
        dd1.setUnitPrice(590);
        session.update(dd1);

        session.delete(session.get(OrderDetails.class,"ODT006"));


        transaction.commit();

        session.close();
    }
}
