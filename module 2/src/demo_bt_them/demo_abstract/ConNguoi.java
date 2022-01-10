package demo_bt_them.demo_abstract;

public abstract class ConNguoi {
    private String ten;
    private int tuoi;
    private float chieuCao;
    private int canNang;
    public abstract void diChuyen(); //pt trừu tượng

    public ConNguoi(){

    }

    public ConNguoi(String ten, int tuoi, float chieuCao, int canNang) {
        this.ten = ten;
        this.tuoi = tuoi;
        this.chieuCao = chieuCao;
        this.canNang = canNang;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public float getChieuCao() {
        return chieuCao;
    }

    public void setChieuCao(float chieuCao) {
        this.chieuCao = chieuCao;
    }

    public int getCanNang() {
        return canNang;
    }

    public void setCanNang(int canNang) {
        this.canNang = canNang;
    }

    @Override
    public String toString() {
        return "ConNguoi{" +
                "ten='" + ten + '\'' +
                ", tuoi=" + tuoi +
                ", chieuCao=" + chieuCao +
                ", canNang=" + canNang +
                '}';
    }
}
