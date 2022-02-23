package thi_module_2.controllers;

import thi_module_2.services.Impl.BenhAnBenhNhanServiceImpl;
import thi_module_2.services.Impl.BenhAnBenhNhanThuongServiceImpl;
import thi_module_2.services.Impl.BenhAnBenhNhanVipServiceImpl;

import java.util.Scanner;

public class QuanLyBenhAn {
    Scanner scanner = new Scanner(System.in);
    BenhAnBenhNhanThuongServiceImpl benhAnBenhNhanThuongService = new BenhAnBenhNhanThuongServiceImpl();
    BenhAnBenhNhanVipServiceImpl benhAnBenhNhanVipService = new BenhAnBenhNhanVipServiceImpl();
    BenhAnBenhNhanServiceImpl benhAnBenhNhanService = new BenhAnBenhNhanServiceImpl();

    public void hienThiQuanLyBenhAn() {
        int luaChon = 0;
        boolean kiemTra;

        do {
            kiemTra = true;
            System.out.println("--CHƯƠNG TRÌNH QUẢN LÝ BỆNH ÁN–\n" +
                    "Chọn chức năng theo số (để tiếp tục):\n" +
                    "1. Thêm mới\n" +
                    "2. Xóa\n" +
                    "3. Xem danh sách các bệnh án\n" +
                    "4. Thoát\n");

            System.out.print("Chọn chức năng: ");

            try {
                luaChon = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Nhập sai định dạng, mời nhập lại");
            }

            switch (luaChon) {
                case 1:
                    int luaChon1 = 0;
                    boolean kiemTra1;

                    do {
                        kiemTra1 = true;
                        System.out.println("1. Thêm bệnh án bệnh nhân thường\n" +
                                "2. Thêm bệnh án bệnh nhân vip\n" +
                                "3. Thoát");

                        System.out.print("Chọn loại bệnh nhân cần thêm: ");

                        try {
                            luaChon1 = Integer.parseInt(scanner.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println("Nhập sai định dạng, mời nhập lại");
                        }

                        switch (luaChon1) {
                            case 1:
                                benhAnBenhNhanThuongService.them();
                                break;
                            case 2:
                                benhAnBenhNhanVipService.them();
                                break;
                            case 3:
                                kiemTra1 = false;
                                break;
                            default:
                                System.out.println("Nhập sai lựa chọn, mời nhập lại: ");
                                break;
                        }

                    } while (kiemTra1);
                    break;

                case 2:
                    benhAnBenhNhanService.xoa();
                    break;

                case 3:
                    benhAnBenhNhanService.hienThi();
                    break;

                case 4:
                    kiemTra = false;
                    break;

                default:
                    System.out.println("Nhập sai lựa chọn, mời nhập lại: ");
                    break;

            }
        } while (kiemTra);
    }

}
