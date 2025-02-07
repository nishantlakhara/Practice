package javaexamples.java8.designpatterns;

import javaexamples.java8.designpatterns.function.Comparator;
import javaexamples.java8.designpatterns.function.Function;
import javaexamples.java8.designpatterns.model.Person;

public class PlayWithComparators {



    public static void main(String[] args) {
        Person mary = new Person(28, "Mary");
        Person john = new Person(22, "John");
        Person linda = new Person(26, "Linda");
        Person james = new Person(32, "James");
        Person jamesbis = new Person(26, "James");


        Function<Person, String> getName = p -> p.getName();
        Comparator<Person> cmpName = getPersonComparator(getName);

        // static method similar to getPersonComparator with generics.
        cmpName = Comparator.comparing(Person::getName);
        Comparator compNameReversed = cmpName.reversed();

        System.out.println("Mary > John : " + (cmpName.compare(mary, john) > 0));
        System.out.println("John > James : " + (cmpName.compare(john, james) > 0));
        System.out.println("Linda > John : " + (cmpName.compare(linda, john) > 0));

        System.out.println("Mary > John : " + (compNameReversed.compare(mary, john) > 0));
        System.out.println("John > James : " + (compNameReversed.compare(john, james) > 0));
        System.out.println("Linda > John : " + (compNameReversed.compare(linda, john) > 0));


        Function<Person, Integer> getAge = p -> p.getAge();
        Comparator cmpAge = Comparator.comparing(getAge);
        System.out.println("AGE WISE");
        System.out.println("Mary > John : " + (cmpAge.compare(mary, john) > 0));
        System.out.println("John > James : " + (cmpAge.compare(john, james) > 0));
        System.out.println("Linda > John : " + (cmpAge.compare(linda, john) > 0));


        // Chaining
        Comparator<Person> cmp = cmpName.thenComparing(cmpAge);
        cmp = Comparator.comparing(Person::getName)
                        .thenComparing(Person::getAge);

        System.out.println("Mary > John : " + (cmp.compare(mary, john) > 0));
        System.out.println("John > James : " + (cmp.compare(john, james) > 0));
        System.out.println("Linda > John : " + (cmp.compare(linda, john) > 0));
        System.out.println("James > James Bis : " + (cmp.compare(james, jamesbis) > 0));
    }

    // Use this method as a base method and move it to comaprator interface and make it generic.
    private static Comparator<Person> getPersonComparator(Function<Person, String> keyExtractor) {
        return (p1, p2) -> {
            String s1 = keyExtractor.apply(p1);
            String s2 = keyExtractor.apply(p2);

            return s1.compareTo(s2);
        };
    }
}
