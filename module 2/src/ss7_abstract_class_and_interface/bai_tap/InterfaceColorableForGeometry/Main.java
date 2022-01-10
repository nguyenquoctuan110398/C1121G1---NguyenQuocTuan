package ss7_abstract_class_and_interface.bai_tap.InterfaceColorableForGeometry;

import ss6_ke_thua.thuc_hanh.SystemOfGeometricObjects.Circle;
import ss6_ke_thua.thuc_hanh.SystemOfGeometricObjects.Rectangle;
import ss6_ke_thua.thuc_hanh.SystemOfGeometricObjects.Shape;
import ss6_ke_thua.thuc_hanh.SystemOfGeometricObjects.Square;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[7];


        shapes[0] = new Circle();
        ((Circle) shapes[0]).howToColor();
        System.out.println(shapes[0]);
        System.out.println();

        shapes[1] = new Circle(3.6);
        ((Circle) shapes[1]).howToColor();
        System.out.println(shapes[1]);
        System.out.println();

        shapes[2] = new Circle(3.1, "Blue", true);
        ((Circle) shapes[2]).howToColor();
        System.out.println(shapes[2]);
        System.out.println();

        shapes[3] = new Square();
        ((Square) shapes[3]).howToColor();
        System.out.println(shapes[3]);
        System.out.println();

        shapes[4] = new Square(5.0);
        ((Square) shapes[4]).howToColor();
        System.out.println(shapes[4]);
        System.out.println();

        shapes[5] = new Square(1.1, "White", true);
        ((Square) shapes[5]).howToColor();
        System.out.println(shapes[5]);
        System.out.println();
    }
}
