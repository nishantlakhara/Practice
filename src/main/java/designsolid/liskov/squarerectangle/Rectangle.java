package designsolid.liskov.squarerectangle;

public class Rectangle {

    private int width;
    private int length;

    public Rectangle() {
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Long area() {
        return (long)length * (long)width;
    }
}
