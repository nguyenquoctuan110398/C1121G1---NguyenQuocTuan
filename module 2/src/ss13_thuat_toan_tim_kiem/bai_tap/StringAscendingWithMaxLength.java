package ss13_thuat_toan_tim_kiem.bai_tap;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class StringAscendingWithMaxLength {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Nhập chuỗi: ");
        String string = input.nextLine();

        LinkedList<Character> max = new LinkedList<>();
        LinkedList<LinkedList> lists = new LinkedList<>();

        // Tìm chuỗi tăng dần có độ dài lớn nhất
        for (int i = 0; i < string.length(); i++) { //Vòng lặp bên ngoài
            //Khai báo một linked list trung gian các kí tự của chuỗi tăng dần
            LinkedList<Character> list = new LinkedList<>();

            //thêm kí tự thứ i vào trong list
            list.add(string.charAt(i));

            for (int j = i + 1; j < string.length(); j++) { //vòng lặp bên trong
                for (int k = j; k < string.length(); k++) {
                    //Kiểm tra kí tự tiếp theo có lớn hơn kí tự cuối cùng trong list hay không
                    if (string.charAt(k) > list.getLast()) {
                        //Nếu có thì thêm vào trong list
                        list.add(string.charAt(k));
                    }
                }
                lists.add(list);
                list = new LinkedList<>();
                list.add(string.charAt(i));
            }
        }

        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int z = 0; z < lists.size(); z++) {
            arrayList.add(lists.get(z).size());
        }

        int index = 0;
        int max1 = arrayList.get(0);

        for (int i = 0; i < arrayList.size() - 1; i++) {
            if (arrayList.get(i + 1) > max1) {
                max1 = arrayList.get(i + 1);
                index = i + 1;
            }
        }

        max.addAll(lists.get(index));

        // Hiển thị chuỗi tăng dần dài nhất
        System.out.println("Chuỗi tăng dần dài nhất là: ");
        for (Character ch : max) { // 1 vòng lặp
            System.out.print(ch); // 1 câu lệnh
        }
    }
}

