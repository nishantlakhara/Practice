package java8.designpatterns.registry;

import java8.designpatterns.factory.Factory;

public interface Builder<T> {
    void register(String label, Factory<T> factory);
}
