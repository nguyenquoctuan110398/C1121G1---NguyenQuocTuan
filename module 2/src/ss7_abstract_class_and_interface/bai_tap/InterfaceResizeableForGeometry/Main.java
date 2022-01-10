package ss7_abstract_class_and_interface.bai_tap.InterfaceResizeableForGeometry;


import ss6_ke_thua.thuc_hanh.SystemOfGeometricObjects.Circle;
import ss6_ke_thua.thuc_hanh.SystemOfGeometricObjects.Rectangle;
import ss6_ke_thua.thuc_hanh.SystemOfGeometricObjects.Shape;
import ss6_ke_thua.thuc_hanh.SystemOfGeometricObjects.Square;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes=new Shape[9];


        shapes[0]=new Circle();
        System.out.println("Pre-resize");
        System.out.println(shapes[0]);
        ((Circle) shapes[0]).resize(0.5);
        System.out.println("After-resize");
        System.out.println(shapes[0]);
        System.out.println();

        shapes[1]=new Circle(3.6);
        System.out.println("Pre-resize");
        System.out.println(shapes[1]);
        ((Circle) shapes[1]).resize(0.3);
        System.out.println("After-resize");
        System.out.println(shapes[1]);
        System.out.println();

        shapes[2]=new Circle(3.1,"Blue",true);
        System.out.println("Pre-resize");
        System.out.println(shapes[2]);
        ((Circle) shapes[2]).resize(1.5);
        System.out.println("After-resize");
        System.out.println(shapes[2]);
        System.out.println();

        shapes[3]=new Rectangle();
        System.out.println("Pre-resize");
        System.out.println(shapes[3]);
        ((Rectangle) shapes[3]).resize(1.2);
        System.out.println("After-resize");
        System.out.println(shapes[3]);
        System.out.println();

        shapes[4]=new Rectangle(3.1,1.0);
        System.out.println("Pre-resize");
        System.out.println(shapes[4]);
        ((Rectangle) shapes[4]).resize(3.12);
        System.out.println("After-resize");
        System.out.println(shapes[4]);
        System.out.println();

        shapes[5]=new Rectangle(3.0,2.0,"Black",false);
        System.out.println("Pre-resize");
        System.out.println(shapes[5]);
        ((Rectangle) shapes[5]).resize(2.1);
        System.out.println("After-resize");
        System.out.println(shapes[5]);
        System.out.println();

        shapes[6]=new Square();
        System.out.println("Pre-resize");
        System.out.println(shapes[6]);
        ((Square) shapes[6]).resize(0.2);
        System.out.println("After-resize");
        System.out.println(shapes[6]);
        System.out.println();

        shapes[7]=new Square(5.0);
        System.out.println("Pre-resize");
        System.out.println(shapes[7]);
        ((Square) shapes[7]).resize(1.5);
        System.out.println("After-resize");
        System.out.println(shapes[7]);
        System.out.println();

        shapes[8]=new Square(1.1,"White",true);
        System.out.println("Pre-resize");
        System.out.println(shapes[8]);
        ((Square) shapes[8]).resize(1.7);
        System.out.println("After-resize");
        System.out.println(shapes[8]);
        System.out.println();
    }
}
