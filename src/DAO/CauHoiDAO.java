/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import JDBCHelper.DatabaseConnection;
import Model.CauHoi;
import Model.ThanhVien;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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

/**
 *
 * @author xuant
 */
public class CauHoiDAO {

    //hàm trả về mã đề thi ngẫu nhiên trong cấp độ
    public static int getExamId(String capDo) {
        List<Integer> listIntegers = new ArrayList<>();
        String sql = "select A.* from DeThi A inner join CapDo B on A.MaCD = B.MaCD where B.TenCD =?";
        try (PreparedStatement ps = DatabaseConnection.getDBConnection().prepareStatement(sql)) {
            ps.setString(1, capDo);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listIntegers.add(rs.getInt("MaDT"));
            }
            if (listIntegers.size() == 0) {
                return -1;
            } else {
                Random rd = new Random();
                int x = rd.nextInt(listIntegers.size());
                return listIntegers.get(x);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    //hàm lấy danh sách câu hỏi theo độ khó
    public static List<CauHoi> selectAll(int maDT, String capDo, int maNCH) {
        List<CauHoi> list = new ArrayList<CauHoi>();
        String sql = "select * from CauHoi where MaDT = ? and CapDo = ? and MaNCH = ?";
        try (PreparedStatement ps = DatabaseConnection.getDBConnection().prepareStatement(sql);) {
            ps.setInt(1, maDT);
            ps.setString(2, capDo);
            ps.setInt(3, maNCH);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new CauHoi(rs.getInt("MaCH"),
                        rs.getString("DoanVan"),
                        rs.getString("AmThanh"),
                        rs.getString("NoiDungCH"),
                        rs.getString("DapAnA"),
                        rs.getString("DapAnB"),
                        rs.getString("DapAnC"),
                        rs.getString("DapAnD"),
                        rs.getString("DapAnDung"),
                        rs.getString("CapDo"),
                        rs.getInt("MaDT"),
                        rs.getInt("MaLCH"),
                        rs.getInt("MaNCH")));
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /*
        Hàm lấy về danh sách câu hỏi đề thi Reading
            i. 20 Easy- 10 Medium- 5 Hard
            ii. Câu hỏi random trong bộ câu hỏi
     */
    public static List<CauHoi> selectReading(int maDT) {
        //tạo list chưa danh sách câu hỏi
        List<CauHoi> list = new ArrayList<>();
        //tạo list chưa danh sách câu hỏi Easy
        List<CauHoi> listEasy = selectAll(maDT, "Easy", 1);
        //tạo list chưa danh sách câu hỏi Medium
        List<CauHoi> listMedium = selectAll(maDT, "Medium", 1);
        //tạo list chưa danh sách câu hỏi Hard
        List<CauHoi> listHard = selectAll(maDT, "Hard", 1);
        /*
            thêm 20 câu hỏi dễ vào list
                i. lấy 1 list random 25 số
                2. thêm vào danh sách
         */
        int lenEasy = listEasy.size();
        List<Integer> randomEasy = randomList(lenEasy, 25);
        for (int i = 0; i < randomEasy.size(); i++) {
            list.add(listEasy.get(randomEasy.get(i)));
        }
        /*
            thêm 10 câu hỏi trung bình vào list
                i. lấy 1 list random 10 số
                2. thêm vào danh sách
         */
        int lenMedium = listMedium.size();
        List<Integer> randomMedium = randomList(lenMedium, 10);
        for (int i = 0; i < randomMedium.size(); i++) {
            list.add(listMedium.get(randomMedium.get(i)));
        }
        /*
            thêm 5 câu hỏi khó vào list
                i. lấy 1 list random 5 số
                2. thêm vào danh sách
         */
        int lenHard = listHard.size();
        List<Integer> randomHard = randomList(lenHard, 5);
        for (int i = 0; i < randomHard.size(); i++) {
            list.add(listHard.get(randomHard.get(i)));
        }
        return list;
    }

    /*
        Hàm lấy về danh sách câu hỏi đề thi Reading
            i. 5 Easy- 3 Medium- 2 Hard
            ii. Câu hỏi random trong bộ câu hỏi
     */
    public static List<CauHoi> selectListening(int maDT) {
        //tạo list chưa danh sách câu hỏi
        List<CauHoi> list = new ArrayList<>();
        //tạo list chưa danh sách câu hỏi Easy
        List<CauHoi> listEasy = selectAll(maDT, "Easy", 2);
        //tạo list chưa danh sách câu hỏi Medium
        List<CauHoi> listMedium = selectAll(maDT, "Medium", 2);
        //tạo list chưa danh sách câu hỏi Hard
        List<CauHoi> listHard = selectAll(maDT, "Hard", 2);
        /*
            thêm 5 câu hỏi dễ vào list
                i. lấy 1 list random 5 số
                2. thêm vào danh sách
         */
        int lenEasy = listEasy.size();
        List<Integer> randomEasy = randomList(lenEasy, 5);
        for (int i = 0; i < randomEasy.size(); i++) {
            list.add(listEasy.get(randomEasy.get(i)));
        }
        /*
            thêm 3 câu hỏi trung bình vào list
                i. lấy 1 list random 3 số
                2. thêm vào danh sách
         */
        int lenMedium = listMedium.size();
        List<Integer> randomMedium = randomList(lenMedium, 3);
        for (int i = 0; i < randomMedium.size(); i++) {
            list.add(listMedium.get(randomMedium.get(i)));
        }
        /*
            thêm 2 câu hỏi khó vào list
                i. lấy 1 list random 2 số
                2. thêm vào danh sách
         */
        int lenHard = listHard.size();
        List<Integer> randomHard = randomList(lenHard, 2);
        for (int i = 0; i < randomHard.size(); i++) {
            list.add(listHard.get(randomHard.get(i)));
        }
        return list;
    }

    //hàm lấy list random
    public static List<Integer> randomList(int max, int count) {
        List<Integer> list = new ArrayList<>();
        Random rd = new Random();
        while (list.size() < count) {
            int x = rd.nextInt(max);
            boolean flag = false;
            for (int i : list) {
                if (x == i) {
                    flag = true;
                }
            }
            if (!flag) {
                list.add(x);
            }
        }
        return list;
    }

    public static List<CauHoi> getList(String tenDT, String tenNCH) {
        List<CauHoi> list = new ArrayList<>();
        String sql = "exec Usp_CauH ?, ?";
        try (CallableStatement cs = DatabaseConnection.getDBConnection().prepareCall(sql)) {
            cs.setString(1, tenDT);
            cs.setString(2, tenNCH);
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                list.add(new CauHoi(rs.getInt("MaCH"),
                        rs.getString("DoanVan"),
                        rs.getString("AmThanh"),
                        rs.getString("NoiDungCH"),
                        rs.getString("DapAnA"),
                        rs.getString("DapAnB"),
                        rs.getString("DapAnC"),
                        rs.getString("DapAnD"),
                        rs.getString("DapAnDung"),
                        rs.getString("CapDo"),
                        rs.getInt("MaDT"),
                        rs.getInt("MaLCH"),
                        rs.getInt("MaNCH")));
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static String getTenLCH(int maLCH) {
        String res = "";
        String sql = "select TenLCH from LoaiCauHoi where MaLCH =?";
        try (PreparedStatement ps = DatabaseConnection.getDBConnection().prepareStatement(sql)) {
            ps.setInt(1, maLCH);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                res = rs.getString("TenLCH");
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    //ham them cau hoi
    public static void insert(CauHoi ch) {
        String sql = "insert into CauHoi values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = DatabaseConnection.getDBConnection().prepareStatement(sql)) {
            ps.setInt(1, ch.getMaCH());
            ps.setString(2, ch.getDoanVan());
            ps.setString(3, ch.getAmThanh());
            ps.setString(4, ch.getNoiDungCH());
            ps.setString(5, ch.getDapAnA());
            ps.setString(6, ch.getDapAnB());
            ps.setString(7, ch.getDapAnC());
            ps.setString(8, ch.getDapAnD());
            ps.setString(9, ch.getDapAnDung());
            ps.setString(10, ch.getCapDo());
            ps.setInt(11, ch.getMaDT());
            ps.setInt(12, ch.getMaLCH());
            ps.setInt(13, ch.getMaNCH());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //ham xoa cau hoi
    public static void delete(int maCH) {
        int count = -1;
        String sql = "exec Usp_DeleteQuestion ?";
        try (CallableStatement cs = DatabaseConnection.getDBConnection().prepareCall(sql)) {
            cs.setInt(1, maCH);
            cs.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //ham sua cau hoi
    public static void update(CauHoi ch) {
        String sql = "update CauHoi set DoanVan=?, AmThanh=?, NoiDungCH=?, DapAnA=?, DapAnB=?, DapAnC=?, DapAnD=?, DapAnDung=?, CapDo=? where MaCH=?";
        try (PreparedStatement ps = DatabaseConnection.getDBConnection().prepareStatement(sql)) {
            ps.setString(1, ch.getDoanVan());
            ps.setString(2, ch.getAmThanh());
            ps.setString(3, ch.getNoiDungCH());
            ps.setString(4, ch.getDapAnA());
            ps.setString(5, ch.getDapAnB());
            ps.setString(6, ch.getDapAnC());
            ps.setString(7, ch.getDapAnD());
            ps.setString(8, ch.getDapAnDung());
            ps.setString(9, ch.getCapDo());
            ps.setInt(10, ch.getMaCH());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //hàm lấy mã ch cuối cùng
    public static int getLastId() {
        int res = -1;
        String sql = "select * from CauHoi order by MaCH desc";
        try (PreparedStatement ps = DatabaseConnection.getDBConnection().prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                res = rs.getInt("MaCH");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    //hàm lấy mã ch cuối cùng
    public static CauHoi getCauHoi(int maCH) {
        String sql = "select * from CauHoi where MaCH=?";
        try (PreparedStatement ps = DatabaseConnection.getDBConnection().prepareStatement(sql);) {
            ps.setInt(1, maCH);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                CauHoi cauHoi = new CauHoi(rs.getInt("MaCH"),
                        rs.getString("DoanVan"),
                        rs.getString("AmThanh"),
                        rs.getString("NoiDungCH"),
                        rs.getString("DapAnA"),
                        rs.getString("DapAnB"),
                        rs.getString("DapAnC"),
                        rs.getString("DapAnD"),
                        rs.getString("DapAnDung"),
                        rs.getString("CapDo"),
                        rs.getInt("MaDT"),
                        rs.getInt("MaLCH"),
                        rs.getInt("MaNCH"));
                return cauHoi;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void writeHeader(Sheet sheet, int rowIndex) {
        //create Cellstyle
        Row row = sheet.createRow(rowIndex);

        CellStyle cellStyle = createStyleForHeader(sheet);
        //create cells
        Cell cell = row.createCell(0);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Mã CH");

        cell = row.createCell(1);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Đoạn văn");

        cell = row.createCell(2);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Âm thanh");

        cell = row.createCell(3);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Nội Dung CH");

        cell = row.createCell(4);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Đáp án A");

        cell = row.createCell(5);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Đáp án B");

        cell = row.createCell(6);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Đáp án C");

        cell = row.createCell(7);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Đáp án D");

        cell = row.createCell(8);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Đáp án đúng");

        cell = row.createCell(9);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Cấp độ");

        cell = row.createCell(10);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Mã đề thi");

        cell = row.createCell(11);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Loại câu hỏi");

        cell = row.createCell(12);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("Nhóm câu hỏi");
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

    public static void writeData(Sheet sheet, List<CauHoi> list) {
        if (list != null) {
            int len = list.size();
            for (int i = 0; i < len; i++) {
                CauHoi ch = list.get(i);
                Row row = sheet.createRow(1 + i);
                Cell cell = row.createCell(0);
                cell.setCellValue(ch.getMaCH() + 320);

                cell = row.createCell(1);
                cell.setCellValue(ch.getDoanVan());

                cell = row.createCell(2);
                cell.setCellValue(ch.getAmThanh());

                cell = row.createCell(3);
                cell.setCellValue(ch.getNoiDungCH());

                cell = row.createCell(4);
                cell.setCellValue(ch.getDapAnA());

                cell = row.createCell(5);
                cell.setCellValue(ch.getDapAnB());

                cell = row.createCell(6);
                cell.setCellValue(ch.getDapAnC());

                cell = row.createCell(7);
                cell.setCellValue(ch.getDapAnD());

                cell = row.createCell(8);
                cell.setCellValue(ch.getDapAnDung());

                cell = row.createCell(9);
                cell.setCellValue(ch.getCapDo());

                cell = row.createCell(10);
                cell.setCellValue(ch.getMaDT() + 4);

                cell = row.createCell(11);
                cell.setCellValue(ch.getMaLCH());

                cell = row.createCell(12);
                cell.setCellValue(ch.getMaNCH());
            }
        }
    }

    public static void main(String[] args) {
        try {
            List<CauHoi> list = new ArrayList<>();
            String sql = "Select * from CauHoi where MaDT = 4";
            try (PreparedStatement ps = DatabaseConnection.getDBConnection().prepareStatement(sql);
                    ResultSet rs = ps.executeQuery();) {
                while (rs.next()) {
                    list.add(new CauHoi(rs.getInt("MaCH"),
                            rs.getString("DoanVan"),
                            rs.getString("AmThanh"),
                            rs.getString("NoiDungCH"),
                            rs.getString("DapAnA"),
                            rs.getString("DapAnB"),
                            rs.getString("DapAnC"),
                            rs.getString("DapAnD"),
                            rs.getString("DapAnDung"),
                            rs.getString("CapDo"),
                            rs.getInt("MaDT"),
                            rs.getInt("MaLCH"),
                            rs.getInt("MaNCH")));
                }
                rs.close();

                XSSFWorkbook workbook = new XSSFWorkbook();
                XSSFSheet sheet = workbook.createSheet("Tiếng Anh 2.2");
                //create header
                writeHeader(sheet, 0);
                //create data
                writeData(sheet, list);
                int num = sheet.getRow(0).getPhysicalNumberOfCells();
                autosizeColumn(sheet, num);
                //ghi file
                final String path = "E:/cauhoi2.2.xlsx";
                writeFile(path, workbook);
            } catch (Exception e) {
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
