package demo_bt_them.mo_hinh_mvc.model.model;

public class Student extends Person{
    private int point;
    private String className;
    public Student(int point, String className){
        this.point=point;
        this.className=className;
    }
}
