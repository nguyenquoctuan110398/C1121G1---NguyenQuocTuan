package demo_bt_them.demo_abstract;

//public class ChienBinhAnhDung extends ChienBinh implements PhepThuat, LuyenCong{
public class ChienBinhAnhDung extends ChienBinh implements LuyenCongPhepThuat {
    private int sucManh;

    public ChienBinhAnhDung() {
    }

    public ChienBinhAnhDung(String ten, int tuoi, float chieuCao, int canNang, String vuKhi, int sucManh) {
        super(ten, tuoi, chieuCao, canNang, vuKhi);
        this.sucManh = sucManh;
    }

    public int getSucManh() {
        return sucManh;
    }

    public void setSucManh(int sucManh) {
        this.sucManh = sucManh;
    }

    @Override
    public void cachChienDau() {
        System.out.println("Chiến đấu bằng sức mạnh và phép thuật");
    }

    @Override
    public String toString() {
        return "ChienBinhAnhDung{" +
                super.toString() +
                "sucManh=" + sucManh +
                '}';
    }

    @Override
    public void hoMuaGoiGio() {
        System.out.println("Chiến binh anh dũng đi học phép thuật");
    }

    public void diLuyenCong() {
        System.out.println("Chiến binh anh dũng đi luyện công");
    }
}
