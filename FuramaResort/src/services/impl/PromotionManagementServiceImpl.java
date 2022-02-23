package services.impl;

import models.Booking;
import services.IPromotionManagement;
import utils.BookingComparator;
import utils.ReadAndWriteCSVFile;

import java.text.SimpleDateFormat;
import java.util.*;

public class PromotionManagementServiceImpl implements IPromotionManagement {

    Scanner scanner = new Scanner(System.in);

    @Override
    public void displayCustomersUseService() {
        Set<Booking> bookingTreeSet = new TreeSet<>(new BookingComparator());
        bookingTreeSet = ReadAndWriteCSVFile.readBookingTreeSetToCSV(ReadAndWriteCSVFile.BOOKING_FILE);

        System.out.print("Nhập năm cần hiển thị danh sách Booking: ");
        int yearBooking = Integer.parseInt(scanner.nextLine());
        String year = Integer.toString(yearBooking);
        for (Booking booking : bookingTreeSet) {
            if (booking.getStartDay().indexOf(year) > 0 || booking.getEndDay().indexOf(year) > 0) {
                System.out.println(booking);
            }
        }
    }

    @Override
    public void displayCustomersGetVoucher() {

        Set<Booking> bookingTreeSet = ReadAndWriteCSVFile.readBookingTreeSetToCSV(ReadAndWriteCSVFile.BOOKING_FILE);

        Stack<Booking> bookingStack = new Stack<>();
        Map<String, Integer> voucher = new HashMap<>();
        List<Booking> bookingList = new ArrayList<>(bookingTreeSet);


//        bookingTreeSet = ReadAndWriteCSVFile.readBookingTreeSetToCSV(ReadAndWriteCSVFile.BOOKING_FILE);

        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String dateNow = sdf.format(date);
        dateNow = dateNow.substring(3);
        System.out.println("Nhập số lượng voucher khuyến mãi 50%: ");
        int voucher50 = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập số lượng voucher khuyến mãi 20%: ");
        int voucher20 = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập số lượng voucher khuyến mãi 10%: ");
//        int voucher10 = bookingStack.size() - voucher20 - voucher50;
        int voucher10 = Integer.parseInt(scanner.nextLine());
        voucher.put("voucher10", voucher10);
        voucher.put("voucher20", voucher20);
        voucher.put("voucher50", voucher50);
        Collections.sort(bookingList, new BookingComparator());
        for (Booking booking : bookingList) {
            if (booking.getStartDay().substring(3).equals(dateNow) && !booking.getTypeOfService().contains("Room")
                    || booking.getEndDay().substring(3).equals(dateNow)
                    && !booking.getTypeOfService().contains("Room")) {
                bookingStack.add(booking);
            }
        }
        while (true) {
            if (bookingStack.isEmpty()) {
                System.out.println("empty");
                break;
            } else {
                if (voucher.get("voucher10") > 0) {
                    System.out.println(bookingStack.pop() + " : Nhận được voucher 10%");
                    voucher.put("voucher10", voucher.get("voucher10") - 1);
                } else if (voucher.get("voucher20") > 0) {
                    System.out.println(bookingStack.pop() + " : Nhận được voucher 20%");
                    voucher.put("voucher20", voucher.get("voucher20") - 1);
                } else {
                    System.out.println(bookingStack.pop() + " : Nhận được voucher 50%");
                    voucher.put("voucher50", voucher.get("voucher50") - 1);
                }
            }
        }
    }
}
