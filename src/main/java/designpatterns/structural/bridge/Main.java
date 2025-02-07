package designpatterns.structural.bridge;

public class Main {

    /**
     *
     * +---------------------+       +------------------------+         +---------------------------+
     * |   <<interface>>     |       |  <<abstract>>          |         |  <<interface>>            |
     * |   DrawingAPI        |       |  Shape                 |         |  DrawingAPI               |
     * |---------------------|       |------------------------|         |---------------------------|
     * | + drawCircle(x, y,  |<>---->| - drawingAPI: DrawingAPI|  +----->| + drawCircle(x, y, radius)|
     * |   radius)           |       |------------------------|         | + drawRectangle(x, y,     |
     * | + drawRectangle(x,  |       | + draw()               |         |   width, height)          |
     * |   y, width, height) |       |------------------------|         +---------------------------+
     * +---------------------+       | + Shape(drawingAPI: DrawingAPI)|
     *                                +------------------------+
     *                                            ^
     *                                            |
     *                    +-----------------------+-----------------------+
     *                    |                       |                       |
     *            +-------------------+     +-------------------+     +-------------------+
     *            | VectorDrawingAPI   |     | RasterDrawingAPI   |     | 3DDrawingAPI      |
     *            |-------------------|     |-------------------|     |-------------------|
     *            | + drawCircle(x, y, |     | + drawCircle(x, y, |     | + drawCircle(x, y, |
     *            |   radius)          |     |   radius)          |     |   radius)          |
     *            | + drawRectangle(x,  |     | + drawRectangle(x, |     | + drawRectangle(x, |
     *            |   y, width, height)|     |   y, width, height)|     |   y, width, height)|
     *            +-------------------+     +-------------------+     +-------------------+
     */

    public static void main(String[] args) {
        // Create drawing implementations
        DrawingAPI vectorAPI = new VectorDrawingAPI();
        DrawingAPI rasterAPI = new RasterDrawingAPI();

        // Create shapes with different drawing implementations
        Shape circle = new Circle(10, 20, 5, vectorAPI);  // Circle with Vector Drawing
        Shape rectangle = new Rectangle(30, 40, 50, 60, rasterAPI);  // Rectangle with Raster Drawing

        // Draw shapes using the different drawing implementations
        circle.draw();   // Output: Vector Circle: center(10.0, 20.0), radius 5.0
        rectangle.draw();  // Output: Raster Rectangle: top-left(30.0, 40.0), width 50.0, height 60.0
    }


}
