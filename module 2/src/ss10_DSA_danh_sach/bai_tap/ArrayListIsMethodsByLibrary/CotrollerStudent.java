package ss10_DSA_danh_sach.bai_tap.ArrayListIsMethodsByLibrary;

public class CotrollerStudent {
    public static void main(String[] args) {
        MyList<Students> studentMyArrayList = new MyList<>();

        Students student1 = new Students(1, "Tuấn");
        Students student2 = new Students(2, "Huy");
        Students student3 = new Students(3, "Khoa");
        Students student4 = new Students(4, "Khải");
        Students student5 = new Students(5, "Tâm");

        studentMyArrayList.add(student1);
        studentMyArrayList.add(student2);
        studentMyArrayList.add(student3);
        studentMyArrayList.add(student4);
        
        studentMyArrayList.add(student5, 4);
        System.out.println(studentMyArrayList.size());
        studentMyArrayList.clean();
        System.out.println(studentMyArrayList.size());

        for (int i = 0; i < studentMyArrayList.size(); i++) {
            Students students = (Students) studentMyArrayList.element[i];
            System.out.println(students.getId());
            System.out.println(students.getName());

        }

    }
}
