package edu.tutorial.classes;

/**
 * Created by vladimirkr on 7/10/2015.
 */
public class Customer {
    private String name;
    private String mail;

    public String getName() {
        return name;
    }
    public String getMail() {
        return mail;
    }

    private Customer(Builder builder) {
        this.name = builder.name;
        this.mail = builder.mail;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }

    public static class Builder {
        private String name;
        private String mail;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setMail(String mail) {
            this.mail = mail;
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }
    }
}
