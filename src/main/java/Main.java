import edu.tutorial.classes.*;
import edu.tutorial.db.DBConnector;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vladimirkr on 7/10/2015.
 */
public class Main {
    public static void main(String[] args) {
        Logger.getLogger(Main.class).info("Application started.");

        List<Clerk> clerks=new ArrayList<Clerk>();
        List<Customer> customers=new ArrayList<Customer>();
        List<GroceryItem> groceries=new ArrayList<GroceryItem>();

        groceries.add(new GroceryItem.Builder().setName("potato").setAmount(100).setPrice(5).setMeasure(Measures.KILOGRAM).build());
        groceries.add(new GroceryItem.Builder().setName("carrot").setAmount(50).setPrice(2).setMeasure(Measures.KILOGRAM).build());
        groceries.add(new GroceryItem.Builder().setName("onion").setAmount(20).setPrice(1).setMeasure(Measures.KILOGRAM).build());
        groceries.add(new GroceryItem.Builder().setName("snikers").setAmount(500).setPrice(1).setMeasure(Measures.AMOUNT).build());

        customers.add(new Customer.Builder().setName("Vladimir").setMail("vovchik33@gmail.com").build());
        customers.add(new Customer.Builder().setName("Sergey").setMail("flashconsult@mail.ru").build());

        clerks.add(new Clerk.Builder().setName("Valentina").build());

        GroceryStore groceryStore = new GroceryStore.Builder()
                .setClerks(clerks)
                .setCustomers(customers)
                .setGroceries(groceries)
                .build();

        Logger.getLogger(Main.class).info(groceries.toString());
        Logger.getLogger(Main.class).info(customers.toString());
        Logger.getLogger(Main.class).info(clerks.toString());

        DBConnector connector = new DBConnector();
        try {
            connector.initConnection();

            for (Clerk item:clerks) {
                connector.registerClerk(item);
            }
            for (Customer item:customers) {
                connector.registerCustomer(item);
            }
            for (GroceryItem item:groceries) {
                connector.registerGroceryItem(item);
            }

            connector.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
