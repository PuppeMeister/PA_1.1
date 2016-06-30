/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitracomm.pa.core;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author MECC
 */
public class MainController {
    
    //public static void doControlling(String filePath) throws FileNotFoundException{
    public static String[][] doControlling(String filePath) throws FileNotFoundException{    
        
        ExcelReader.read(filePath);
        DataProcessor.doProcessingType4(ExcelReader.idAndName, ExcelReader.inputData);
        String[][] controllingResult = DataProcessor.finalResultArray;
        System.out.println("Final Result");
         
        return controllingResult;
        
    }
    
    public static void doControllingVoid(String filePath)throws FileNotFoundException{
        //This method is for debugging only
        
        ExcelReader.read(filePath);
        DataProcessor.doProcessingType4(ExcelReader.idAndName, ExcelReader.inputData);
        //DataProcessor.doProcessingTest(ExcelReader.idAndName, ExcelReader.inputData);
        
    }
    
    public static void getResultInExcel(String savedFilePath){
        ExcelWriter.writeToExcel(DataProcessor.finalResultArray, savedFilePath);
    }
    
    private static String[][] returnedResult(ArrayList<ArrayList<String>> convertedData, HashMap<String, String> idAndName){
        String[][] result = new String[convertedData.size()][5];
        
        int i = 0;
        for(ArrayList<String> data : convertedData){
            
            result[i][0] = idAndName.get(data.get(0)); //Name
            result[i][1] = data.get(0); //ID
            result[i][2] = data.get(1); //In
            result[i][3] = data.get(2); //Out
            result[i][4] = data.get(3); //Name
            //For Debuging only
            System.out.println(idAndName.get(data.get(0)) +" || "+data.get(0)+" || "+ data.get(1)+" || "+data.get(2)+" ||" +data.get(3));
            i++;
        }
        
        return result;
    }
}
