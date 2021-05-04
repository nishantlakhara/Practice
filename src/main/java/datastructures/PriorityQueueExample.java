package datastructures;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueExample {
    public static void main(String[] args) {
        example1();

        example2();
    }

    private static void example2() {
        PriorityQueue<Book> priorityQueue = new PriorityQueue<>();

        priorityQueue.add(new Book("Gopal", 100));
        priorityQueue.add(new Book("Arvind", 50));
        priorityQueue.add(new Book("Raj", 120));
        priorityQueue.add(new Book("SHaran", 70));
        priorityQueue.add(new Book("Om", 130));

        System.out.println(priorityQueue);
        Book value = priorityQueue.poll();
        System.out.println(value);

        System.out.println(priorityQueue);
        value = priorityQueue.poll();
        System.out.println(value);

        System.out.println(priorityQueue);
        value = priorityQueue.poll();
        System.out.println(value);

        System.out.println(priorityQueue);
        value = priorityQueue.poll();
        System.out.println(value);

        System.out.println(priorityQueue);
        value = priorityQueue.poll();
        System.out.println(value);

    }

    static class Book implements Comparable<Book> {
        String author;
        Integer price;

        public Book(String author, Integer price) {
            this.author = author;
            this.price = price;
        }

        @Override
        public int compareTo(Book o) {
            return this.price.compareTo(o.price);
        }

        @Override
        public String toString() {
            return "Book{" +
                    "author='" + author + '\'' +
                    ", price=" + price +
                    '}';
        }
    }

    private static void example1() {
        PriorityQueue<String> queue=new PriorityQueue<String>(new The_Comparator());
        queue.add("Amit");
        queue.add("Vijay");
        queue.add("Karan");
        queue.add("Jai");
        queue.add("Rahul");

        System.out.println(queue);
        String value = queue.poll();
        System.out.println(value);

        System.out.println(queue);
        value = queue.poll();
        System.out.println(value);

        System.out.println(queue);
        value = queue.poll();
        System.out.println(value);

        System.out.println(queue);
        value = queue.poll();
        System.out.println(value);

        System.out.println(queue);
        value = queue.poll();
        System.out.println(value);
    }

    static class The_Comparator implements Comparator<String> {
        public int compare(String str1, String str2)
        {
            return str2.compareTo(str1);
        }
    }



}
