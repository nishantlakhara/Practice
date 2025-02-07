package javaexamples.java8.streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsExample {

    public static void main(String[] args) {

        // max
        longestStringUsingStreams();

        // average
        averageAge();

        // anyMatch
        printPrime();

        // Merge two sorted list
        // Stream.concat
        // sorted
        mergeTwoSorted();

        // filter
        intersection();

        // distinct - order is also preserved
        distinctelements();

        // Grouping by
        // summingInt
        // averagingInt
        // Collectors.toMap
        sumByDay();

        // sorted
        // skip first k-1 elemtns
        kthSmallest();

        // Function.identity()
        // Collectors.counting();
        wordFrequency();

        // Collectors.partitioningBy
        partitionAGroup();

        // Collectors.joining()
        concatenateNames();

        // handle infinite streams
        // infiniteRandoms -> Stream.generate(Math::random)
        // infiniteEvens Stream.iterate(0, n -> n + 2)
        handleInfiniteStreams();

        // findFirst, findAny, anyMatch, allMatch, noneMatch, or limit


        // Stream Builder
        streamBuilder();

        // handleNullValues
        handleNullValuesOptional();

        // Objects::nonNull
        removeNulls();

        spliterator();

        nullableStream();

        emptyStream();

        arrayToStream();

        flatMap();
    }

    private static void flatMap() {
        // A list of lists of integers
        List<List<Integer>> listOfLists = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5),
                Arrays.asList(6, 7, 8)
        );

        // Flattening the list of lists into a single stream of integers
        List<Integer> flattenedList = listOfLists.stream()
                .flatMap(List::stream)  // Flatten each list into a stream
                .collect(Collectors.toList());

        // Output the flattened list
        System.out.println(flattenedList);
    }

    private static void arrayToStream() {
        int[] numbers = {1, 2, 3, 4, 5};
        Stream<Integer> stream = Arrays.stream(numbers)
                .boxed();
    }

    private static void emptyStream() {
        Stream<String> emptyStream = Stream.empty();

    }

    private static void nullableStream() {
        String name = null;
        Stream<String> stream = Stream.ofNullable(name);

        // creates empty stream if null value
    }

    // TODO: Implement below
    private static void spliterator() {
//        Spliterator<String> customSpliterator = new CustomSpliterator();
//        Stream<String> customStream = StreamSupport.stream(customSpliterator, false);
    }

    private static void removeNulls() {
        List<String> list = Arrays.asList("apple", null, "banana", null, "orange");
        List<String> nonNullList = list.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        System.out.println("nonNullList =" + nonNullList);
    }

    private static void handleNullValuesOptional() {
        List<String> list = Arrays.asList("apple", null, "banana", null, "orange");
        List<Optional<String>> optionalList = list.stream()
                .map(Optional::ofNullable)
                .collect(Collectors.toList());
        System.out.println("optionalList = " + optionalList);
    }

    private static void streamBuilder() {
        Stream.Builder<Integer> builder = Stream.builder();
        builder.add(1);
        builder.add(2);
        builder.add(3);
        Stream<Integer> stream = builder.build();
    }

    private static void handleInfiniteStreams() {
        infiniteRandoms();

        infiniteEvensStreamIterate();

        fibonacciStream();
    }

    private static void fibonacciStream() {
        Stream<Long> fibonacciStream = Stream.iterate(new long[]{0, 1}, f -> new long[]{f[1], f[0] + f[1]})
                .map(f -> f[0]);

        // Limit to first 10 Fibonacci numbers
        fibonacciStream
                .limit(10)
                .forEach(System.out::println);
    }

    private static void infiniteEvensStreamIterate() {
        // Infinite stream of even numbers starting from 0
        Stream<Integer> infiniteEvens = Stream.iterate(0, n -> n + 2);

        // Use limit() to process only a few items
        infiniteEvens
                .limit(5)  // Limit to 5 even numbers
                .forEach(System.out::println);
    }

    private static void infiniteRandoms() {
        // Infinite stream of random numbers
        Stream<Double> infiniteRandoms = Stream.generate(Math::random);

        // Use limit() to process only a few items
        infiniteRandoms
                .limit(5)  // Limit to 5 random numbers
                .forEach(System.out::println);
    }

    private static void concatenateNames() {
        List<String> names = Arrays.asList("John", "Alice", "Bob", "Jane");
        String concatenatedNames = names.stream()
                .collect(Collectors.joining(", "));

        System.out.println("concatenatedNames = " + concatenatedNames);
    }

    private static void partitionAGroup() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Map<Boolean, List<Integer>> partitioned = numbers
                .stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));
        List<Integer> evenNumbers = partitioned.get(true);
        List<Integer> oddNumbers = partitioned.get(false);
        System.out.println("Even numbers: " + evenNumbers);
        System.out.println("Odd numbers: " + oddNumbers);
    }

    private static void wordFrequency() {

        List<String> words = Arrays.asList(
                "apple", "banana", "apple", "cherry",
                "banana", "apple", "banana", "apple", "cherry", "cherry",
                "apple", "banana", "apple", "cherry",
                "banana", "apple", "banana", "apple", "cherry", "cherry",
                "apple", "banana", "apple", "cherry",
                "banana", "apple", "banana", "apple", "cherry", "cherry",
                "apple", "banana", "apple", "cherry", "cherry",
                "banana", "apple", "banana", "apple", "cherry", "cherry",
                "apple", "banana", "apple", "cherry",
                "banana", "apple", "banana", "apple", "cherry", "cherry",
                "apple", "banana", "apple", "cherry");

        Map<String, Long> wordFrequency = words
                .stream()
                .collect(Collectors
                        .groupingBy(Function.identity(), Collectors.counting())
                );

        System.out.println("Word Frequency = " + wordFrequency);
    }

    private static void kthSmallest() {
        int[] array = {4, 2, 7, 1, 5, 3, 6};
        int k = 3; // Find the 3rd smallest element
        int kthSmallest = Arrays.stream(array)
                .sorted()
                .skip(k - 1)
                .findFirst()
                .orElse(-1);

        System.out.println(kthSmallest);
    }

    private static void sumByDay() {
        List<Transaction> transactions = Arrays.asList(
                new Transaction("2022-01-01", 100),
                new Transaction("2022-01-01", 200),
                new Transaction("2022-01-02", 300),
                new Transaction("2022-01-02", 400),
                new Transaction("2022-01-03", 500)
        );

        Map<String, Integer> sumByDay = transactions
                .stream()
                .collect(Collectors.groupingBy(Transaction::getDate,
                        Collectors.summingInt(Transaction::getAmount)));
        System.out.println("Sum By Day = " + sumByDay);

        Map<String, Double> avgByDay = transactions
                .stream()
                .collect(Collectors.groupingBy(Transaction::getDate,
                        Collectors.averagingInt(Transaction::getAmount)));
        System.out.println("Average By Day = " + avgByDay);

        Map<String, List<Transaction>> strToList = transactions.stream()
                .collect(Collectors.groupingBy(Transaction::getDate));
        System.out.println("strToList = " + strToList);

        try {
            Map<String, Integer> strToInteger = transactions.stream()
                    .collect(Collectors.toMap(Transaction::getDate, Transaction::getAmount));
            System.out.println("strToInteger = " + strToInteger);
        }
        catch(Exception e) {
            e.printStackTrace();
        }

        // No duplicates present.
        Map<Integer, String> intToStr = transactions.stream()
                .collect(Collectors.toMap(Transaction::getAmount, Transaction::getDate));
        System.out.println("intToStr = " + intToStr);


        List<String> names = Arrays.asList("John", "Alice", "Bob", "Jane");
        Map<Integer, Long> countByNameLength = names
                .stream()
                .collect(Collectors.groupingBy(String::length, Collectors.counting()));
        System.out.println("countByNameLength = " + countByNameLength);
    }

    static class Transaction {
        String date;
        int amount;

        public Transaction(String date, int amount) {
            this.date = date;
            this.amount = amount;
        }

        public String getDate() {
            return date;
        }

        public int getAmount() {
            return amount;
        }
    }

    private static void distinctelements() {
        List<Integer> numbersWithDuplicates = Arrays.asList(1, 2, 3, 2, 4, 1, 5, 6, 5);
        List<Integer> uniqueNumbers = numbersWithDuplicates
                .stream()
                .distinct()
                .collect(Collectors.toList());

        System.out.println("Unique Numbers = " + uniqueNumbers);
    }


    private static void longestStringUsingStreams() {
        List<String> strings = Arrays
                .asList("apple", "banana", "cherry", "date", "grapefruit");
        Optional<String> longestString = strings
                .stream()
                .max(Comparator.comparingInt(String::length));

        longestString.ifPresent(System.out::println);
    }

    private static void averageAge() {
        List<Person> persons = Arrays.asList(
                new Person("Alice", 25),
                new Person("Bob", 30),
                new Person("Charlie", 35)
        );
        double averageAge = persons.stream()
                .mapToInt(Person::getAge)
                .average()
                .orElse(0);

        System.out.println("Averaqe age: " + averageAge);
    }

    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static void printPrime() {
        List<Integer> numbers = Arrays.asList(2, 4, 6, 8, 10, 11, 12, 13, 14, 15);
        boolean containsPrime = numbers.stream()
                .anyMatch(StreamsExample::isPrime);
        System.out.println("List contains a prime number: " + containsPrime);

    }

    private static void mergeTwoSorted() {
        List<Integer> list1 = Arrays.asList(1, 3, 5, 7, 9);
        List<Integer> list2 = Arrays.asList(2, 4, 6, 8, 10);
        List<Integer> mergedList = Stream.concat(list1.stream(), list2.stream())
                .sorted()
                .collect(Collectors.toList());

        System.out.println("Merged List = " + mergedList);
    }

    private static void intersection() {
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list2 = Arrays.asList(3, 4, 5, 6, 7);
        List<Integer> intersection = list1.stream()
                .filter(list2::contains)
                .collect(Collectors.toList());

        System.out.println("Intersection = " + intersection);
    }


    static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }
}
