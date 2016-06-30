/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitracomm.pa.core;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author MECC
 */
public class ExcelWriter {

    public static void writeToExcel(String[][] data, String savedFilePath) {

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Final Result Absen");
        
        String[][] header = {{"Nama", "ID", "Masuk", "Keluar", "Jumlah Jam"}};
        String[][] newData = (String[][])ArrayUtils.addAll(header, data);
       
        int rowCount = 0;

        for (Object[] aBook : newData) {
            Row row = sheet.createRow(rowCount);

            int columnCount = 0;

            for (Object field : aBook) {
                Cell cell = row.createCell(columnCount);
                if (field instanceof String) {
                    cell.setCellValue((String) field);
                } else if (field instanceof Integer) {
                    cell.setCellValue((Integer) field);
                }
                
                columnCount++;
            }
            rowCount++;
        }

        try (FileOutputStream outputStream = new FileOutputStream(savedFilePath)) {
            workbook.write(outputStream);
        } catch (IOException ex) {
            Logger.getLogger(ExcelWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

