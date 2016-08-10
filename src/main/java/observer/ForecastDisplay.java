package observer;

public class ForecastDisplay implements Observer, DisplayElement { private float temperature;
private float humidity;
private Subject weatherData;

	

	public ForecastDisplay(WeatherData weatherData) {
		this.weatherData = weatherData;
		weatherData.registerObserver(this);	
	}



	@Override
	public void display() {
		System.out.println("000000000000000000000");
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
