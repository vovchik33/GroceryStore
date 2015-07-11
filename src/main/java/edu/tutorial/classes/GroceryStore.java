package edu.tutorial.classes;

import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.List;

/**
 * Created by vladimirkr on 7/10/2015.
 */
public class GroceryStore {
    List<GroceryItem> groceries;
    List<Clerk> clerks;
    List<Customer> customers;

    public List<GroceryItem> getGroceries() {
        return groceries;
    }

    public List<Clerk> getClerks() {
        return clerks;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    private GroceryStore(Builder builder) {
        Logger.getLogger(GroceryStore.class).info("Store created.");
        groceries = builder.groceries;
        clerks = builder.clerks;
        customers = builder.customers;
    }

    @Override
    public String toString() {
        return "GroceryStore{" +
                "groceries=" + groceries +
                ", clerks=" + clerks +
                ", customers=" + customers +
                '}';
    }

    public static class Builder {
        List<GroceryItem> groceries;
        List<Clerk> clerks;
        List<Customer> customers;

        public Builder setGroceries(List<GroceryItem> groceries) {
            this.groceries = groceries;
            return this;
        }

        public Builder setClerks(List<Clerk> clerks) {
            this.clerks = clerks;
            return this;
        }

        public Builder setCustomers(List<Customer> customers) {
            this.customers = customers;
            return this;
        }

        public GroceryStore build() {
            return new GroceryStore(this);
        }
    }
}
