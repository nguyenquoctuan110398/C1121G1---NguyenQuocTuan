package thi_module_2.services.Impl;

import models.Employee;
import thi_module_2.models.BenhAnBenhNhan;
import thi_module_2.services.IBenhAnBenhNhan;
import thi_module_2.utils.ReadAndWriteToCSV;
import thi_module_2.utils.Validate;
import utils.ReadAndWriteCSVFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BenhAnBenhNhanServiceImpl implements IBenhAnBenhNhan {

    Validate validate = new Validate();

    Scanner scanner = new Scanner(System.in);
    public static final String REGEX_MA_BENH_AN = "^((BA)[-][\\d]{3})|((BN)[-][\\d]{3})$";

    @Override
    public void hienThi() {
        List<BenhAnBenhNhan> benhAnBenhNhanList = new ArrayList<>();

        benhAnBenhNhanList = ReadAndWriteToCSV.docBenhAnTuCSV(ReadAndWriteToCSV.BENHANBENHNHAN_FILE);

        for (BenhAnBenhNhan benhAnBenhNhan : benhAnBenhNhanList) {
            System.out.println(benhAnBenhNhan);
        }
    }

    @Override
    public void xoa() {
        this.hienThi();

        List<BenhAnBenhNhan> benhAnBenhNhanList = new ArrayList<>();
        benhAnBenhNhanList = ReadAndWriteToCSV.docBenhAnTuCSV(ReadAndWriteToCSV.BENHANBENHNHAN_FILE);

//        System.out.println("Nhập mã bệnh án cần xóa: ");
//        String maBenhAnCanXoa = scanner.nextLine();

        String maBenhAnCanXoa = kiemTraValidateMaBenhAn();

        boolean check=false;

        for (int i = 0; i < benhAnBenhNhanList.size(); i++) {

            if (maBenhAnCanXoa.equals(benhAnBenhNhanList.get(i).getMaBenhAn())){
                check =true;
                System.out.println("Bạn có muốn thực hiện chức năng xóa: ");
                System.out.println("1. Yes\n" +
                        "2. No");

                int luaChon=0;
                try{
                    luaChon = Integer.parseInt(scanner.nextLine());
                }catch (NumberFormatException e){
                    System.out.println("Nhập sai định dạng, mời nhập lại");
                }

                switch (luaChon){
                    case 1:
                        benhAnBenhNhanList.remove(i);
                        break;
                    case 2:
                        break;
                }
            } break;
        }
        ReadAndWriteToCSV.vietBenhAnDenCSV(benhAnBenhNhanList,ReadAndWriteToCSV.BENHANBENHNHAN_FILE,false);
    }

    public String kiemTraValidateMaBenhAn() {

        System.out.println("Nhập mã bệnh án: ");

        return validate.regex(scanner.nextLine(), REGEX_MA_BENH_AN, "Nhập sai định dạng, nhập lại theo đúng kiểu BA-XXX hoặc BN-XXX!");
    }
}
