package org.example;
import java.time.LocalDate;

public class SinhVien {
    private String maSV, hoTen, nganh, lop;
    private LocalDate ngaySinh;
    private double diemTB;

    public SinhVien(String maSV, String hoTen, LocalDate ngaySinh, String nganh, double diemTB, String lop) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.nganh = nganh;
        this.diemTB = diemTB;
        this.lop = lop;
    }

    public String getMaSV() { return maSV; }
    public String getHoTen() { return hoTen; }
    public LocalDate getNgaySinh() { return ngaySinh; }
    public String getNganh() { return nganh; }
    public double getDiemTB() { return diemTB; }
    public String getLop() { return lop; }

    @Override
    public String toString() {
        return String.format("%-12s | %-20s | %-12s | %-6s | %-5.1f | %-10s",
                maSV, hoTen, ngaySinh, nganh, diemTB, lop);
    }
}
