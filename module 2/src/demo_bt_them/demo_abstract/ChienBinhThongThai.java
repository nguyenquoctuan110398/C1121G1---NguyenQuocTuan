package demo_bt_them.demo_abstract;

public class ChienBinhThongThai extends ChienBinh implements PhepThuat {
    private int chiSoThongMinh;

    public ChienBinhThongThai() {
    }

    public ChienBinhThongThai(String ten, int tuoi, float chieuCao, int canNang, String vuKhi, int chiSoThongMinh) {
        super(ten, tuoi, chieuCao, canNang, vuKhi);
        this.chiSoThongMinh = chiSoThongMinh;
    }

    public int getChiSoThongMinh() {
        return chiSoThongMinh;
    }

    public void setChiSoThongMinh(int chiSoThongMinh) {
        this.chiSoThongMinh = chiSoThongMinh;
    }

    @Override
    public void cachChienDau() {
        System.out.println("Chiến đấu bằng trí tuệ và phép thuật");
    }

    @Override
    public String toString() {
        return "ChienBinhThongThai{" + super.toString() +
                "chiSoThongMinh=" + chiSoThongMinh +
                '}';
    }

    @Override
    public void hoMuaGoiGio() {
        System.out.println("Chiến binh thông thái hô mưa gọi gió");
    }
}
