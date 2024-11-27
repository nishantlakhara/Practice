package java8.designpatterns.model;

import java.awt.*;

public class Circle {

    private Color color;

    public Circle(Color color) {
        this.color = color;
    }

    public Circle() {
        this.color = Color.WHITE;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "color=" + color +
                '}';
    }
}
