package utils;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;

public class ExcelDataProvider {
    public  static Object[][] getExcelData(String path, String sheetName){

        System.out.println("Reading data from sheet:"+sheetName);
        FileInputStream fis;
        Workbook workbook;
        Object data[][]=null;
        try {
            fis=new FileInputStream(path);
            workbook= WorkbookFactory.create(fis);
            Sheet sheet=workbook.getSheet(sheetName);
            int rowNum=sheet.getLastRowNum();
            int colNum=sheet.getRow(0).getLastCellNum();
            data=new Object[rowNum][colNum];
            for(int i=0;i<rowNum;i++) {
                for(int j=0;j<colNum;j++) {
                    data[i][j]=sheet.getRow(i+1).getCell(j).toString();
                    System.out.print( data[i][j] +"---");
                }
                System.out.println(" ");
            }

        }catch(Exception ex) {
            ex.printStackTrace();
        }
        return data;
    }
}
