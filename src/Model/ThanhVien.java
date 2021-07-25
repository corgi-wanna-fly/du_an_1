/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author xuant
 */
public class ThanhVien {
    private int maTV;
    private String taiKhoan;
    private String matKhau;
    private String hoTen;
    private String gioiTinh;
    private String email;
    private String hinhAnh;
    private int maVT;
    private Date ngayDangKy;

    public ThanhVien() {
    }

    public ThanhVien(int maTV, String taiKhoan, String matKhau, String hoTen, String gioiTinh, String email, String hinhAnh, int maVT, Date ngayDangKy) {
        this.maTV = maTV;
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.email = email;
        this.hinhAnh = hinhAnh;
        this.maVT = maVT;
        this.ngayDangKy = ngayDangKy;
    }
    

    public int getMaTV() {
        return maTV;
    }

    public void setMaTV(int maTV) {
        this.maTV = maTV;
    }

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public int getMaVT() {
        return maVT;
    }

    public void setMaVT(int maVT) {
        this.maVT = maVT;
    }

    public Date getNgayDangKy() {
        return ngayDangKy;
    }

    public void setNgayDangKy(Date ngayDangKy) {
        this.ngayDangKy = ngayDangKy;
    }

    @Override
    public String toString() {
        return "ThanhVien{" + "maTV=" + maTV + ", taiKhoan=" + taiKhoan + ", matKhau=" + matKhau + ", hoTen=" + hoTen + ", gioiTinh=" + gioiTinh + ", email=" + email + ", hinhAnh=" + hinhAnh + ", maVT=" + maVT + ", ngayDangKy=" + ngayDangKy + '}';
    }

    
}
