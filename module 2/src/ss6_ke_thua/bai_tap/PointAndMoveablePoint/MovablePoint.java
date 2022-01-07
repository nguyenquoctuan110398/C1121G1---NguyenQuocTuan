package ss6_ke_thua.bai_tap.PointAndMoveablePoint;

import java.util.Arrays;

public class MovablePoint extends Point {
    private float xSpeed;
    private float ySpeed;

    public MovablePoint() {

    }

    public MovablePoint(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MovablePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float getXSpeed() {
        return xSpeed;
    }

    public void setXSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getYSpeed() {
        return ySpeed;
    }

    public void setYSpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public void setSpeed(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float[] getSpeed() {
        float[] arr = new float[]{getXSpeed(), getYSpeed()};
        return arr;
    }


    public MovablePoint move() {
        super.setX(getX() + xSpeed);
        super.setY(getY() + ySpeed);
        return this;
    }

    public String toString() {
        return Arrays.toString(super.getXY()) + ", speed= " + Arrays.toString(getSpeed());
    }
}
