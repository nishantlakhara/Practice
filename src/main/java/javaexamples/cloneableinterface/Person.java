package javaexamples.cloneableinterface;

import java.util.Objects;

public class Person implements Cloneable {
    String name;
    int age;
    Address address;

    Person(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    // Overriding clone() to create a deep copy
    @Override
    public Person clone() {
        try {
            Person cloned = (Person) super.clone();  // Shallow copy
            cloned.address = (Address) address.clone();  // Deep copy of the address object
            return cloned;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name) && Objects.equals(address, person.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, address);
    }
}

