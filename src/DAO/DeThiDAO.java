/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import JDBCHelper.DatabaseConnection;
import Model.DeThi;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author xuant
 */
public class DeThiDAO {

    //hàm trả về danh sách đề thi theo cấp độ
    public static List<DeThi> selectByLevel(String capDo) {
        List<DeThi> list = new ArrayList<>();
        String sql = "select * from DeThi A inner join CapDo B on A.MaCD = B.MaCD where TenCD = ?";
        try (PreparedStatement ps = DatabaseConnection.getDBConnection().prepareStatement(sql)) {
            ps.setString(1, capDo);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new DeThi(rs.getInt("MaDT"), rs.getString("TenDT"), rs.getInt("ThoiGian"), rs.getInt("MaCD")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    //hàm trả về thời gian thi
    public static int getTime(int maDT) {
        int time = 0;
        String sql = "select ThoiGian from DeThi where MaDT =?";
        try (PreparedStatement ps = DatabaseConnection.getDBConnection().prepareStatement(sql)) {
            ps.setInt(1, maDT);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                time = rs.getInt("ThoiGian");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return time;
    }

    //hàm trả về số lượng đề thi
    public static int getCount() {
        int count = -1;
        List<DeThi> list = new ArrayList<>();
        String sql = "select count(*) SoLuong from DeThi";
        try (PreparedStatement ps = DatabaseConnection.getDBConnection().prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                count = rs.getInt("SoLuong");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    //hàm trả về tên đề thi
    public static String getName(int maDT) {
        String res = "";
        String sql = "select TenDT from DeThi where MaDT =?";
        try (PreparedStatement ps = DatabaseConnection.getDBConnection().prepareStatement(sql)) {
            ps.setInt(1, maDT);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                res = rs.getString("TenDT");
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    //hàm trả về mã đề thi
    public static int getID(String tenDT) {
        int res = -1;
        String sql = "select MaDT from DeThi where TenDT =?";
        try (PreparedStatement ps = DatabaseConnection.getDBConnection().prepareStatement(sql)) {
            ps.setString(1, tenDT);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                res = rs.getInt("MaDT");
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    //hàm thêm mới đề thi
    public static boolean insert(DeThi dt) {
        String sql = "insert into dethi values(?, ?, ?, ?)";
        try (PreparedStatement ps = DatabaseConnection.getDBConnection().prepareStatement(sql)) {
            ps.setInt(1, dt.getMaDT());
            ps.setString(2, dt.getTenDT());
            ps.setInt(3, dt.getThoiGian());
            ps.setInt(4, dt.getMaCD());
            int count = ps.executeUpdate();
            return count == 1;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
}
