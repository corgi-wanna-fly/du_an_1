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
public class KetQua {
    private int maKQ;
    private int soCauDung;
    private Date ngayThucHien;
    private String danhGia;
    private int maTV;
    private int maDT;

    public KetQua() {
    }

    public KetQua(int maKQ, int soCauDung, Date ngayThucHien, String danhGia, int maTV, int maDT) {
        this.maKQ = maKQ;
        this.soCauDung = soCauDung;
        this.ngayThucHien = ngayThucHien;
        this.danhGia = danhGia;
        this.maTV = maTV;
        this.maDT = maDT;
    }

    public int getMaKQ() {
        return maKQ;
    }

    public void setMaKQ(int maKQ) {
        this.maKQ = maKQ;
    }

    public int getSoCauDung() {
        return soCauDung;
    }

    public void setSoCauDung(int soCauDung) {
        this.soCauDung = soCauDung;
    }

    public Date getNgayThucHien() {
        return ngayThucHien;
    }

    public void setNgayThucHien(Date ngayThucHien) {
        this.ngayThucHien = ngayThucHien;
    }

    public String getDanhGia() {
        return danhGia;
    }

    public void setDanhGia(String danhGia) {
        this.danhGia = danhGia;
    }

    public int getMaTV() {
        return maTV;
    }

    public void setMaTV(int maTV) {
        this.maTV = maTV;
    }

    public int getMaDT() {
        return maDT;
    }

    public void setMaDT(int maDT) {
        this.maDT = maDT;
    }
    
}
