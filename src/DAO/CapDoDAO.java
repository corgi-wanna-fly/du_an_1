/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import JDBCHelper.DatabaseConnection;
import Model.CapDo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author xuant
 */
public class CapDoDAO {
    //hàm lấy về danh sách cấp độ đề thi

    public static List<CapDo> selectAll() {
        List<CapDo> list = new ArrayList<>();
        String sql = "select * from CapDo";
        try (PreparedStatement ps = DatabaseConnection.getDBConnection().prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(new CapDo(rs.getInt("MaCD"), rs.getString("TenCD"), rs.getString("MoTa")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    //hàm trả về tên cấp độ từ mã đề thi
    public static String getLevel(int maDT) {
        String res = "";
        String sql = "select TenCD from CapDo A inner join DeThi B on A.MaCD = B.MaCD where MaDT =?";
        try(PreparedStatement ps = DatabaseConnection.getDBConnection().prepareStatement(sql)) {
            ps.setInt(1, maDT);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                res =  rs.getString("TenCD");
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

}
