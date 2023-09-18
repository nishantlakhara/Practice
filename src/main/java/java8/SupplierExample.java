package java8;

import java.util.function.Supplier;

public class SupplierExample {

    public static void main(String[] args) {
        Supplier<String> supplier = () -> "sukh";
        System.out.println(supplier.get());
    }
}
