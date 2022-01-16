package bai_tap_them.model;

public class XeTai extends PhuongTien{
    private int trongTai;
    public XeTai(String bienKiemSoat,HangSanXuat hangSanXuat,int namSanXuat,String chuSoHuu, int trongTai){
        super(bienKiemSoat,hangSanXuat,namSanXuat,chuSoHuu);
        this.trongTai=trongTai;
    }

    public int getTrongTai() {
        return trongTai;
    }

    public void setTrongTai(int trongTai) {
        this.trongTai = trongTai;
    }

    @Override
    public String toString() {
        return "XeTai {" + super.toString() +
                ", trongTai=" + trongTai
                +"}";
    }
}
