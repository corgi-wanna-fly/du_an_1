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
public class DeThi {
    private int maDT;
    private String tenDT;
    private int thoiGian;
    private int maCD;

    public DeThi(int maDT, String tenDT, int thoiGian, int maCD) {
        this.maDT = maDT;
        this.tenDT = tenDT;
        this.thoiGian = thoiGian;
        this.maCD = maCD;
    }

    public DeThi() {
    }

    public int getMaDT() {
        return maDT;
    }

    public void setMaDT(int maDT) {
        this.maDT = maDT;
    }

    public String getTenDT() {
        return tenDT;
    }

    public void setTenDT(String tenDT) {
        this.tenDT = tenDT;
    }

    public int getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(int thoiGian) {
        this.thoiGian = thoiGian;
    }

    public int getMaCD() {
        return maCD;
    }

    public void setMaCD(int maCD) {
        this.maCD = maCD;
    }

    @Override
    public String toString() {
        return "DeThi{" + "maDT=" + maDT + ", tenDT=" + tenDT + ", thoiGian=" + thoiGian + ", maCD=" + maCD + '}';
    }
    
}
