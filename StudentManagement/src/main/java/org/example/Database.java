package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {
    private static final String URL = "jdbc:mysql://localhost:3306/quanlysinhvien";
    private static final String USER = "root";
    private static final String PASS = "123456";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Không tìm thấy Driver!");
        }
        return DriverManager.getConnection(URL, USER, PASS);
    }

    public static String chuanHoaTen(String ten) {
        if (ten == null || ten.isEmpty()) return "";
        String[] words = ten.trim().toLowerCase().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (String w : words) {
            sb.append(Character.toUpperCase(w.charAt(0))).append(w.substring(1)).append(" ");
        }
        return sb.toString().trim();
    }

    public static void insertSV(SinhVien sv) {
        String sql = "INSERT INTO sinh_vien VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, sv.getMaSV());
            ps.setString(2, sv.getHoTen());
            ps.setDate(3, Date.valueOf(sv.getNgaySinh()));
            ps.setString(4, sv.getNganh());
            ps.setDouble(5, sv.getDiemTB());
            ps.setString(6, sv.getLop());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Lỗi khi thêm: " + e.getMessage());
        }
    }

    public static void deleteSV(String maSV) {
        String sql = "DELETE FROM sinh_vien WHERE ma_sv = ?";
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, maSV);
            int rows = ps.executeUpdate();
            if (rows > 0) System.out.println("Xóa thành công sinh viên: " + maSV);
            else System.out.println("Không tìm thấy mã sinh viên để xóa.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateSV(String maSV, double diemMoi, String lopMoi) {
        String sql = "UPDATE sinh_vien SET diem_tb = ?, lop_sinh_hoat = ? WHERE ma_sv = ?";
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDouble(1, diemMoi);
            ps.setString(2, lopMoi);
            ps.setString(3, maSV);
            int rows = ps.executeUpdate();
            if (rows > 0) System.out.println("Cập nhật thông tin thành công!");
            else System.out.println("Không tìm thấy mã sinh viên.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<SinhVien> getList(String condition) {
        List<SinhVien> list = new ArrayList<>();
        String sql = "SELECT * FROM sinh_vien " + condition;
        try (Connection conn = getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new SinhVien(
                        rs.getString("ma_sv"),
                        rs.getString("ho_ten"),
                        rs.getDate("ngay_sinh").toLocalDate(),
                        rs.getString("nganh_dao_tao"),
                        rs.getDouble("diem_tb"),
                        rs.getString("lop_sinh_hoat")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Lỗi truy vấn: " + e.getMessage());
        }
        return list;
    }
}