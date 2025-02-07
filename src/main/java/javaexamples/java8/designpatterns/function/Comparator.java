package javaexamples.java8.designpatterns.function;


import java.util.Objects;

@FunctionalInterface
public interface Comparator<T> {
    int compare(T t1, T t2);

    // 3.
    // IDEAL static <T, U extends Comparable<? super U>> Comparator<T>
    static <T, U extends Comparable<U>> Comparator<T> comparing(Function<T, U> keyExtractor) {
        Objects.requireNonNull(keyExtractor);
        return (p1, p2) -> {
            U s1 = keyExtractor.apply(p1);
            U s2 = keyExtractor.apply(p2);
            return s1.compareTo(s2);
        };
    }

    // 2.
    default Comparator<T> reversed() {
        return (t1, t2) -> this.compare(t2, t1);
    }

    // 1.
    default Comparator<T> thenComparing(Comparator other) {
        Objects.requireNonNull(other);
        return (t1, t2) -> {
              int compare = this.compare(t1, t2);
              if(compare == 0) {
                  return other.compare(t1, t2);
              } else {
                  return compare;
              }
        };
    }

    // 4.
    default <U extends Comparable<U>> Comparator<T> thenComparing(Function<T, U> keyExtractor) {
        Objects.requireNonNull(keyExtractor);
        Comparator<T> other = comparing(keyExtractor);
        return this.thenComparing(other);
    }
}
