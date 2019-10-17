import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class XLUtils {
    public static FileInputStream fi;
    public static FileOutputStream fo;
    public static XSSFWorkbook wb;
    public static XSSFSheet ws;
    public static XSSFRow row;
    public static XSSFCell cell;

    public static int getRowCount(String xlfile, String xlsheet) throws IOException {
        fi = new FileInputStream(xlfile);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(xlsheet);
        int rowcount = ws.getLastRowNum();
        wb.close();
        fi.close();
        return rowcount;
    }

    public static int getCellCount(String xlfile, String xlsheet, int row_num) throws IOException {
        fi = new FileInputStream(xlfile);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(xlsheet);
        row = ws.getRow(row_num);
        int cellcount = row.getLastCellNum();
        wb.close();
        fi.close();
        return cellcount;
    }

    public static String getCellData(String xlfile, String xlsheet, int row_num, int col_num) throws IOException {
        fi = new FileInputStream(xlfile);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(xlsheet);
        row = ws.getRow(row_num);
        cell = row.getCell(col_num);
        String data;
        try{
            DataFormatter formatter = new DataFormatter();
            String celldata = formatter.formatCellValue(cell);
            return celldata;
        }
        catch (Exception e){
            data = "";
        }
        wb.close();
        fi.close();
        return data;
    }

    public static void setCellData(String xlfile, String xlsheet, int row_num, int col_num, String data) throws IOException {
        fi = new FileInputStream(xlfile);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(xlsheet);
        row = ws.getRow(row_num);
        cell = row.createCell(col_num);
        cell.setCellValue(data);
        fo = new FileOutputStream(xlfile);
        wb.write(fo);
        wb.close();
        fi.close();
        fo.close();
    }
}
