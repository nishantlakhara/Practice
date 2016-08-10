package observer;

public class StatisticsDisplay implements Observer, DisplayElement { 
	private float temperature;
	private float humidity;
	private Subject weatherData;

	

	public StatisticsDisplay(WeatherData weatherData) {
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}



	@Override
	public void display() {
		System.out.println("1111111111111111111");
		System.out.println("Current conditions: " + temperature
				+ "F degrees and " + humidity + "% humidity"); 
		
	}



	@Override
	public void update(float temp, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		display();
		
	}

}
