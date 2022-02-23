package demo_bt_them.demo;

import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        TreeSet<Student> studentTreeSet = new TreeSet<>();

        Student student1 = new Student("Tuấn","C1121G1");
        studentTreeSet.add(student1);
        Student student2 = new Student("Tâm","C1121G1");
        studentTreeSet.add(student2);
        Student student3 = new Student("Khoa","C1121G1");
        studentTreeSet.add(student3);

        System.out.println(studentTreeSet);

        System.out.println(studentTreeSet.size());
    }
}
