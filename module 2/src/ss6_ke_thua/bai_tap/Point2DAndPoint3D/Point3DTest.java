package ss6_ke_thua.bai_tap.Point2DAndPoint3D;

public class Point3DTest {
    public static void main(String[] args) {
        Point3D point3D=new Point3D();
        System.out.println(point3D);

        point3D = new Point3D(2.3f);
        System.out.println(point3D);

        point3D=new Point3D(2.1f,2.5f,4);
        System.out.println(point3D);
    }
}
