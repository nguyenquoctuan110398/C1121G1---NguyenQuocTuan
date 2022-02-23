package case_study_08.controllers;

import java.util.Scanner;

public class QuanLyTaiKhoan {

    Scanner scanner = new Scanner(System.in);

    public void hienThiMenu() {

        boolean check;
        int choose = 0;

        do {
            check = true;

            System.out.println("--CHƯƠNG TRÌNH QUẢN LÝ TÀI KHOẢN NGÂN HÀNG--" +
                    "Chọn chức năng theo số (để tiếp tục):\n" +
                    "1. Thêm mới\n" +
                    "2. Xóa\n" +
                    "3. Xem danh sách các tài khoản ngân hàng\n" +
                    "4. Tìm kiếm\n" +
                    "5. Thoát");

            System.out.println("Chọn chức năng: ");
            try{
                choose = Integer.parseInt(scanner.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Nhập sai định dạng, mời nhập lại");
            }

            switch (choose){

            }

        } while (check);


    }
}
