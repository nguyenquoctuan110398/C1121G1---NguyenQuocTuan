package bai_tap_them.controller;

import bai_tap_them.service.IPhuongTienService;
import bai_tap_them.service.impl.OtoService;
import bai_tap_them.service.impl.XeMayService;
import bai_tap_them.service.impl.XeTaiService;

import java.util.Scanner;

public class QuanLiPhuongTien {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        IPhuongTienService iPhuongTienService=new PhuongTienService();
        IPhuongTienService iPhuongTienService1 = new XeTaiService();
        IPhuongTienService iPhuongTienService2 = new OtoService();
        IPhuongTienService iPhuongTienService3 = new XeMayService();
        while (true) {
            System.out.println("CHƯƠNG TRÌNH QUẢN LÝ PHƯƠNG TIỆN GIAO THÔNG\n" +
                    "Chọn chức năng:\n" +
                    "1. Thêm mới phương tiện\n" +
                    "2. Hiện thị phương tiện\n" +
                    "3. Xóa phương tiện\n" +
                    "4. Thoát\n");
            System.out.println("Nhập lựa chọn: ");
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    int choosePhuongTien;

                    do {
                        System.out.println("CHỌN PHƯƠNG TIỆN CẦN THÊM\n" +
                                "1. Xe tải\n" +
                                "2. Oto\n" +
                                "3. Xe máy");
                        System.out.println("Nhập lựa chọn");
                        choosePhuongTien = Integer.parseInt(scanner.nextLine());

                        switch (choosePhuongTien) {
                            case 1:
                                iPhuongTienService1.add();
                                break;
                            case 2:
                                iPhuongTienService2.add();
                                break;
                            case 3:
                                iPhuongTienService3.add();
                                break;
                        }
                    } while (choosePhuongTien < 4 && choosePhuongTien > 0);
                    break;

                case 2:
                    int chooseHienThi;

                    do {
                        System.out.println("HIỂN THỊ PHƯƠNG TIỆN\n" +
                                "1. Hiển thị xe tải\n" +
                                "2. Hiển thị oto\n" +
                                "3. Hiển thị xe máy");
                        System.out.println("Nhập lựa chọn");
                        chooseHienThi = Integer.parseInt(scanner.nextLine());

                        switch (chooseHienThi) {
                            case 1:
                                iPhuongTienService1.findAll();
                                break;
                            case 2:
                                iPhuongTienService2.findAll();
                                break;
                            case 3:
                                iPhuongTienService3.findAll();
                                break;
                        }
                    } while (chooseHienThi < 4 && chooseHienThi > 0);
                    break;

                case 3:
                    int chooseDelete;
                    do {
                        System.out.println("CHỌN PHƯƠNG TIỆN CẦN XÓA\n" +
                                "1. Xe tải\n" +
                                "2. Oto\n" +
                                "3. Xe máy");
                        System.out.println("Nhập lựa chọn");
                        chooseDelete = Integer.parseInt(scanner.nextLine());

                        switch (chooseDelete) {
                            case 1:
                                iPhuongTienService1.delete();
                                break;
                            case 2:
                                iPhuongTienService2.delete();
                                break;
                            case 3:
                                iPhuongTienService3.delete();
                                break;
                        }
                    } while (chooseDelete< 4 && chooseDelete > 0);
                    break;
                case 4:
                    break;
            }
        }
    }
}
