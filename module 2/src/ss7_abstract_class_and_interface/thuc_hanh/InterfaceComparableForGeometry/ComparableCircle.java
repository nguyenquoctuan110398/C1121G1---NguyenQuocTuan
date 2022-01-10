package ss7_abstract_class_and_interface.thuc_hanh.InterfaceComparableForGeometry;

import ss6_ke_thua.thuc_hanh.SystemOfGeometricObjects.Circle;

import javax.crypto.Cipher;

public class ComparableCircle extends Circle implements Comparable<ComparableCircle> {
    public ComparableCircle(){

    }

    public ComparableCircle(double radius) {
        super(radius);
    }

    public ComparableCircle(double radius, String color, boolean filled) {
        super(radius, color, filled);
    }

    @Override
    public int compareTo(ComparableCircle o) {
        if (getRadius() > o.getRadius()) return 1;
        else if (getRadius() < o.getRadius()) return -1;
        else return 1;
    }
}

