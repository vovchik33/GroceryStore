package edu.tutorial.classes;

/**
 * Created by vladimirkr on 7/10/2015.
 */
public class Clerk {
    private String name;

    private Clerk(Builder builder) {
        this.name = builder.name;
    }

    @Override
    public String toString() {
        return "Clerk{" +
                "name='" + name + '\'' +
                '}';
    }

    public static class Builder {
        private String name;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Clerk build() {
            return new Clerk(this);
        }
    }
}
