package javaexamples.java8.designpatterns;

import javaexamples.java8.designpatterns.function.Function;
import javaexamples.java8.designpatterns.model.Meteo;

public class PlayWithFunctions {
    public static void main(String[] args) {
        Meteo meteo = new Meteo(20);

        Function<Meteo, Integer> readCelcius = m -> m.getTemoerature();
        // T,R
        Function<Integer, Double> celciusToFahrenheit = t -> t * 9d/5d + 32d;
        // R,V
        Function<Meteo, Double> readFahrenheit = readCelcius.andThen(celciusToFahrenheit);
        // T,V                                     T,R                 R,V
        System.out.println(readFahrenheit.apply(meteo));

        Function<Meteo, Double> readFahrenheit1 = celciusToFahrenheit.compose(readCelcius);
        // T -> Integer, R -> Double, V -> Meteo
        //         V,R                                 T,R                     V,T

    }
}
