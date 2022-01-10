package ss6_ke_thua.thuc_hanh.SystemOfGeometricObjects;

import ss7_abstract_class_and_interface.bai_tap.InterfaceResizeableForGeometry.Resizeable;

public class Rectangle extends Shape implements Resizeable {
    private double width = 1.0;
    private double length = 1.0;

    public Rectangle() {

    }

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public Rectangle(double width, double length, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getArea() {
        return Math.round((this.width * this.length)*100)/100;
    }

    public double getPerimeter() {
        return 2 * (this.width + this.length);
    }

    public String toString() {
        return "A Rectangle with width="
                + getWidth()
                + " and length="
                + getLength()
                + ", area=" + getArea()
                + ", perimeter=" + getPerimeter()
                + ", which is a subclass of "
                + super.toString();
    }

    @Override
    public void resize(double percent) {
        setWidth(getWidth() * percent);
        setLength(getLength() * percent);
    }
}
