package edu.tutorial.classes;

/**
 * Created by vladimirkr on 7/10/2015.
 */
public class GroceryItem {
    private String name;
    private int price;
    private int amount;
    private Measures measure;

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }

    public Measures getMeasure() {
        return measure;
    }

    @Override
    public String toString() {
        return "GroceryItem{" +
                "name='" + name + '\'' +
                '}';
    }

    private GroceryItem(Builder builder) {
        this.name = builder.name;
        this.price = builder.price;
        this.amount = builder.amount;
        this.measure = builder.measure;
    }

    public static class Builder {
        private String name;
        private int price;
        private int amount;
        private Measures measure;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setPrice(int price) {
            this.price = price;
            return this;
        }

        public Builder setAmount(int amount) {
            this.amount = amount;
            return this;
        }

        public Builder setMeasure(Measures measure) {
            this.measure = measure;
            return this;
        }

        public GroceryItem build() {
            return new GroceryItem(this);
        }
    }
}
