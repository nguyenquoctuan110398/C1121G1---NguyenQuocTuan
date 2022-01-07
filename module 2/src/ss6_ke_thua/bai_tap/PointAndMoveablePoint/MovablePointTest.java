package ss6_ke_thua.bai_tap.PointAndMoveablePoint;

public class MovablePointTest {
    public static void main(String[] args) {
        MovablePoint movablePoint=new MovablePoint();
        System.out.println(movablePoint);

        movablePoint =new MovablePoint(2.4f,2.1f);
        System.out.println(movablePoint);

        movablePoint.move();
        System.out.println(movablePoint);

        movablePoint = new MovablePoint(3,2,1.1f,3);
        System.out.println(movablePoint);
    }
}
