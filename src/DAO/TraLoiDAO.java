/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import JDBCHelper.DatabaseConnection;
import Model.TraLoi;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author xuant
 */
public class TraLoiDAO {
    

    //hàm thêm traloi vào csdl
    public static void insert(TraLoi tl){
        String sql = "insert into TraLoi values(?, ?, ?)";
        try(PreparedStatement ps = DatabaseConnection.getDBConnection().prepareStatement(sql)) {
            ps.setInt(1, tl.getMaKQ());
            ps.setInt(2, tl.getMaCH());
            ps.setString(3, tl.getDapAnChon());        
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
