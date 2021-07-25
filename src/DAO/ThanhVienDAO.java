/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import JDBCHelper.DatabaseConnection;
import Model.DangKy;
import Model.ThanhVien;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ThanhVienDAO {

    //hàm trả về danh sách thành viên
    public static List<ThanhVien> selectAll() {
        List<ThanhVien> list = new ArrayList<>();
        String sql = "select * from ThanhVien";
        try (PreparedStatement ps = DatabaseConnection.getDBConnection().prepareStatement(sql);
                ResultSet rs = ps.executeQuery();) {
            while (rs.next()) {
                list.add(new ThanhVien(rs.getInt("MaTV"),
                        rs.getString("TaiKhoan"),
                        rs.getString("MatKhau"),
                        rs.getString("HoTen"),
                        rs.getString("GioiTinh"),
                        rs.getString("Email"),
                        rs.getString("HinhAnh"),
                        rs.getInt("MaVT"),
                        rs.getDate("NgayDangKy")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    //hàm trả về ThanhVien từ tài khoản và mật khẩu
    public static ThanhVien selectOne(String taiKhoan, String matKhau) {
        ThanhVien tv = new ThanhVien();
        String sql = "select * from ThanhVien where TaiKhoan = ? and MatKhau = ?";
        try (PreparedStatement ps = DatabaseConnection.getDBConnection().prepareStatement(sql)) {
            ps.setString(1, taiKhoan);
            ps.setString(2, matKhau);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                tv.setMaTV(rs.getInt("MaTV"));
                tv.setTaiKhoan(rs.getString("TaiKhoan"));
                tv.setMatKhau(rs.getString("MatKhau"));
                tv.setHoTen(rs.getString("HoTen"));
                tv.setGioiTinh(rs.getString("GioiTinh"));
                tv.setEmail(rs.getString("Email"));
                tv.setHinhAnh(rs.getString("HinhAnh"));
                tv.setMaVT(rs.getInt("MaVT"));
                tv.setNgayDangKy(rs.getDate("NgayDangKy"));
                return tv;
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //hàm trả về ThanhVien từ tài khoản và mật khẩu
    public static ThanhVien selectById(int id) {
        ThanhVien tv = new ThanhVien();
        String sql = "select * from ThanhVien where MaTV= ?";
        try (PreparedStatement ps = DatabaseConnection.getDBConnection().prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                tv.setMaTV(rs.getInt("MaTV"));
                tv.setTaiKhoan(rs.getString("TaiKhoan"));
                tv.setMatKhau(rs.getString("MatKhau"));
                tv.setHoTen(rs.getString("HoTen"));
                tv.setGioiTinh(rs.getString("GioiTinh"));
                tv.setEmail(rs.getString("Email"));
                tv.setHinhAnh(rs.getString("HinhAnh"));
                tv.setMaVT(rs.getInt("MaVT"));
                tv.setNgayDangKy(rs.getDate("NgayDangKy"));
                return tv;
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //hàm trả về ThanhVien từ tài khoản
    public static ThanhVien selectByUsername(String taiKhoan) {
        ThanhVien tv = new ThanhVien();
        String sql = "select * from ThanhVien where TaiKhoan = ?";
        try (PreparedStatement ps = DatabaseConnection.getDBConnection().prepareStatement(sql)) {
            ps.setString(1, taiKhoan);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                tv.setMaTV(rs.getInt("MaTV"));
                tv.setTaiKhoan(rs.getString("TaiKhoan"));
                tv.setMatKhau(rs.getString("MatKhau"));
                tv.setHoTen(rs.getString("HoTen"));
                tv.setGioiTinh(rs.getString("GioiTinh"));
                tv.setEmail(rs.getString("Email"));
                tv.setHinhAnh(rs.getString("HinhAnh"));
                tv.setMaVT(rs.getInt("MaVT"));
                return tv;
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //hàm update password thành viên
    public static boolean update(String username, String newPass) {
        String sql = "update ThanhVien set MatKhau = ? where TaiKhoan = ?";
        try (PreparedStatement ps = DatabaseConnection.getDBConnection().prepareStatement(sql)) {
            ps.setString(1, newPass);
            ps.setString(2, username);
            int count = ps.executeUpdate();
            return count == 1;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    //hàm insert thành viên
    public static boolean insert(ThanhVien tv) {
        String sql = "insert into ThanhVien values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = DatabaseConnection.getDBConnection().prepareStatement(sql)) {
            ps.setInt(1, tv.getMaTV());
            ps.setString(2, tv.getTaiKhoan());
            ps.setString(3, tv.getMatKhau());
            ps.setString(4, tv.getHoTen());
            ps.setString(5, tv.getGioiTinh());
            ps.setString(6, tv.getEmail());
            ps.setString(7, tv.getHinhAnh());
            ps.setInt(8, tv.getMaVT());
            ps.setDate(9, new java.sql.Date(tv.getNgayDangKy().getTime()));
            int i = ps.executeUpdate();
            return i == 1;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //hàm xóa thành viên theo id
    public static boolean delete(int maTV) {
        String sql = "exec Usp_DeleteMember ?";
        try (CallableStatement cs = DatabaseConnection.getDBConnection().prepareCall(sql)) {
            cs.setInt(1, maTV);
            int count = cs.executeUpdate();
            return count != 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    //hàm trả về mã thành viên cuối cùng
    public static int getMaTV() {
        int res = -1;
        String sql = "select MaTV from ThanhVien order by MaTV desc";
        try (PreparedStatement ps = DatabaseConnection.getDBConnection().prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                res = rs.getInt("MaTV");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    //hàm trả về danh sách số lượng thành viên đăng kí theo tháng
    public static List<DangKy> getDangKy() {
        List<DangKy> list = new ArrayList<>();
        String sql = "exec Usp_ThongKeDangKy";
        try (PreparedStatement ps = DatabaseConnection.getDBConnection().prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(new DangKy(rs.getInt("Thang"), rs.getInt("SoLuong")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    //update tv
    public static boolean update(ThanhVien tv) {
        int count = -1;
        String sql = "update ThanhVien set TaiKhoan=?,  MatKhau=?, HoTen=?, GioiTinh = ?, Email=?, HinhAnh=? where MaTV=?";
        try (PreparedStatement ps = DatabaseConnection.getDBConnection().prepareStatement(sql)) {
            ps.setString(1, tv.getTaiKhoan());
            ps.setString(2, tv.getMatKhau());
            ps.setString(3, tv.getHoTen());
            ps.setString(4, tv.getGioiTinh());
            ps.setString(5, tv.getEmail());
            ps.setString(6, tv.getHinhAnh());
            ps.setInt(7, tv.getMaTV());
            count = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count == 1;
    }

    public static void writeData(Sheet sheet, List<ThanhVien> list) {
        if (list != null) {
            int len = list.size();
            for (int i = 0; i < len; i++) {
                ThanhVien tv = list.get(i);
                Row row = sheet.createRow(1 + i);
                Cell cell = row.createCell(0);
                cell.setCellValue(i + 1);

                cell = row.createCell(1);
                cell.setCellValue(tv.getHoTen());

                cell = row.createCell(2);
                cell.setCellValue(tv.getGioiTinh());

                cell = row.createCell(3);
                cell.setCellValue(tv.getEmail());

                cell = row.createCell(4);
                cell.setCellValue(tv.getHinhAnh());

                cell = row.createCell(5);
                cell.setCellValue(tv.getNgayDangKy().toString());
            }
        }
    }

    public static void writeHeader(Sheet sheet, int rowIndex) {
        //create Cellstyle
        Row row = sheet.createRow(rowIndex);

        CellStyle cellStyle = createStyleForHeader(sheet);
        //create cells
        Cell cell = row.createCell(0);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("STT");

        cell = row.createCell(1);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Họ tên");

        cell = row.createCell(2);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Giới tính");

        cell = row.createCell(3);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Email");

        cell = row.createCell(4);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Hình ảnh");

        cell = row.createCell(5);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Ngày đăng ký");
    }

    public static void writeFile(String path, XSSFWorkbook workbook) {
        try {
            File file = new File(path);
            FileOutputStream fos = new FileOutputStream(file);
            workbook.write(fos);
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static CellStyle createStyleForHeader(Sheet sheet) {
        // Create font
        Font font = sheet.getWorkbook().createFont();
        font.setFontName("Times New Roman");
        font.setBold(true);
        font.setFontHeightInPoints((short) 14); // font size
        font.setColor(IndexedColors.WHITE.getIndex()); // text color

        // Create CellStyle
        CellStyle cellStyle = sheet.getWorkbook().createCellStyle();
        cellStyle.setFont(font);
        cellStyle.setFillForegroundColor(IndexedColors.BLUE.getIndex());
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cellStyle.setBorderBottom(BorderStyle.THIN);
        return cellStyle;
    }

    // Auto resize column width
    public static void autosizeColumn(Sheet sheet, int lastColumn) {
        for (int columnIndex = 0; columnIndex < lastColumn; columnIndex++) {
            sheet.autoSizeColumn(columnIndex);
        }
    }

    public static void main(String[] args) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Thành viên");

        List<ThanhVien> list = selectAll();
        //create header
        writeHeader(sheet, 0);
        //create data
        writeData(sheet, list);
        int num = sheet.getRow(0).getPhysicalNumberOfCells();
        autosizeColumn(sheet, num);
        //ghi file
        final String path = "E:/thanhvien.xlsx";
        writeFile(path, workbook);
    }
}
