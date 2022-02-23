package thi_module_2.models;

public class BenhAnBenhNhanVip extends BenhAnBenhNhan {

    private String loaiVip;
    private String thoiHanVip;

    public enum loaiVip {
        VIP1("VIP I"),
        VIP2("VIP II"),
        VIP3("VIP III");
        private final String value;

        loaiVip(final String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public BenhAnBenhNhanVip() {
    }

    public BenhAnBenhNhanVip(String loaiVip, String thoiHanVip) {
        this.loaiVip = loaiVip;
        this.thoiHanVip = thoiHanVip;
    }

    public BenhAnBenhNhanVip(int soThuTu, String maBenhAn, String maBenhNhan, String tenBenhNhan,
                             String ngayNhapVien, String ngayRaVien, String lyDoNhapVien, String loaiVip,
                             String thoiHanVip) {
        super(soThuTu, maBenhAn, maBenhNhan, tenBenhNhan, ngayNhapVien, ngayRaVien, lyDoNhapVien);
        this.loaiVip = loaiVip;
        this.thoiHanVip = thoiHanVip;
    }

    public String getLoaiVip() {
        return loaiVip;
    }

    public void setLoaiVip(String loaiVip) {
        this.loaiVip = loaiVip;
    }

    public String getThoiHanVip() {
        return thoiHanVip;
    }

    public void setThoiHanVip(String thoiHanVip) {
        this.thoiHanVip = thoiHanVip;
    }

    @Override
    public String toString() {
        return "BenhAnBenhNhanVip{" + super.toString() +
                "loaiVip=" + loaiVip +
                ", thoiHanVip='" + thoiHanVip + '\'' +
                '}';
    }

    public String dienThongTinVaoCSV() {
        return super.dienThongTinVaoCSV() + "," + this.loaiVip + "," + this.thoiHanVip;
    }
}
