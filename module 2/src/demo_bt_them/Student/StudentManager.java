package demo_bt_them.Student;

import java.util.Scanner;

public class StudentManager {
    Student[] studentList = new Student[100];
    Scanner scanner = new Scanner(System.in);

    public void add() {

        System.out.println("Enter id: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter name: ");
        String name = scanner.nextLine();
        System.out.println("Enter address: ");
        String address = scanner.nextLine();
        System.out.println("Enter birthday: ");
        String birthday = scanner.nextLine();
        System.out.println("Enter class name: ");
        String className = scanner.nextLine();
        System.out.println("Enter school: ");
        String school = scanner.nextLine();

        Student student = new Student(id, name, address, birthday, className, school);
        for (int i = 0; i < studentList.length; i++) {
            if (studentList[i] == null) {
                studentList[i] = student;
                break;
            }
        }
    }

    public void display() {
        for (int i = 0; i < studentList.length; i++) {
            if (studentList[i] != null) {
                System.out.println(studentList[i].toString());
            } else {
                break;
            }
        }
    }

    public void delete() {
        boolean check = false;
        System.out.println("Enter id to delete: ");
        int idDelete = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < studentList.length; i++) {
            if (studentList[i] == null) {
                break;
            }
            if (studentList[i].getId() == idDelete) {
                check = true;
            }
            if (check) {
                for (int j = i; j < studentList.length - 1; j++) {
                    studentList[j] = studentList[j + 1];
                    studentList[studentList.length - 1] = null;
                }
                i--;
            } else {
                break;
            }
        }

    }
}
