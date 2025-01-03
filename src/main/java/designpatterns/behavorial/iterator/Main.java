package designpatterns.behavorial.iterator;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        MenuItem menuItem1 = new MenuItem("Rasgulla", "Sweet bengali dish", true, 20);
        MenuItem menuItem2 = new MenuItem("Sondesh", "Sweet bengali dish", true, 30);

        DinerMenuIterator dinerMenuIterator = new DinerMenuIterator(new MenuItem[] {menuItem1, menuItem2});
        iterate(dinerMenuIterator);
    }

    private static void iterate(Iterator<?> iterator) {
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
