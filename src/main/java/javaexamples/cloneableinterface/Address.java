package javaexamples.cloneableinterface;

import java.util.Objects;

class Address implements Cloneable {
    String city;
    String country;

    Address(String city, String country) {
        this.city = city;
        this.country = country;
    }

    // Overriding clone() for Address class
    @Override
    public Object clone() {
        try {
            return super.clone();  // Shallow copy for Address object (since it's simple)
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(city, address.city) && Objects.equals(country, address.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, country);
    }
}