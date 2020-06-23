package design_patterns.observer;

public interface Subject {
public void registerObserver(Observer o); public void removeObserver(Observer o); public void notifyObservers();
}

