package ss4_lop_va_doi_tuong_trong_java.bai_tap.Fan;

public class Fan {
    final int SLOW = 1;
    final int MEDIUM = 2;
    final int FAST = 3;

    private int speed = SLOW;
    private boolean on = false;
    private double radius = 5;
    private String color = "blue";

    public Fan(boolean on, int speed, double radius, String color) {
        this.on = on;
        this.speed = speed;
        this.radius = radius;
        this.color = color;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public boolean isOn() {
        return on;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

//    public String toString() {
//        if (isOn()) {
//            return this.getSpeed() + " " + this.getColor() + " " + this.getRadius() + " fan is on";
//        } else return this.getColor() + " " + this.getRadius() +" fan is off";
//    }


    @Override
    public String toString() {
        if (isOn()) {
            return "Fan{" +
                    "speed=" + speed +
                    ", radius=" + radius +
                    ", color='" + color + ", fan is on" + '\'' +
                    '}';

        } else
            return "Fan{" +
                    "radius=" + radius +
                    ", color='" + color + ", fan is off" + '\'' +
                    '}';
    }
}
