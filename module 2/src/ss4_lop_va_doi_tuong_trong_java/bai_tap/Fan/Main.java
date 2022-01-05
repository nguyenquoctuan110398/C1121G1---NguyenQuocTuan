package ss4_lop_va_doi_tuong_trong_java.bai_tap.Fan;

public class Main {
    public static void main(String[] args) {
        Fan fan1 = new Fan(true, 3, 10, "yellow");
        Fan fan2 = new Fan(false, 2, 5, "blue");

        System.out.println(fan1.toString());
        System.out.println(fan2.toString());
    }
}
