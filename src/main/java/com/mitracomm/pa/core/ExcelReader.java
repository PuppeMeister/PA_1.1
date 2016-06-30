/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitracomm.pa.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author MECC
 */
public class ExcelReader {
    
    static ArrayList<ArrayList<String>> nameAndId = new ArrayList<>();
    static ArrayList<ArrayList<String>> inputData = new ArrayList<>();
    static HashMap<String, String> idAndName = new HashMap<>();
    
    public static void read(String filePath) throws FileNotFoundException{
        
        try (FileInputStream inputStream = new FileInputStream(new File(filePath))) {
            
            Workbook workbook = new XSSFWorkbook(inputStream);
            Sheet firstSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = firstSheet.iterator();
            
            while (iterator.hasNext()) {
                Row nextRow = iterator.next();
                
                Iterator<Cell> cellIterator = nextRow.cellIterator();
                
                ArrayList<String> subArray = new ArrayList<>();
                ArrayList<String> subArray2 = new ArrayList<>();
                
                while (cellIterator.hasNext()) {
                    
                    
                    Cell nameCell = cellIterator.next();
                    Cell idCell = cellIterator.next();
                    Cell dateCell = cellIterator.next();
                    Cell timeCell = cellIterator.next();
                    
                    subArray.add(getValuesFromCell(nameCell));
                    subArray.add(getValuesFromCell(idCell));
                    
                    subArray2.add(getValuesFromCell(idCell));
                    subArray2.add(getValuesFromCell(dateCell));
                    subArray2.add(getValuesFromCell(dateCell) +" "+ getValuesFromCell(timeCell));
                 
                }
                
                nameAndId.add(subArray);
                inputData.add(subArray2);
            }

            workbook.close();
        } catch (IOException ex) {
            Logger.getLogger(ExcelReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //System.out.println("Baru");
        nameAndId = reduceRedudance(nameAndId);
        idAndName = getNameAndId(nameAndId);
        inputData.remove((int)0);
    
    }
    
    private static String getValuesFromCell(Cell cell){
        
        String result = "";
        switch (cell.getCellType()) {
            
                        case Cell.CELL_TYPE_STRING:
                            result = cell.getStringCellValue();
                            break;
                            
                        case Cell.CELL_TYPE_NUMERIC:
                            
                            //result =  String.valueOf(cell.getNumericCellValue());
                            result =  String.format("%.0f", cell.getNumericCellValue());
                            
                            break;
                            
                    }
        
        return result;
    }
    
    private static ArrayList<ArrayList<String>> reduceRedudance(ArrayList<ArrayList<String>> data){
        
        data.remove((int)0);
        String comparatedId = data.get(0).get(1);
        int index = 1;
        
        while(index < data.size()){
           
            String id = data.get(index).get(1);
            if(comparatedId.equals(id)){
                data.remove((int) index);
            }
            else{
                comparatedId = id;
                index++;
            }
        }
        
        return data;
    }
    
    private static HashMap<String, String> getNameAndId(ArrayList<ArrayList<String>> inputData){
        HashMap<String, String> result = new HashMap<>();
        
        for(ArrayList<String> data : inputData){
            String key = data.get(1);
            String value = data.get(0);
            result.put(key, value);
        }
        return result;
    } 
}
