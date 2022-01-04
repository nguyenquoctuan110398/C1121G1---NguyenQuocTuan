package ss4_lop_va_doi_tuong_trong_java.thuc_hanh.Rectangle;

public class Rectangle {
    double height, width;

    public Rectangle() {

    }

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getArea() {
        return this.width * this.height;
    }

    public double getPerimeter() {
        return (this.width + this.height) * 2;
    }

    public String display() {
        return "Rectangle{" + "width= " + this.width + " height= " + this.height + "}";
    }
}
