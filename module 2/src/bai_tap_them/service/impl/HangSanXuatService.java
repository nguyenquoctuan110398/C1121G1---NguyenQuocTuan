package bai_tap_them.service.impl;

import bai_tap_them.model.HangSanXuat;
import bai_tap_them.service.IHangSanXuat;

import java.util.ArrayList;

public class HangSanXuatService implements IHangSanXuat {

    private static ArrayList<HangSanXuat> hangSanXuatServiceArrayList = new ArrayList<>();

    static {
        HangSanXuat hangSanXuat1 = new HangSanXuat("HSX-001", "Yamaha", "Nhật Bản");
        hangSanXuatServiceArrayList.add(hangSanXuat1);
        HangSanXuat hangSanXuat2 = new HangSanXuat("HSX-002", "Honda", "Nhật Bản");
        hangSanXuatServiceArrayList.add(hangSanXuat2);
        HangSanXuat hangSanXuat3 = new HangSanXuat("HSX-003", "Dongfeng", "Trung Quốc");
        hangSanXuatServiceArrayList.add(hangSanXuat3);
        HangSanXuat hangSanXuat4 = new HangSanXuat("HSX-004", "Huyndai", "Hàn Quốc");
        hangSanXuatServiceArrayList.add(hangSanXuat4);
        HangSanXuat hangSanXuat5 = new HangSanXuat("HSX-005", "Ford", "Mĩ");
        hangSanXuatServiceArrayList.add(hangSanXuat5);
        HangSanXuat hangSanXuat6 = new HangSanXuat("HSX-006", "Toyota", "Nhật Bản");
        hangSanXuatServiceArrayList.add(hangSanXuat6);
        HangSanXuat hangSanXuat7 = new HangSanXuat("HSX-007", "Hino", "Nhật Bản");
        hangSanXuatServiceArrayList.add(hangSanXuat7);
    }

    public void listLuaChon() {
        for (int i = 0; i < hangSanXuatServiceArrayList.size(); i++) {
            System.out.println((i + 1) + ". " + hangSanXuatServiceArrayList.get(i));
        }
    }

    public HangSanXuat truyenDuLieu(int i) {
        HangSanXuat data;
        data = hangSanXuatServiceArrayList.get((i - 1));
        return data;
    }
}
