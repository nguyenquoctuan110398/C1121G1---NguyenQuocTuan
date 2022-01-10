package demo_bt_them.demo_abstract;

public class Main {
    public static void main(String[] args) {
        //đi diệt rồng cứu nước
//        dietRong();

        ChienBinhDepTrai chienBinhDepTrai1 = new ChienBinhDepTrai("Khải", 20, 1.65f,
                60, "Cung tên", 9);
        ChienBinhDepTrai chienBinhDepTrai2 = new ChienBinhDepTrai("Tuấn", 20, 1.65f,
                60, "Cung tên", 6);
        ChienBinhDepTrai chienBinhDepTrai3 = new ChienBinhDepTrai("Hiếu", 20, 1.65f,
                60, "Cung tên", 7);
        ChienBinhDepTrai chienBinhDepTrai4 = new ChienBinhDepTrai("Kha", 20, 1.65f,
                60, "Cung tên", 3);
        ChienBinhDepTrai chienBinhDepTrai5 = new ChienBinhDepTrai("Hậu", 20, 1.65f,
                60, "Cung tên", 8);
        // mở cuộc thi chiến binh đẹp trai
        ChienBinhDepTrai[] list = new ChienBinhDepTrai[5];
        list[0] = chienBinhDepTrai1;
        list[1] = chienBinhDepTrai2;
        list[2] = chienBinhDepTrai3;
        list[3] = chienBinhDepTrai4;
        list[4] = chienBinhDepTrai5;
        System.out.println("Danh sách chiến binh đẹp trai");
        for(ChienBinhDepTrai cb:list){
            System.out.println(cb);
        }
    }

    public static void dietRong() {
        Vua vua = new Vua("Tuan", 30, 1.75f, 65, true);
        vua.raLenh("Họp triều đình");

        ChienBinhDepTrai chienBinhDepTrai = new ChienBinhDepTrai("Khải", 20, 1.65f,
                60, "Cung tên", 9);
        ChienBinhThongThai chienBinhThongThai = new ChienBinhThongThai("Khoa", 28, 1.7f,
                70, "Quạt", 9);
        ChienBinhAnhDung chienBinhAnhDung = new ChienBinhAnhDung("Chiến", 25, 1.65f,
                60, "Kiếm", 10);

        vua.raLenh("Chiến binh đẹp trai đi diệt rồng");
        chienBinhDepTrai.cachChienDau();
        //thất bại và trở về

        vua.raLenh("Chiến binh đẹp trai đi chơi với công chúa");
        vua.raLenh("Chiến binh thông thái đi diệt rồng");
        chienBinhThongThai.lamNhiemVu("Diệt rồng");
//        chienBinhThongThai.lamNhiemVu();
        chienBinhThongThai.cachChienDau();
        chienBinhThongThai.hoMuaGoiGio();
        // muốn diệt rồng thì phải hô mưa và gọi gió + sức mạnh
        // rồng ko diệt được
        vua.raLenh("Chiến binh anh dũng đi diệt rồng");
        chienBinhAnhDung.lamNhiemVu("đi diệt rồng");
        chienBinhAnhDung.diLuyenCong();
        chienBinhAnhDung.cachChienDau();
        chienBinhAnhDung.hoMuaGoiGio();

        ChienBinh chienBinh1 = new ChienBinhThongThai();
        System.out.println(chienBinh1 instanceof ChienBinh);
        System.out.println(chienBinh1 instanceof ChienBinhThongThai);
        System.out.println(chienBinh1 instanceof PhepThuat);
        ((PhepThuat) chienBinh1).hoMuaGoiGio();
        ((ChienBinhThongThai) chienBinh1).hoMuaGoiGio();
    }
}