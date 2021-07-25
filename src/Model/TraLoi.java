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
public class TraLoi {
    private int maKQ;
    private String dapAnChon;
    private String dapAnDung;
    private int maTV;
    private int maCH;

    public TraLoi() {
    }

    
    public TraLoi(int maKQ, String dapAnChon, String dapAnDung, int maTV, int maCH) {
        this.maKQ = maKQ;
        this.dapAnChon = dapAnChon;
        this.dapAnDung = dapAnDung;
        this.maTV = maTV;
        this.maCH = maCH;
    }

    public int getMaKQ() {
        return maKQ;
    }

    public void setMaKQ(int maKQ) {
        this.maKQ = maKQ;
    }

   

   

    public String getDapAnChon() {
        return dapAnChon;
    }

    public void setDapAnChon(String dapAnChon) {
        this.dapAnChon = dapAnChon;
    }

    public String getDapAnDung() {
        return dapAnDung;
    }

    public void setDapAnDung(String dapAnDung) {
        this.dapAnDung = dapAnDung;
    }

    public int getMaTV() {
        return maTV;
    }

    public void setMaTV(int maTV) {
        this.maTV = maTV;
    }

    public int getMaCH() {
        return maCH;
    }

    public void setMaCH(int maCH) {
        this.maCH = maCH;
    }

    @Override
    public String toString() {
        return "TraLoi{" + "maKQ=" + maKQ + ", dapAnChon=" + dapAnChon + ", dapAnDung=" + dapAnDung + ", maTV=" + maTV + ", maCH=" + maCH + '}';
    }

   
   
}
