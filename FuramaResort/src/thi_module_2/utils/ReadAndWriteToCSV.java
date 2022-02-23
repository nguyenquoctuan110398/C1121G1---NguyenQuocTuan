package thi_module_2.utils;

import thi_module_2.models.BenhAnBenhNhan;
import thi_module_2.models.BenhAnBenhNhanThuong;
import thi_module_2.models.BenhAnBenhNhanVip;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class ReadAndWriteToCSV {

    public static final String BENHANBENHNHAN_FILE = "src/thi_module_2/data/BenhAnBenhNhan.csv";

    public static <E> void vietBenhAnDenCSV(List<E> list, String filePath, boolean append) {
        File file = new File(filePath);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file, append);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (E element : list) {
                if (element instanceof BenhAnBenhNhanThuong) {
                    bufferedWriter.write(((BenhAnBenhNhanThuong) element).dienThongTinVaoCSV());
                    bufferedWriter.newLine();
                } else if (element instanceof BenhAnBenhNhanVip) {
                    bufferedWriter.write(((BenhAnBenhNhanVip) element).dienThongTinVaoCSV());
                    bufferedWriter.newLine();
                }
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<BenhAnBenhNhan> docBenhAnTuCSV(String filePath) {
        List<BenhAnBenhNhan> benhNhanList = new LinkedList<>();
        File file = new File(filePath);
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line = "";
            String[] array = null;
            while ((line = bufferedReader.readLine()) != null) {
                array = line.split(",");
                if (array.length == 8) {
                    BenhAnBenhNhanThuong benhAnBenhNhanThuong = new BenhAnBenhNhanThuong(Integer.parseInt(array[0]),
                            array[1], array[2], array[3], array[4], array[5], array[6], Double.parseDouble(array[7]));
                    benhNhanList.add(benhAnBenhNhanThuong);
                } else {
                    BenhAnBenhNhanVip benhAnBenhNhanVip = new BenhAnBenhNhanVip(Integer.parseInt(array[0]),
                            array[1], array[2], array[3], array[4], array[5], array[6], array[7], array[8]);
                    benhNhanList.add(benhAnBenhNhanVip);
                }
            }
            bufferedReader.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return benhNhanList;
    }
}

