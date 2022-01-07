package ss6_ke_thua.bai_tap.Point2DAndPoint3D;

import java.util.Arrays;

public class Point2D {
    private float x;
    private float y;

    public Point2D() {

    }

    public Point2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setXY() {
        this.x = x;
        this.y = y;
    }

    public float[] getXY() {
        float[] arr = new float[]{getX(), getY()};
        return arr;
    }

    @Override
    public String toString() {
        return "A Point2D with " + Arrays.toString(getXY());
    }
}
