package designpatterns.structural.bridge;

// Step 5: Concrete class for Rectangle that extends Shape
public class Rectangle extends Shape {
    private double x, y, width, height;

    public Rectangle(double x, double y, double width, double height, DrawingAPI drawingAPI) {
        super(drawingAPI);  // Pass the drawing implementation to the Shape constructor
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw() {
        drawingAPI.drawRectangle(x, y, width, height);  // Delegate the drawing task to the DrawingAPI
    }
}