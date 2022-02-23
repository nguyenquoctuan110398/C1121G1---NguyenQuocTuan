package thi_module_2.services.Impl;

import thi_module_2.models.BenhAnBenhNhan;
import thi_module_2.models.BenhAnBenhNhanThuong;
import thi_module_2.services.IThem;
import thi_module_2.utils.ReadAndWriteToCSV;
import thi_module_2.utils.Validate;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BenhAnBenhNhanThuongServiceImpl implements IThem {

    //    public static final String REGEX_MA_BENH_AN="^[A-Z][a-z]+$";
    public static final String REGEX_MA_BENH_AN = "^(BA)[-][\\d]{3}$";
    Validate validate = new Validate();

    Scanner scanner = new Scanner(System.in);


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

        System.out.println("Nhập phí nằm viện: ");
        Double phiNamVien = Double.parseDouble(scanner.nextLine());

        BenhAnBenhNhanThuong benhAnBenhNhanThuong = new BenhAnBenhNhanThuong(soThuTuBenhAn, maBenhAn,
                maBenhNhan, tenBenhNhan, ngayNhapVien, ngayRaVien, lyDoNhapVien, phiNamVien);

        benhAnBenhNhanList.add(benhAnBenhNhanThuong);
        ReadAndWriteToCSV.vietBenhAnDenCSV(benhAnBenhNhanList, ReadAndWriteToCSV.BENHANBENHNHAN_FILE, false);
    }

    public String kiemTraValidateMaBenhAn() {

        System.out.println("Nhập mã bệnh án: ");

        return validate.regex(scanner.nextLine(), REGEX_MA_BENH_AN, "Nhập sai định dạng, nhập lại theo đúng kiểu BA-XXX!");
    }
}
