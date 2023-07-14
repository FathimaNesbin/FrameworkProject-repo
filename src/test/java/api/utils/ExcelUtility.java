package api.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
public class ExcelUtility {

    private String filePath;
    private String sheetName;
    private Workbook workbook;
    private Sheet sheet;

    public ExcelUtility(String filePath, String sheetName) throws IOException {
        this.filePath = filePath;
        this.sheetName = sheetName;
        FileInputStream fis = new FileInputStream(filePath);
        this.workbook = new XSSFWorkbook(fis);
        this.sheet = workbook.getSheet(sheetName);
    }

    public List<List<String>> readData() {
        List<List<String>> data = new ArrayList<>();

        Iterator<Row> rowIterator = sheet.iterator();

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            List<String> rowData = new ArrayList<>();

            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                rowData.add(cell.toString());
            }

            data.add(rowData);
        }

        return data;
    }

    public void writeData(List<List<String>> data) throws IOException {
        int rowCount = 0;

        for (List<String> rowData : data) {
            Row row = sheet.getRow(rowCount);
            if (row == null)
                row = sheet.createRow(rowCount);

            int columnCount = 0;
            for (String cellData : rowData) {
                Cell cell = row.getCell(columnCount);
                if (cell == null)
                    cell = row.createCell(columnCount);
                cell.setCellValue(cellData);
                columnCount++;
            }

            rowCount++;
        }

        FileOutputStream fos = new FileOutputStream(filePath);
        workbook.write(fos);
        workbook.close();
        fos.close();
    }
}
