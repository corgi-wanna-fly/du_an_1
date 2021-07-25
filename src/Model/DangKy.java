/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author xuant
 */
public class DangKy {
    private int thang;
    private int soLuong;

    public DangKy() {
    }

    public DangKy(int thang, int soLuong) {
        this.thang = thang;
        this.soLuong = soLuong;
    }

    public int getThang() {
        return thang;
    }

    public void setThang(int thang) {
        this.thang = thang;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    @Override
    public String toString() {
        return "DangKy{" + "thang=" + thang + ", soLuong=" + soLuong + '}';
    }
    
}
