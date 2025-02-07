package designpatterns.structural.bridge;

// Step 3: The abstraction (Shape) that will use the DrawingAPI
public abstract class Shape {
    protected DrawingAPI drawingAPI;  // A reference to the DrawingAPI

    // Constructor that takes a DrawingAPI to bridge the abstraction
    protected Shape(DrawingAPI drawingAPI) {
        this.drawingAPI = drawingAPI;
    }

    // Abstract method that delegates the drawing task to the implementation
    public abstract void draw();
}
