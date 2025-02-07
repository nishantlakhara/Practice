package javaexamples.java8.designpatterns.visitor;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

@FunctionalInterface
public interface Visitor<R> {
    // 1.
    R visit(Object o);

    // 4.
    static <T, R> X<T, R> forType(Class<T> type) {
        // 6.
        return () -> type;
    }

    // 2.
    static <R> Visitor<R> of(Consumer<VisitorBuilder<R>> consumer) {
        Map<Class<?>, Function<Object, R>> registry = new HashMap<>();
        VisitorBuilder<R> visitorBuilder = new VisitorBuilder<R>() {
            @Override
            public <T> void register(Class<T> type, Function<T, R> function) {
                registry.put(type, function.compose(type::cast));
            }
        };
        consumer.accept(visitorBuilder); // OR consumer,accept(registry::put); // not so readable
        System.out.println(registry);
        return o -> registry.get(o.getClass()).apply(o);
    }

    // 3.
    // 16. Add T
    interface X<T, R> {

//        8. Consumer<VisitorBuilder<R>> -> Y<R>
        default Y<R> execute(Function<T, R> function) {
            return visitorBuilder -> visitorBuilder.register(type(), function); // Convert type to type().
        }

        // 5.
        Class<T> type();
    }

    // 10.
    interface Z<T, R> {
        default Y<R> execute(Function<T, R> function) {
            return previousConsumer()
                    .andThen(visitorBuilder -> visitorBuilder.register(type(), function)); // Convert type to type().
        }

        // 11.
        // 14.
        default Class<T> type() {
            return (Class<T>) get(1);
        }

        // 12.
        // 15.
        default Y<R> previousConsumer() {
            return (Y<R>) get(0);
        }

        Object get(int index);
    }

    // 7.
    // Cannot modify consumer class in java so we can override atleast.
    // 13.
    interface Y<R> extends Consumer<VisitorBuilder<R>> {
        default <T> Z<T, R> forType(Class<T> type) {
            return (index) -> index == 0 ? this : type;
        }

        // 16.
        default Y<R> andThen(Y<R> after) {
            return t -> {
                this.accept(t);
                after.accept(t);
            };
        }
    }
}
