package demo_bt_them.demo_abstract;

public abstract class ChienBinh extends ConNguoi {
    private String vuKhi;

    public ChienBinh() {
    }

    public ChienBinh(String ten, int tuoi, float chieuCao, int canNang, String vuKhi) {
        super(ten, tuoi, chieuCao, canNang);
        this.vuKhi = vuKhi;
    }

    public String getVuKhi() {
        return vuKhi;
    }

    public void setVuKhi(String vuKhi) {
        this.vuKhi = vuKhi;
    }

    public void lamNhiemVu(String nhiemVu) {
        System.out.println("Chiến binh làm nv: " + nhiemVu);
    }

    ;

    @Override
    public void diChuyen() {
        System.out.println("Chiến binh di chuyển bằng ngựa");
    }

    public abstract void cachChienDau();

    @Override
    public String toString() {
        return "ChienBinh{" +
                super.toString() +
                "vuKhi='" + vuKhi + '\'' +
                '}';
    }
}
