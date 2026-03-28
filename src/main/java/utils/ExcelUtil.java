package utils;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ExcelUtil {

private static Workbook workbook;
private static Sheet sheet;

public static List<Map<String, String>> getDataAsMap(String filePath, String sheetName) throws IOException {

    FileInputStream fis =new FileInputStream(filePath);
    workbook = WorkbookFactory.create(fis);
    //workbook=new XSSFWorkbook(fis);
    sheet = workbook.getSheet(sheetName);

    List<Map<String, String>> dataList= new ArrayList<>();
    DataFormatter formatter =new DataFormatter();

    //Get header row
    Row headerRow = sheet.getRow(0);
    int colCount = headerRow.getPhysicalNumberOfCells();

    //loop through the rows
    for(int i=1; i<= sheet.getLastRowNum(); i++){
        Row currentRow= sheet.getRow(i);
        if(currentRow == null)
            continue;

        Map<String, String> rowMap= new LinkedHashMap<>();

        for(int j=0; j< colCount; j++){
            String key=formatter.formatCellValue(headerRow.getCell(j));
            String value= formatter.formatCellValue(currentRow.getCell(j));

            rowMap.put(key, value);
        }
        dataList.add(rowMap);
    }
    workbook.close();
    fis.close();
    return dataList;
 }
}

