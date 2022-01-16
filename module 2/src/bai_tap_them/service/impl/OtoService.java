package bai_tap_them.service.impl;

import bai_tap_them.model.HangSanXuat;
import bai_tap_them.model.Oto;
import bai_tap_them.service.IPhuongTienService;

import java.util.ArrayList;
import java.util.Scanner;

public class OtoService implements IPhuongTienService {
    static ArrayList<Oto> otoArrayList = new ArrayList<>();
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
        System.out.println("Nhập kiểu xe: ");
        String kieuXe = scanner.nextLine();
        System.out.println("Nhập số chỗ ngồi: ");
        int soChoNgoi = Integer.parseInt(scanner.nextLine());
        Oto oto = new Oto(bienKiemSoat, hangSanXuat, namSanXuat, chuSoHuu, soChoNgoi, kieuXe);

        otoArrayList.add(oto);
    }

    @Override
    public void delete() {
        int choose;
        System.out.println("Nhập biển kiểm soát của phương tiện cần xóa: ");
        String bienKiemSoatDelete= scanner.nextLine();
        for (int i=0; i<otoArrayList.size();i++){
            if (bienKiemSoatDelete.equals(otoArrayList.get(i).getBienKiemSoat())){
                System.out.println("1. Yes\n" +
                        "2.No");
                System.out.println("Nhập lựa chọn: ");
                choose=Integer.parseInt(scanner.nextLine());
                switch (choose){
                    case 1:
                        otoArrayList.remove(i);
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
        for (Oto oto : otoArrayList) {
            System.out.println(oto);
        }
    }
}
