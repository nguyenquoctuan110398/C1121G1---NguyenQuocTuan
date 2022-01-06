package demo_bt_them.Student;

import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) {
        StudentManager studentManager = new StudentManager();
        Scanner scanner = new Scanner(System.in);

        studentManager.create();

        int chooseMenu;
        boolean flag = true;

        do {
            System.out.println("1. Add\n" +
                    "2. Display\n" +
                    "3. Edit\n" +
                    "4. Delete\n" +
                    "5. Search\n" +
                    "6. Exit\n");
            chooseMenu = scanner.nextInt();
            switch (chooseMenu) {
                case 1:
                    studentManager.add();
                    break;
                case 2:
                    studentManager.display();
                    break;
                case 3:
                    System.out.println("Edit");
                    studentManager.edit();
                    break;
                case 4:
                    studentManager.delete();
                    studentManager.display();
                    break;
                case 5:
                    System.out.println("Search");
                    break;
                case 6:
                    flag = false;
            }
        } while (flag);
    }
}
