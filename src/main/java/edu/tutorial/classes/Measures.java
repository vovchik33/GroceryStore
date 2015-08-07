package edu.tutorial.classes;

/**
 * Created by vladimirkr on 7/10/2015.
 */
public enum Measures {
    INCH("INCH", "inch"), FOOT("FOOT", "f"), METRE("METRE", "m"), GRAM("GRAM", "gr"), KILOGRAM("KILOGRAM", "kg"), LITRE("LITRE", "l"), AMOUNT("AMOUNT", "item");

    private String valueName;
    private String shortening;

    private Measures(String valueName, String shortening) {
        this.valueName = valueName;
        this.shortening = shortening;
    }

    @Override
    public String toString() {
        return "Measures{" +
                "valueName='" + valueName + '\'' +
                "shortening='" + shortening + '\'' +
                "valueIndex='" + valueIndex() + '\'' +
                '}';
    }

    public String getValueName() {
        return valueName;
    }

    public String getShortening() {
        return shortening;
    }

    public int valueIndex() {
        return valueName.hashCode();
    }

}
