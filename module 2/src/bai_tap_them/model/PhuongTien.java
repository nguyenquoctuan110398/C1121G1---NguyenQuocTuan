package bai_tap_them.model;

public abstract class PhuongTien {
    private String bienKiemSoat;
    private HangSanXuat tenHangSanXuat;
    private int namSanXuat;
    private String chuSoHuu;

    public PhuongTien(String bienKiemSoat, HangSanXuat tenHangSanXuat, int namSanXuat, String chuSoHuu) {
        this.bienKiemSoat = bienKiemSoat;
        this.tenHangSanXuat = tenHangSanXuat;
        this.namSanXuat = namSanXuat;
        this.chuSoHuu = chuSoHuu;
    }

    public String getBienKiemSoat() {
        return bienKiemSoat;
    }

    public void setBienKiemSoat(String bienKiemSoat) {
        this.bienKiemSoat = bienKiemSoat;
    }

    public HangSanXuat getTenHangSanXuat() {
        return tenHangSanXuat;
    }

    public void setTenHangSanXuat(HangSanXuat tenHangSanXuat) {
        this.tenHangSanXuat = tenHangSanXuat;
    }

    public int getNamSanXuat() {
        return namSanXuat;
    }

    public void setNamSanXuat(int namSanXuat) {
        this.namSanXuat = namSanXuat;
    }

    public String getChuSoHuu() {
        return chuSoHuu;
    }

    public void setChuSoHuu(String chuSoHuu) {
        this.chuSoHuu = chuSoHuu;
    }

    @Override
    public String toString() {
        return "bienKiemSoat=" + bienKiemSoat  +
                ", tenHangSanXuat=" + tenHangSanXuat.getTenHangSanXuat() +
                ", namSanXuat=" + namSanXuat +
                ", chuSoHuu=" + chuSoHuu;
    }
}
