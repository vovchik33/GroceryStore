import edu.tutorial.classes.Clerk;
import edu.tutorial.classes.Customer;
import edu.tutorial.classes.GroceryItem;
import edu.tutorial.classes.GroceryStore;
import org.apache.log4j.Logger;

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

        groceries.add(new GroceryItem.Builder().setName("potato").build());
        groceries.add(new GroceryItem.Builder().setName("carrot").build());

        customers.add(new Customer.Builder().setName("Vladimir").build());

        clerks.add(new Clerk.Builder().setName("Valentina").build());

        GroceryStore groceryStore = new GroceryStore.Builder()
                .setClerks(clerks)
                .setCustomers(customers)
                .setGroceries(groceries)
                .build();

        Logger.getLogger(Main.class).info(groceries.toString());
        Logger.getLogger(Main.class).info(customers.toString());
        Logger.getLogger(Main.class).info(clerks.toString());
    }
}
