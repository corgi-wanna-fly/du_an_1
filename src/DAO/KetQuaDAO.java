/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import JDBCHelper.DatabaseConnection;
import Model.KetQua;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author xuant
 */
public class KetQuaDAO {

    //hàm trả về danh sách kết quả theo ma tv
    public static List<KetQua> selectAll(int maTV) {
        List<KetQua> list = new ArrayList<>();
        String sql = "select * from KetQua where MaTV =?";
        try (PreparedStatement ps = DatabaseConnection.getDBConnection().prepareStatement(sql)) {
            ps.setInt(1, maTV);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new KetQua(rs.getInt("MaKQ"),
                        rs.getInt("SoCauDung"),
                        rs.getDate("NgayThucHien"),
                        rs.getString("DanhGia"),
                        rs.getInt("MaTV"),
                        rs.getInt("MaDT")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    //hàm trả về số lần thi đạt
    public static int count(int maTV) {
        int res = 0;
        String sql = "select count(*) SoLanDat from KetQua where MaTV = ? and SoCauDung >= 25";
        try (PreparedStatement ps = DatabaseConnection.getDBConnection().prepareStatement(sql)) {
            ps.setInt(1, maTV);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                res = rs.getInt("SoLanDat");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    //hàm lưu kết quả vào cơ sở dữ liệu
    public static void insert(KetQua kq) {
        String sql = "insert into KetQua values(?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = DatabaseConnection.getDBConnection().prepareStatement(sql)) {
            ps.setInt(1, kq.getMaKQ());
            ps.setInt(2, kq.getSoCauDung());
            ps.setDate(3, new java.sql.Date(kq.getNgayThucHien().getTime()));
            ps.setString(4, kq.getDanhGia());
            ps.setInt(5, kq.getMaTV());
            ps.setInt(6, kq.getMaDT());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //hàm trả về mã kq cuối cùng
    public static int lastResultID() {
        int count = -1;
        String sql = "select * from KetQua order by MaKQ desc";
        try (PreparedStatement ps = DatabaseConnection.getDBConnection().prepareStatement(sql);
                ResultSet rs = ps.executeQuery();) {
            
            if (rs.next()) {
                count = rs.getInt("MaKQ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }
    
    //xóa kết quả
    public static void delete(int id){
        String sql = "delete from KetQua where MaKQ = ?";
        try(PreparedStatement ps = DatabaseConnection.getDBConnection().prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
   
}
