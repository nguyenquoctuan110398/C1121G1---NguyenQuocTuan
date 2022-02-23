package case_study_08.models;

public class TaiKhoanThanhToan extends TaiKhoanNganHang{
    private int soThe;
    private double soTienTrongTaiKhoan;

    public TaiKhoanThanhToan() {
    }

    public TaiKhoanThanhToan(int soThe, double soTienTrongTaiKhoan) {
        this.soThe = soThe;
        this.soTienTrongTaiKhoan = soTienTrongTaiKhoan;
    }

    public TaiKhoanThanhToan(int idTaiKhoan, String maTaiKhoan, String tenChuTaiKhoan, int ngayTaoTaiKhoan, int soThe, double soTienTrongTaiKhoan) {
        super(idTaiKhoan, maTaiKhoan, tenChuTaiKhoan, ngayTaoTaiKhoan);
        this.soThe = soThe;
        this.soTienTrongTaiKhoan = soTienTrongTaiKhoan;
    }

    @Override
    public String toString() {
        return "TaiKhoanThanhToan{" +
                super.toString()+
                "soThe=" + soThe +
                ", soTienTrongTaiKhoan=" + soTienTrongTaiKhoan +
                '}';
    }
}
