package designpatterns.structural.proxy;

public class Main {

    public static void main(String[] args) {
        Image image = new ProxyImage("ABC");

        // Load for the first time. Create the image.
        image.display();

        // Load not required. Directly display.
        image.display();
    }
}
