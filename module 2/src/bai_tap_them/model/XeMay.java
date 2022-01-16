package bai_tap_them.model;

public class XeMay extends PhuongTien{
    private int congSuat;

    public XeMay(String bienKiemSoat,HangSanXuat hangSanXuat,int namSanXuat,String chuSoHuu,int congSuat){
        super(bienKiemSoat,hangSanXuat,namSanXuat,chuSoHuu);
        this.congSuat=congSuat;
    }

    public int getCongSuat() {
        return congSuat;
    }

    public void setCongSuat(int congSuat) {
        this.congSuat = congSuat;
    }

    @Override
    public String toString() {
        return super.toString() +
                "congSuat=" + congSuat;
    }
}
