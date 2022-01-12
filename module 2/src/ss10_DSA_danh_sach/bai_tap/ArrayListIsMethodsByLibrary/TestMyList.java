package ss10_DSA_danh_sach.bai_tap.ArrayListIsMethodsByLibrary;

public class TestMyList {
    public static class Students {
        private int id;
        private String name;

        public Students() {

        }

        public Students(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public static void main(String[] args) {
            Students a = new Students(1, "Huy");
            Students b = new Students(1, "Huy");
            Students c = new Students(1, "Huy");
            Students d = new Students(1, "Huy");
            Students e = new Students(1, "Huy");

            MyList<Students> studentsMyList=new MyList<>();

        }
    }



}
