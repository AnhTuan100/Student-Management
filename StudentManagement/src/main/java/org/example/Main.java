package org.example;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        while (true) {
            System.out.println("QUẢN LÝ SINH VIÊN\n");
            System.out.println("1. Thêm SV | 2. Xem tất cả | 3. Lọc theo lớp | 4. Lọc theo tháng sinh | 5. Sắp xếp điểm | 0. Thoát");
            System.out.print("Chọn: ");
            int chon = Integer.parseInt(sc.nextLine());

            if (chon == 0) break;

            switch (chon) {
                case 1:
                    System.out.print("Ngành (CNTT/KTPM): ");
                    String nganh = sc.nextLine().toUpperCase();
                    if (!nganh.equals("CNTT") && !nganh.equals("KTPM")) {
                        System.out.println("Ngành không hợp lệ!"); break;
                    }

                    System.out.print("Mã SV (10 số): ");
                    String ma = sc.nextLine();
                    if (!ma.matches("\\d{10}") || (nganh.equals("CNTT") && !ma.startsWith("455105")) || (nganh.equals("KTPM") && !ma.startsWith("455109"))) {
                        System.out.println("Mã SV không đúng định dạng ngành!");
                        break;
                    }

                    System.out.print("Họ tên: ");
                    String ten = Database.chuanHoaTen(sc.nextLine());

                    System.out.print("Ngày sinh (dd/MM/yyyy): ");
                    LocalDate ns = LocalDate.parse(sc.nextLine(), dtf);
                    int tuoi = Period.between(ns, LocalDate.now()).getYears();
                    if (tuoi < 15 || tuoi > 110) {
                        System.out.println("Tuổi không hợp lệ!"); break;
                    }

                    System.out.print("Điểm TB (0-10): ");
                    double diem = Double.parseDouble(sc.nextLine());
                    if (diem < 0 || diem > 10) {
                        System.out.println("Điểm không hợp lệ!"); break;
                    }

                    System.out.print("Lớp sinh hoạt: ");
                    String lop = sc.nextLine();

                    Database.insertSV(new SinhVien(ma, ten, ns, nganh, diem, lop));
                    System.out.println("Thêm thành công!");
                    break;

                case 2:
                    Database.getList("").forEach(System.out::println);
                    break;

                case 4:
                    System.out.print("Nhập tháng: ");
                    int t = Integer.parseInt(sc.nextLine());
                    Database.getList("WHERE MONTH(ngay_sinh) = " + t).forEach(System.out::println);
                    break;

                case 5:
                    Database.getList("ORDER BY diem_tb DESC").forEach(System.out::println);
                    break;
            }
        }
    }
}