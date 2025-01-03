package designsolid.liskov.squarerectangle;

public class Main {

    /*
    An objet can be replaced by a sub-object without breaking the program,
    as what holds for T-objects holds for S-objects is what must be understood.



    A square breaks that principle since it doesn’t have a different height and width.
    So not everything true for Rectangle is true for Square.
    Let’s see it using code and the Shape, Rectangle and Square classes.
     */
    public static void main(String[] args) {
        Rectangle square = new Square();
        square.setLength(10);
        square.setWidth(11);  // Length and width should be same. Parent class is not substitutable.

        System.out.println(square.area());

        // Solution : Create a Shape class abstract and Rectangle and Square are separate classes implementing the same.
    }
}
