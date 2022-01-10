package demo_bt_them.demo_abstract;

public class Vua extends ConNguoi {
    boolean minhQuan;

    public Vua() {
    }

    public Vua(String ten, int tuoi, float chieuCao, int canNang, boolean minhQuan) {
        super(ten, tuoi, chieuCao, canNang);
        this.minhQuan = minhQuan;
    }

    public boolean isMinhQuan() {
        return minhQuan;
    }

    public void setMinhQuan(boolean minhQuan) {
        this.minhQuan = minhQuan;
    }

    @Override
    public void diChuyen() {
        System.out.println("Vua đi lại bằng kiệu: ");

    }

    public void raLenh(String tenLenh) {
        System.out.println("Vua ra lenh: " + tenLenh);
    }

    @Override
    public String toString() {
        return "Vua{" +
                super.toString() +
                "minhQuan=" + minhQuan +
                '}';
    }
}
