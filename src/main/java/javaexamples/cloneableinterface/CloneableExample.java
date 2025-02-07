package javaexamples.cloneableinterface;

public class CloneableExample {

    public static void main(String[] args) {
        Address address = new Address("New York", "USA");
        Person p1 = new Person("Alice", 30, address);
        Person p2 = p1.clone();  // Deep copy of Person - native code of JVM. Not implement in Object class.

        // Modify the address in p2
        p2.address.city = "Los Angeles";

        System.out.println("Original: " + p1.address.city);  // New York
        System.out.println("Clone: " + p2.address.city);      // Los Angeles
    }
}
