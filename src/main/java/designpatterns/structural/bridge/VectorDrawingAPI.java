package designpatterns.structural.bridge;// Step 2: Concrete implementations of the DrawingAPI interface

// Concrete class for vector drawing
public class VectorDrawingAPI implements DrawingAPI {
    public void drawCircle(double x, double y, double radius) {
        System.out.println("Vector Circle: center(" + x + ", " + y + "), radius " + radius);
    }

    public void drawRectangle(double x, double y, double width, double height) {
        System.out.println("Vector Rectangle: top-left(" + x + ", " + y + "), width " + width + ", height " + height);
    }
}


