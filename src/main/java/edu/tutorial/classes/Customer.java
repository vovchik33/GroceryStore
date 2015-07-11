package edu.tutorial.classes;

/**
 * Created by vladimirkr on 7/10/2015.
 */
public class Customer {
    private String name;

    public String getName() {
        return name;
    }

    private Customer(Builder builder) {
        this.name = builder.name;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                '}';
    }

    public static class Builder {
        private String name;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }
    }
}
