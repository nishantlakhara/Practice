package javaexamples.java8.designpatterns;

import javaexamples.java8.designpatterns.function.Function;
import javaexamples.java8.designpatterns.model.Meteo;

public class PlayWithFunctions {
    public static void main(String[] args) {
        Meteo meteo = new Meteo(20);

        Function<Meteo, Integer> readCelcius = m -> m.getTemoerature();
        Function<Integer, Double> celciusToFahrenheit = t -> t * 9d/5d + 32d;

        Function<Meteo, Double> readFahrenheit = readCelcius.andThen(celciusToFahrenheit);
        System.out.println(readFahrenheit.apply(meteo));

        Function<Meteo, Double> readFahrenheit1 = celciusToFahrenheit.compose(readCelcius);
//                  V, R                          Integer=T, Double=R              V, T


    }
}
