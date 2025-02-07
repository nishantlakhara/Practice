package javaexamples.java8.designpatterns.visitor;

import java.util.function.Function;

@FunctionalInterface
public interface VisitorBuilder<R> {

    // Right way to define is at method level and not at class level for consumer andThen in Visitor interface.
    <T> void register(Class<T> type, Function<T, R> function);
}
