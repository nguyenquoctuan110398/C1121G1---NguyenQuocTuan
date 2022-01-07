package ss6_ke_thua.bai_tap.CircleAndCylinder;

public class Cylinder extends Circle {
    private double height;

    public Cylinder() {

    }

    public Cylinder(double height) {
        this.height = height;
    }

    public Cylinder(double height, double radius, String color) {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getArea() {
        return this.getRadius() * this.getRadius() * Math.PI * height;
    }

    @Override
    public String toString() {
        return "A Cylinder with height=" + height +
                ", which is subclass of " + super.toString();
    }
}
