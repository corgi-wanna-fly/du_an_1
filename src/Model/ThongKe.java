/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import JDBCHelper.DatabaseConnection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author xuant
 */
public class ThongKe {

    private String tenCapDo;
    private int soLuong;

    public ThongKe(String tenCapDo, int soLuong) {
        this.tenCapDo = tenCapDo;
        this.soLuong = soLuong;
    }

    public String getTenCapDo() {
        return tenCapDo;
    }

    public void setTenCapDo(String tenCapDo) {
        this.tenCapDo = tenCapDo;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

}
