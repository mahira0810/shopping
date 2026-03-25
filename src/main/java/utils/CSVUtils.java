package utils;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CSVUtils {

    //Read entire CSV as list of String Arrays
    public static List<String> readALlData(String filePath){

        List<String> data= new ArrayList<>();

        try(CSVReader reader=new CSVReader(new FileReader(filePath))){
            String[] line;
            while ((line = reader.readNext()) != null){
                data.add(Arrays.toString(line));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return data;
    }

    //Read CSV as List of Map (Header -> value
    public static List<Map<String, String>> readAsMap(String filePath){

        List<Map<String, String>> dataList = new ArrayList<>();

        try(CSVReader reader =new CSVReader(new FileReader(filePath))){
            String[] headers= reader.readNext();//first row as a header
            String[] row;

            while((row =reader.readNext()) != null){
            Map<String, String> dataMap= new HashMap<>();
            for(int i=0; i < headers.length; i++){
                dataMap.put(headers[i], row[i]);
            }
            dataList.add(dataMap);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
        return dataList;
    }

    //Get specific cell value from CSV file
    public static String getCSVCellValue(String filePath, int rowNum, int colNum){

        try(CSVReader reader =new CSVReader(new FileReader(filePath))){
            List<String[]> allData= reader.readAll();

            return allData.get(rowNum)[colNum];
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
