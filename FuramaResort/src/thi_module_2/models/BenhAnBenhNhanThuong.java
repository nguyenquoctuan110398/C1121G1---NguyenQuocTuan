package thi_module_2.models;

public class BenhAnBenhNhanThuong extends BenhAnBenhNhan {

    private double phiNamVien;

    public BenhAnBenhNhanThuong() {
    }

    public BenhAnBenhNhanThuong(double phiNamVien) {
        this.phiNamVien = phiNamVien;
    }

    public BenhAnBenhNhanThuong(int soThuTu, String maBenhAn,String maBenhNhan, String tenBenhNhan, String ngayNhapVien,
                                String ngayRaVien, String lyDoNhapVien, double phiNamVien) {
        super(soThuTu, maBenhAn,maBenhNhan, tenBenhNhan, ngayNhapVien, ngayRaVien, lyDoNhapVien);
        this.phiNamVien = phiNamVien;
    }

    public double getPhiNamVien() {
        return phiNamVien;
    }

    public void setPhiNamVien(double phiNamVien) {
        this.phiNamVien = phiNamVien;
    }

    @Override
    public String toString() {
        return "BenhAnBenhNhanThuong{" + super.toString() +
                "phiNamVien=" + phiNamVien +
                '}';
    }

    public String dienThongTinVaoCSV() {
        return super.dienThongTinVaoCSV()+","+this.phiNamVien;
    }
}
