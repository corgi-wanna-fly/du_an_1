/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import JDBCHelper.DatabaseConnection;
import Model.NhomCauHoi;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author xuant
 */
public class NhomCauHoiDAO {
    //hàm trả về danh sách nhóm câu hỏi
    public static List<NhomCauHoi> selectAll(){
        List<NhomCauHoi> list = new ArrayList<>();
        String sql = "select * from NhomCauHoi";
        try(PreparedStatement ps = DatabaseConnection.getDBConnection().prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {
            while(rs.next()){
                list.add(new NhomCauHoi(rs.getInt("MaNCH"), rs.getString("TenNCH"), rs.getString("NoiDung")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
