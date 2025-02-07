package designpatterns.structural.bridge;

// Step 4: Concrete class for Circle that extends Shape
public class Circle extends Shape {
    private double x, y, radius;

    public Circle(double x, double y, double radius, DrawingAPI drawingAPI) {
        super(drawingAPI);  // Pass the drawing implementation to the Shape constructor
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    public void draw() {
        drawingAPI.drawCircle(x, y, radius);  // Delegate the drawing task to the DrawingAPI
    }
}


