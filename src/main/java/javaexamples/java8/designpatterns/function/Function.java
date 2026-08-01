package javaexamples.java8.designpatterns.function;

import java.util.Objects;

@FunctionalInterface
public interface Function<T, R> {

    R apply(T t);


    /**
     *         Function<Meteo, Integer> readCelcius = m -> m.getTemoerature();
     *         // T,R
     *
     *         Function<Integer, Double> celciusToFahrenheit = t -> t * 9d/5d + 32d;
     *         // R,V
     *
     *         Function<Meteo, Double> readFahrenheit = readCelcius.andThen(celciusToFahrenheit);
     *         // T,V                                     T,R                 R,V
     *
     * @param other
     * @param <V>
     * @return
     */
    default <V> Function<T, V> andThen(Function<R, V> other) {
        Objects.requireNonNull(other);
        return (T t) -> {
            R r = this.apply(t);
            return other.apply(r);
        };
    }


    /**
     *  Function<Meteo, Integer> readCelcius = m -> m.getTemoerature();
     *  // V,T
     *
     *  Function<Integer, Double> celciusToFahrenheit = t -> t * 9d/5d + 32d;
     *  // T,R
     *
     *  // T -> Integer, R -> Double, V -> Meteo
     *  Function<Meteo, Double> readFahrenheit1 = celciusToFahrenheit.compose(readCelcius);
     *  // V,R                                        T,R                     V,T
     *
     * @param other
     * @param <V>
     * @return
     */
    default <V> Function<V, R> compose(Function<V, T> other) {
        Objects.requireNonNull(other);
        return (V v) -> {
           T t = other.apply(v);
           return this.apply(t);
        };
    }

    static <T> Function<T, T> identity() {
        return t -> t;
    }
}
