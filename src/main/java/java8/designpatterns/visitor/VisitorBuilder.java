package java8.designpatterns.visitor;

import java.util.function.Function;

@FunctionalInterface
public interface VisitorBuilder<R> {
    void register(Class<?> type, Function<Object, R> function);
}
