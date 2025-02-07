package designpatterns.structural.bridge;

// Step 1: The bridge interface
public interface DrawingAPI {
    void drawCircle(double x, double y, double radius);
    void drawRectangle(double x, double y, double width, double height);
}
