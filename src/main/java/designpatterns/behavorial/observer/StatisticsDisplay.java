package designpatterns.behavorial.observer;

public class StatisticsDisplay implements Observer, DisplayElement {
    private float temperature;
    private float humidity;
    private WeatherData weatherData;

    public StatisticsDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
            this.temperature = temperature;
            this.humidity = humidity;

            display();
    }

    @Override
    public void display() {
        System.out.println("Statistics Display : Temperature = " + temperature + " F degrees and" +
                " humidity = " + humidity);
    }
}
