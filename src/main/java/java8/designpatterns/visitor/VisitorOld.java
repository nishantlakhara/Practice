//package java8.designpatterns.visitor;
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.function.Consumer;
//import java.util.function.Function;
//
//@FunctionalInterface
//public interface VisitorOld<R> {
//    // 1.
//    R visit(Object o);
//
//    // 4.
//    static <R> X<R> forType(Class<?> type) {
//        // 6.
//        return () -> type;
//    }
//
//    // 2.
//    static <R> VisitorOld<R> of(Consumer<VisitorBuilder<R>> consumer) {
//        Map<Class<?>, Function<Object, R>> registry = new HashMap<>();
//        consumer.accept((type, function) -> registry.put(type, function)); // OR consumer,accept(registry::put); // not so readable
//        System.out.println(registry);
//        return o -> registry.get(o.getClass()).apply(o);
//    }
//
//    // 3.
//    interface X<R> {
//
////        8. Consumer<VisitorBuilder<R>> -> Y<R>
//        default Y<R> execute(Function<Object, R> function) {
//            return visitorBuilder -> visitorBuilder.register(type(), function); // Convert type to type().
//        }
//
//        // 5.
//        Class<?> type();
//    }
//
//    // 10.
//    interface Z<R> {
//        default Y<R> execute(Function<Object, R> function) {
//            return previousConsumer()
//                    .andThen(visitorBuilder -> visitorBuilder.register(type(), function)); // Convert type to type().
//        }
//
//        // 11.
//        // 14.
//        default Class<?> type() {
//            return (Class<?>) get(1);
//        }
//
//        // 12.
//        // 15.
//        default Y<R> previousConsumer() {
//            return (Y<R>) get(0);
//        }
//
//        Object get(int index);
//    }
//
//    // 7.
//    // Cannot modify consumer class in java so we can override atleast.
//    // 13.
//    interface Y<R> extends Consumer<VisitorBuilder<R>> {
//        default Z<R> forType(Class<?> type) {
//            return (index) -> index == 0 ? this : type;
//        }
//
//        // 16.
//        default Y<R> andThen(Y<R> after) {
//            return t -> {
//                this.accept(t);
//                after.accept(t);
//            };
//        }
//    }
//}
