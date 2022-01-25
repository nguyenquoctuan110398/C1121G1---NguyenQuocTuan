package ss17_binary_file_serialization.thuc_hanh.ReadAndWriteListStudent;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        ReadAndWriteFile readAndWriteFile=new ReadAndWriteFile();

        students.add(new Student(1, "Vũ Kiều Anh", "Hà Nội"));
        students.add(new Student(2, "Nguyễn Minh Quân", "Hà Nội"));
        students.add(new Student(3, "Đặng Huy Hoà", "Đà Nẵng"));
        students.add(new Student(4, "Nguyễn Khánh Tùng", "Hà Nội"));
        students.add(new Student(5, "Nguyễn Khắc Nhật", "Hà Nội"));
        readAndWriteFile.writeToFile("student.txt", students);
        List<Student> studentDataFromFile = readAndWriteFile.readDataFromFile("student.txt");
        for (Student student : studentDataFromFile){
            System.out.println(student);
        }
    }
}
