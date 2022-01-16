package bai_tap_them.service.impl;

import bai_tap_them.model.HangSanXuat;
import bai_tap_them.model.XeTai;
import bai_tap_them.service.IPhuongTienService;

import java.util.ArrayList;
import java.util.Scanner;

public class XeTaiService implements IPhuongTienService {
    static ArrayList<XeTai> xeTaiArrayList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    @Override
    public void add() {
        HangSanXuatService hangSanXuatService = new HangSanXuatService();

        System.out.println("Nhập biển kiểm soát: ");
        String bienKiemSoat = scanner.nextLine();
        System.out.println("Chọn hãng sản xuất: ");
        hangSanXuatService.listLuaChon();
        System.out.println("Lựa chọn");
        int i = Integer.parseInt(scanner.nextLine());
        HangSanXuat hangSanXuat = hangSanXuatService.truyenDuLieu(i);
        System.out.println("Nhập năm sản xuất: ");
        int namSanXuat = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập chủ sở hữu: ");
        String chuSoHuu = scanner.nextLine();
        System.out.println("Nhập tải trọng: ");
        int taiTrong = Integer.parseInt(scanner.nextLine());

        XeTai xeTai = new XeTai(bienKiemSoat, hangSanXuat, namSanXuat, chuSoHuu, taiTrong);
        xeTaiArrayList.add(xeTai);
    }

    @Override
    public void delete() {
        int choose;
        System.out.println("Nhập biển kiểm soát của phương tiện cần xóa: ");
        String bienKiemSoatDelete= scanner.nextLine();
        for (int i=0; i<xeTaiArrayList.size();i++){
            if (bienKiemSoatDelete.equals(xeTaiArrayList.get(i).getBienKiemSoat())){
                System.out.println("1. Yes\n" +
                        "2.No");
                System.out.println("Nhập lựa chọn: ");
                choose=Integer.parseInt(scanner.nextLine());
                switch (choose){
                    case 1:
                        xeTaiArrayList.remove(i);
                        System.out.println("Đã xóa thành công");
                        break;
                    case 2:
                        break;
                }
                break;
            }
        }
    }

    @Override
    public void findAll() {
        for (XeTai xeTai : xeTaiArrayList) {
            System.out.println(xeTai);
        }
    }
}
