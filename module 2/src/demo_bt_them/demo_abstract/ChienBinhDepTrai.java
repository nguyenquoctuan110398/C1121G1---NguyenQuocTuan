package demo_bt_them.demo_abstract;

public class ChienBinhDepTrai extends ChienBinh {
    private int doDepTrai;

    public ChienBinhDepTrai() {
    }

    public ChienBinhDepTrai(String ten, int tuoi, float chieuCao, int canNang, String vuKhi, int doDepTrai) {
        super(ten, tuoi, chieuCao, canNang, vuKhi);
        this.doDepTrai = doDepTrai;
    }

    public int getDoDepTrai() {
        return doDepTrai;
    }

    public void setDoDepTrai(int doDepTrai) {
        this.doDepTrai = doDepTrai;
    }

    @Override
    public void cachChienDau() {
        System.out.println("Dùng sắc đẹp để chiến đấu - Mỹ nhân kế");
    }

    @Override
    public String toString() {
//        return "ChienBinhDepTrai{" + super.toString() +
//                "doDepTrai=" + doDepTrai +
//                '}';
        return "ChienBinhDepTrai{" + " Tên " + super.getTen() +
                " Tuổi " + super.getTuoi() +
                " doDepTrai=" + doDepTrai +
                '}';
    }
}
