package designpatterns.structural.bridge;

// Concrete class for raster drawing
public class RasterDrawingAPI implements DrawingAPI {
    public void drawCircle(double x, double y, double radius) {
        System.out.println("Raster Circle: center(" + x + ", " + y + "), radius " + radius);
    }

    public void drawRectangle(double x, double y, double width, double height) {
        System.out.println("Raster Rectangle: top-left(" + x + ", " + y + "), width " + width + ", height " + height);
    }
}