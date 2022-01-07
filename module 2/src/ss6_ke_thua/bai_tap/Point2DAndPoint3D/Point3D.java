package ss6_ke_thua.bai_tap.Point2DAndPoint3D;

import java.util.Arrays;

public class Point3D extends Point2D {
    private float z;

    public Point3D() {

    }

    public Point3D(float z) {
        this.z = z;
    }

    public Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public void setXYZ(float x, float y, float z) {
        super.setXY();
        this.z = z;
    }

    public float[] getXYZ() {
        float[] arr = new float[]{getX(), getY(), getZ()};
        return arr;
    }

    @Override
    public String toString() {
        return "A Point3D with " + Arrays.toString(getXYZ())+ " which is subclass of " + super.toString();
    }
}
