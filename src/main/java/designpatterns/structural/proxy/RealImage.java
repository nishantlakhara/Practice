package designpatterns.structural.proxy;

public class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
    }

    public void loadImage() {
        System.out.println("Loading image from " + filename);
    }

    @Override
    public void display() {
        System.out.println("Real Image Loaded");
    }
}
