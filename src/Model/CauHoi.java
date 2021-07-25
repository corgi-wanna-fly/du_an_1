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
public class CauHoi {
    private int maCH;
    private String doanVan, amThanh, noiDungCH, dapAnA, dapAnB, dapAnC, dapAnD, dapAnDung, capDo;
    private int maDT, maLCH, maNCH;

    public CauHoi() {
    }

    public CauHoi(int maCH, String doanVan, String amThanh, String noiDungCH, String dapAnA, String dapAnB, String dapAnC, String dapAnD, String dapAnDung, String capDo, int maDT, int maLCH, int maNCH) {
        this.maCH = maCH;
        this.doanVan = doanVan;
        this.amThanh = amThanh;
        this.noiDungCH = noiDungCH;
        this.dapAnA = dapAnA;
        this.dapAnB = dapAnB;
        this.dapAnC = dapAnC;
        this.dapAnD = dapAnD;
        this.dapAnDung = dapAnDung;
        this.capDo = capDo;
        this.maDT = maDT;
        this.maLCH = maLCH;
        this.maNCH = maNCH;
    }

    public int getMaCH() {
        return maCH;
    }

    public void setMaCH(int maCH) {
        this.maCH = maCH;
    }

    public String getDoanVan() {
        return doanVan;
    }

    public void setDoanVan(String doanVan) {
        this.doanVan = doanVan;
    }

    public String getAmThanh() {
        return amThanh;
    }

    public void setAmThanh(String amThanh) {
        this.amThanh = amThanh;
    }

    public String getNoiDungCH() {
        return noiDungCH;
    }

    public void setNoiDungCH(String noiDungCH) {
        this.noiDungCH = noiDungCH;
    }

    public String getDapAnA() {
        return dapAnA;
    }

    public void setDapAnA(String dapAnA) {
        this.dapAnA = dapAnA;
    }

    public String getDapAnB() {
        return dapAnB;
    }

    public void setDapAnB(String dapAnB) {
        this.dapAnB = dapAnB;
    }

    public String getDapAnC() {
        return dapAnC;
    }

    public void setDapAnC(String dapAnC) {
        this.dapAnC = dapAnC;
    }

    public String getDapAnD() {
        return dapAnD;
    }

    public void setDapAnD(String dapAnD) {
        this.dapAnD = dapAnD;
    }

    public String getDapAnDung() {
        return dapAnDung;
    }

    public void setDapAnDung(String dapAnDung) {
        this.dapAnDung = dapAnDung;
    }

    public String getCapDo() {
        return capDo;
    }

    public void setCapDo(String capDo) {
        this.capDo = capDo;
    }

    public int getMaDT() {
        return maDT;
    }

    public void setMaDT(int maDT) {
        this.maDT = maDT;
    }

    public int getMaLCH() {
        return maLCH;
    }

    public void setMaLCH(int maLCH) {
        this.maLCH = maLCH;
    }

    public int getMaNCH() {
        return maNCH;
    }

    public void setMaNCH(int maNCH) {
        this.maNCH = maNCH;
    }

    @Override
    public String toString() {
        return "CauHoi{" + "maCH=" + maCH + ", doanVan=" + doanVan + ", amThanh=" + amThanh + ", noiDungCH=" + noiDungCH + ", dapAnA=" + dapAnA + ", dapAnB=" + dapAnB + ", dapAnC=" + dapAnC + ", dapAnD=" + dapAnD + ", dapAnDung=" + dapAnDung + ", capDo=" + capDo + ", maDT=" + maDT + ", maLCH=" + maLCH + ", maNCH=" + maNCH + '}';
    }
    public static void main(String[] args) {
        double d = 321.0;
        System.out.println((int)d);
    }
}
