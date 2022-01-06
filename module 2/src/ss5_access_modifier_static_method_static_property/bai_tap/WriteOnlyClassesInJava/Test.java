package ss5_access_modifier_static_method_static_property.bai_tap.WriteOnlyClassesInJava;

public class Test {
    public static void main(String[] args) {
        Student student1=new Student();
        student1.setName("Tuấn");
        student1.setClasses("C1121G1");
        System.out.println(student1.toString());
    }
}
