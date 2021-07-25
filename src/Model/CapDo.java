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
public class CapDo {
    private int maCD;
    private String tenCD;
    private String moTa;

    public CapDo() {
    }

    public CapDo(int maCD, String tenCD, String moTa) {
        this.maCD = maCD;
        this.tenCD = tenCD;
        this.moTa = moTa;
    }

    public int getMaCD() {
        return maCD;
    }

    public void setMaCD(int maCD) {
        this.maCD = maCD;
    }

    public String getTenCD() {
        return tenCD;
    }

    public void setTenCD(String tenCD) {
        this.tenCD = tenCD;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    @Override
    public String toString() {
        return "CapDo{" + "maCD=" + maCD + ", tenCD=" + tenCD + ", moTa=" + moTa + '}';
    }
    
}
