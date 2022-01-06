package demo_bt_them.Student;

import java.util.Scanner;

public class StudentManager {
    Student[] studentList = new Student[100];
//


    Scanner scanner = new Scanner(System.in);

    public void create() {
        Student student1 = new Student(1, "Tam",
                "DN", "12/12/1998", "C1121G1", "BK");
        Student student2 = new Student(2, "Tuan",
                "QN", "12/4/1994", "C1121G1", "KT");
        Student student3 = new Student(1, "Chien",
                "HA", "1/4/1995", "C1121G1", "NN");
        studentList[0] = student1;
        studentList[1] = student2;
        studentList[2] = student3;
    }

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

    public void edit() {
        boolean check = false;
        System.out.println("Enter id edit: ");

        int idEdit = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < studentList.length; i++) {
            System.out.println("Vòng lặp " + (i + 1));
            System.out.println("Id: " + i);
            if (studentList[i] == null) {
                break;
            }
            if (studentList[i].getId() == idEdit) {
                check = true;
            }
            if (check) {
                System.out.println("1. Edit name\n" +
                        "2. Edit address\n" +
                        "3. Edit birthday\n" +
                        "4. Edit class name\n" +
                        "5. Edit school\n" +
                        "6. Exit\n");
                int chooseEdit = Integer.parseInt(scanner.nextLine());
                switch (chooseEdit) {
                    case 1:
                        String newName = scanner.nextLine();
                        studentList[i].setName(newName);
                        break;
                    case 2:
                        String newAddress = scanner.nextLine();
                        studentList[i].setAddress(newAddress);
                        break;
                    case 3:
                        String newBirthday = scanner.nextLine();
                        studentList[i].setBirthday(newBirthday);
                        break;
                    case 4:
                        String newClassName = scanner.nextLine();
                        studentList[i].setClassName(newClassName);
                        break;
                    case 5:
                        String newSchool = scanner.nextLine();
                        studentList[i].setSchool(newSchool);
                        break;
                    case 6:
                        break;
                }
            } else {
                break;
            }
        }
    }

//    public void search() {
//
//    }
}
