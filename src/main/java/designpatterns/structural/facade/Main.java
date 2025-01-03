package designpatterns.structural.facade;

public class Main {
    public static void main(String[] args) {
        HomeTheaterFacade homeTheaterFacade = new HomeTheaterFacade(
                new Amplifier(),
                new Tuner(),
                new StreamingPlayer(),
                new Projector(),
                new TheaterLights(),
                new Screen(),
                new PopcornPopper()
        );

        homeTheaterFacade.watchMovie("Tirangaa");

        homeTheaterFacade.endMovie();
    }
}
