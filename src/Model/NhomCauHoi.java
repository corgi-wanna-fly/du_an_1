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
public class NhomCauHoi {
    private int maNCH;
    private String tenNCH;
    private String NoiDung;

    public NhomCauHoi() {
    }

    public NhomCauHoi(int maNCH, String tenNCH, String NoiDung) {
        this.maNCH = maNCH;
        this.tenNCH = tenNCH;
        this.NoiDung = NoiDung;
    }

    public int getMaNCH() {
        return maNCH;
    }

    public void setMaNCH(int maNCH) {
        this.maNCH = maNCH;
    }

    public String getTenNCH() {
        return tenNCH;
    }

    public void setTenNCH(String tenNCH) {
        this.tenNCH = tenNCH;
    }

    public String getNoiDung() {
        return NoiDung;
    }

    public void setNoiDung(String NoiDung) {
        this.NoiDung = NoiDung;
    }

    @Override
    public String toString() {
        return "NhomCauHoi{" + "maNCH=" + maNCH + ", tenNCH=" + tenNCH + ", NoiDung=" + NoiDung + '}';
    }
    
}
