package ss6_ke_thua.thuc_hanh.SystemOfGeometricObjects;

import ss7_abstract_class_and_interface.bai_tap.InterfaceColorableForGeometry.Colorable;
import ss7_abstract_class_and_interface.bai_tap.InterfaceResizeableForGeometry.Resizeable;

public class Circle extends Shape implements Resizeable, Colorable {
    private double radius = 1.0;

    public Circle() {

    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return radius * radius * Math.PI;
    }

    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    @Override
    public String toString() {
        return "A Circle with radius="
                + getRadius()
                + ", area=" + getArea()
                + ", perimeter=" + getPerimeter()
                + ", which is a subclass of "
                + super.toString();
    }

    @Override
    public void resize(double percent) {
        setRadius(getRadius() * percent);
    }

    @Override
    public void howToColor() {
        System.out.println("Color all four sides");
    }
}
