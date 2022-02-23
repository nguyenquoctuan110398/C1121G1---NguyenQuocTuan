package thi_module_2.services.Impl;

import models.Employee;
import thi_module_2.models.BenhAnBenhNhan;
import thi_module_2.models.BenhAnBenhNhanVip;
import thi_module_2.services.IThem;
import thi_module_2.services.IXoa;
import thi_module_2.utils.ReadAndWriteToCSV;
import thi_module_2.utils.Validate;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BenhAnBenhNhanVipServiceImpl implements IThem{

    Scanner scanner =new Scanner(System.in);
    Validate validate =new Validate();

    public static final String REGEX_MA_BENH_AN="^(BN)[-][\\d]{3}$";

    @Override
    public void them() {
        List<BenhAnBenhNhan> benhAnBenhNhanList = new ArrayList<>();
        benhAnBenhNhanList = ReadAndWriteToCSV.docBenhAnTuCSV(ReadAndWriteToCSV.BENHANBENHNHAN_FILE);

        int soThuTuBenhAn = 1;
        if (!benhAnBenhNhanList.isEmpty()) {
            soThuTuBenhAn = benhAnBenhNhanList.size() + 1;
        }

//        System.out.println("Nhập mã bệnh án: ");
//        String maBenhAn = scanner.nextLine();

        String maBenhAn = kiemTraValidateMaBenhAn();

        System.out.println("Nhập mã bệnh nhân: ");
        String maBenhNhan = scanner.nextLine();

        System.out.println("Nhập tên bệnh nhân: ");
        String tenBenhNhan = scanner.nextLine();

        System.out.println("Nhập ngày nhập viện: ");
        String ngayNhapVien = scanner.nextLine();

        System.out.println("Nhập ngày ra viện: ");
        String ngayRaVien = scanner.nextLine();

        System.out.println("Nhập lý do nhập viện: ");
        String lyDoNhapVien = scanner.nextLine();

        System.out.println("Nhập loại vip: ");
        int dem=0;
        String loaiVip = null;

        for (BenhAnBenhNhanVip.loaiVip loaiVipBenhNhanVip : BenhAnBenhNhanVip.loaiVip.values()) {
            System.out.println(++dem + ". " + loaiVipBenhNhanVip);
        }
        System.out.println("Choose employee position: ");
        int luaChon = Integer.parseInt(scanner.nextLine());

        switch (luaChon){
            case 1:
                loaiVip=BenhAnBenhNhanVip.loaiVip.VIP1.getValue();
                break;
            case 2:
                loaiVip=BenhAnBenhNhanVip.loaiVip.VIP2.getValue();
                break;
            case 3:
                loaiVip=BenhAnBenhNhanVip.loaiVip.VIP3.getValue();
                break;
            default:
                break;
        }

        System.out.println("Nhập thời hạn Vip: ");
        String thoiHanVip = scanner.nextLine();

        BenhAnBenhNhanVip benhAnBenhNhanVip = new BenhAnBenhNhanVip(soThuTuBenhAn,maBenhAn,maBenhNhan,
                tenBenhNhan,ngayNhapVien,ngayRaVien,lyDoNhapVien,loaiVip,thoiHanVip);

        benhAnBenhNhanList.add(benhAnBenhNhanVip);

        ReadAndWriteToCSV.vietBenhAnDenCSV(benhAnBenhNhanList,ReadAndWriteToCSV.BENHANBENHNHAN_FILE,false);
    }

    public String kiemTraValidateMaBenhAn() {

        System.out.println("Nhập mã bệnh án: ");

        return validate.regex(scanner.nextLine(), REGEX_MA_BENH_AN, "Nhập sai định dạng, nhập lại theo đúng kiểu BN-XXX!");
    }

}
