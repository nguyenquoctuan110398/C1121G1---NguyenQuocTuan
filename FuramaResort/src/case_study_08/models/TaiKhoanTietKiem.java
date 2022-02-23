package case_study_08.models;

public class TaiKhoanTietKiem extends TaiKhoanNganHang {
    private Double soTienGuiTietKiem;
    private String ngayGuiTietKiem;
    private float laiSuat;
    private String kyHan;

    public TaiKhoanTietKiem() {
    }

    public TaiKhoanTietKiem(Double soTienGuiTietKiem, String ngayGuiTietKiem, float laiSuat, String kyHan) {
        this.soTienGuiTietKiem = soTienGuiTietKiem;
        this.ngayGuiTietKiem = ngayGuiTietKiem;
        this.laiSuat = laiSuat;
        this.kyHan = kyHan;
    }

    public TaiKhoanTietKiem(int idTaiKhoan, String maTaiKhoan, String tenChuTaiKhoan, int ngayTaoTaiKhoan,
                            Double soTienGuiTietKiem, String ngayGuiTietKiem, float laiSuat, String kyHan) {
        super(idTaiKhoan, maTaiKhoan, tenChuTaiKhoan, ngayTaoTaiKhoan);
        this.soTienGuiTietKiem = soTienGuiTietKiem;
        this.ngayGuiTietKiem = ngayGuiTietKiem;
        this.laiSuat = laiSuat;
        this.kyHan = kyHan;
    }

    public Double getSoTienGuiTietKiem() {
        return soTienGuiTietKiem;
    }

    public void setSoTienGuiTietKiem(Double soTienGuiTietKiem) {
        this.soTienGuiTietKiem = soTienGuiTietKiem;
    }

    public String getNgayGuiTietKiem() {
        return ngayGuiTietKiem;
    }

    public void setNgayGuiTietKiem(String ngayGuiTietKiem) {
        this.ngayGuiTietKiem = ngayGuiTietKiem;
    }

    public float getLaiSuat() {
        return laiSuat;
    }

    public void setLaiSuat(float laiSuat) {
        this.laiSuat = laiSuat;
    }

    public String getKyHan() {
        return kyHan;
    }

    public void setKyHan(String kyHan) {
        this.kyHan = kyHan;
    }

    @Override
    public String toString() {
        return "TaiKhoanTietKiem{" +
                super.toString() +
                "soTienGuiTietKiem=" + soTienGuiTietKiem +
                ", ngayGuiTietKiem='" + ngayGuiTietKiem + '\'' +
                ", laiSuat=" + laiSuat +
                ", kyHan='" + kyHan + '\'' +
                '}';
    }
}
