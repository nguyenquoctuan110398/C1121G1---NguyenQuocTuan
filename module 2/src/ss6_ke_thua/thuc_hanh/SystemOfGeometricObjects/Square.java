package ss6_ke_thua.thuc_hanh.SystemOfGeometricObjects;

import ss7_abstract_class_and_interface.bai_tap.InterfaceColorableForGeometry.Colorable;
import ss7_abstract_class_and_interface.bai_tap.InterfaceResizeableForGeometry.Resizeable;

public class Square extends Rectangle implements Resizeable, Colorable {
    public Square() {
    }

    public Square(double side) {
        super(side, side);
    }

    public Square(double side, String color, boolean filled) {
        super(side, side, color, filled);
    }

    public double getSide() {
        return getWidth();
    }

    public void setSide(double side) {
        setWidth(side);
        setLength(side);
    }

    public double getArea(){
        return this.getSide()*this.getSide();
    }

    public double getPerimeter(){
        return this.getSide()*4;
    }
//    @Override
//    public void setWidth(double width) {
//        setSide(width);
//    }
//
//    @Override
//    public void setLength(double length) {
//        setSide(length);
//    }

    @Override
    public String toString() {
        return "A Square with side="
                + getSide()
                + ", area=" + getArea()
                + ", perimeter=" + getPerimeter()
                + ", which is a subclass of "
                + super.toString();
    }

    @Override
    public void howToColor() {
        System.out.println("Color all four sides");
    }
}
