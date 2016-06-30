/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mitracomm.pa.core;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author MECC
 */
public class DataProcessor {

    public static ArrayList<ArrayList<String>> finalResult = new ArrayList<>();
    public static String[][] finalResultArray;

    public static void doProcessingType4(HashMap<String, String> idAndName, ArrayList<ArrayList<String>> inputData) {

        String id = inputData.get(0).get(0); // Variable for saving id to identify id of the compared data (ID Flag)
        String dateMark1 = inputData.get(0).get(1); // Variable for saving date mark to identify date mark of the compared data (date mark Flag)
        String datetime1 = inputData.get(0).get(2);// Variable for saving datetie to identify datetime of the compared data (datetime Flag)
        String prevDatetime = ""; // Variable for saving previous datetime worked with
        String initialDatetime = datetime1; //Variable for saving initial dateitme, before comparing process.
        int index = 1; // Pointer to traverse through data
        int diffHours = 0; // Variable for saving the sum of time gap

        while (index < inputData.size()) { //Traversing through the data is begun

            //Getting the essential information from the current data
            String id2 = inputData.get(index).get(0); //Getting id to id2
            String dateMark2 = inputData.get(index).get(1); //Getting dateMark to dateMark2
            String datetime2 = inputData.get(index).get(2); //Getting datetime to datetime2
            //System.out.println("Currently in here --> "+datetime2);
            //Check if the ID is same as the current one.
            if (id.equals(id2)) {

                //Check date difference, if it is less or equal with 1, the it pass.
                int dateDiff = dateComparator(dateMark1, dateMark2);

                if (dateDiff == 1 || dateDiff < 1) {

                    int tempDiffHours = datetimeComparatorType3(datetime1, datetime2);

                    if (tempDiffHours < 8) {
                        //For debugging purpose only
                        //System.out.println("id = "+id+" || "+datetime1+" || "+datetime2+" || "+diffHours+" || -- "+tempDiffHours+" || scenario zzz");
                        diffHours += tempDiffHours;
                    } else {
                        
                        printResultType3(id, initialDatetime, prevDatetime, diffHours);
                        //For debugging purpose only
                        //System.out.println("diffHours = "+diffHours);
                        initialDatetime = datetime2;
                        dateMark1 = dateMark2;
                        diffHours = 0;
                       
                    }
                } //For date gap more than one day 
                else {
                    printResultType3(id, initialDatetime, prevDatetime, diffHours);
                    //For debugging purpose only
                    //System.out.println("diffHours = "+diffHours);
                    initialDatetime = datetime2;
                    dateMark1 = dateMark2;
                    diffHours = 0;
                }

            } // For Different ID
            else {
                printResultType3(id, initialDatetime, prevDatetime, diffHours);
                //For debugging purpose only
                //System.out.println("diffHours = "+diffHours);
                id = id2;
                initialDatetime = datetime2;
                dateMark1 = dateMark2;
                diffHours = 0;
            }
            index++;
            datetime1 = datetime2;
            prevDatetime = datetime2;

        }
        
        convertFinalResultToFinalResultArray(idAndName);
        
        //Print the result *For debugging only or log purpose*
        /*for(ArrayList<String> data: finalResult){
            System.out.println(data);
        }*/
    }

    public static void printResultType2(String id, String initialDatetime, String prevDatetime, int diffHours) {

        //dateComparator(String comparatedDate1, String comparatedDate2)
        String date1 = initialDatetime.substring(0, 6);
        String date2 = prevDatetime.substring(0, 6);
        int result = dateComparator(date1, date2);

        if (result == 1) {

            String datetimeMark = "00:00:00";
            String scenario = "secnario lintas hari";

            if (diffHours > 7) {
                datetimeMark = "------------";
                scenario = "scenario hilang";
            }

            System.out.println("id = " + id + " || " + initialDatetime + " || " + datetimeMark + " || " + diffHours + " || " + scenario);
            System.out.println("id = " + id + " || " + datetimeMark + " || " + prevDatetime + " || " + diffHours + " || " + scenario);
        } else if (initialDatetime.equals(prevDatetime)) {

            System.out.println("id = " + id + " || " + initialDatetime + " ||------------------ || " + diffHours + " || scenario hilang");
        } else {
            System.out.println("id = " + id + " || " + initialDatetime + " || " + prevDatetime + " || " + diffHours + " || scenario 1");
        }
    }

    //public static ArrayList<String> printResultType3(String id, String initialDatetime, String prevDatetime, int diffHours) {
    public static void printResultType3(String id, String initialDatetime, String prevDatetime, int diffHours) {

        String date1 = initialDatetime.substring(0, 6);
        String date2 = prevDatetime.substring(0, 6);
        int comparingResult = dateComparator(date1, date2);

        if (comparingResult == 1) {

            String datetimeMark = "00:00:00";
            String scenario = "secnario lintas hari";

            if (diffHours > 7) {
                datetimeMark = "------------";
                scenario = "scenario hilang";
            }

            //For debuggng purpose only
            //System.out.println("id = " + id + " || " + initialDatetime + " || " + datetimeMark + " || " + diffHours + " || " + scenario);
            //System.out.println("id = " + id + " || " + datetimeMark + " || " + prevDatetime + " || " + diffHours + " || " + scenario);

            ArrayList<String> array1 = new ArrayList<>();
            array1.add(id);
            array1.add(initialDatetime);
            array1.add(datetimeMark);
            array1.add(String.valueOf(diffHours));
            array1.add(scenario);
            //System.out.println("arrayResult -- >"+ array1);
            ArrayList<String> array2 = new ArrayList<>();
            array2.add(id);
            array2.add(datetimeMark);
            array2.add(prevDatetime);
            array2.add(String.valueOf(diffHours));
            array2.add(scenario);
           
            finalResult.add(array1);
            finalResult.add(array2);

        } else {
            ArrayList<String> array1 = new ArrayList<>();
            String scenario = "scenario 1";
            if(initialDatetime.equals(prevDatetime)) {
            
            prevDatetime = "------------";
            scenario = "scenario hilang";
            
            //For debugging purpose only
            //System.out.println("id = " + id + " || " + initialDatetime + " ||------------------ || " + diffHours + " || scenario hilang");
            
            }
            else {
            //For debugging purpose only    
            //System.out.println("id = " + id + " || " + initialDatetime + " || " + prevDatetime + " || " + diffHours + " || scenario 1");
            
            }
            array1.add(id);
            array1.add(initialDatetime);
            array1.add(prevDatetime);
            array1.add(String.valueOf(diffHours));
            array1.add(scenario);
            
            finalResult.add(array1);

        }
    }

    public static void doProcessingTest(HashMap<String, String> idAndName, ArrayList<ArrayList<String>> inputData) {
        /*System.out.println("Hasil Test dateComparator baru -->" + datetimeComparatorType2("4/4/16 16:28:30", "5/4/16 20:00:00")
                + " -- Converted --> " + datetimeComparatorType3("4/4/16 16:28:30", "5/4/16 20:00:00"));

        System.out.println("Hasil Test dateComparator baru -->" + datetimeComparatorType2("4/4/16 16:28:30", "5/4/16 12:00:00")
                + " -- Converted --> " + datetimeComparatorType3("4/4/16 16:28:30", "5/4/16 12:00:00"));

        System.out.println("Hasil Test dateComparator baru -->" + datetimeComparatorType2("4/4/16 16:28:30", "10/5/17 20:00:00")
                + " -- Converted --> " + datetimeComparatorType3("4/4/16 16:28:30", "10/5/17 20:00:00"));

        System.out.println("Hasil Test dateComparator baru -->" + datetimeComparatorType2("4/4/16 7:28:50", "4/4/16 15:28:50")
                + " -- Converted --> " + datetimeComparatorType3("4/4/16 7:28:50", "4/4/16 15:28:50"));*/
        
        System.out.println("Hasil Test dateComparator liat kesini!!! -->" + datetimeComparatorType2("1/4/16 9:29:20", "1/4/16 17:9:20")
                + " -- Converted --> " + datetimeComparatorType3("1/4/16 9:29:20", "1/4/16 17:9:20"));
        String date = "4/4/16 7:28:50";
        System.out.println("Coba substring -- >" + date + " || result = " + date.substring(0, 6));
        //System.out.println("Hasil Test dateComparator -->"+datetimeComparatorType2( "4/4/16 20:28:30", "5/4/16 16:00:00" ));
    }

    public static void doProcessingType5(HashMap<String, String> idAndName, ArrayList<ArrayList<String>> inputData) {
        //public static ArrayList<ArrayList<String>> doProcessingType4(ArrayList<ArrayList<String>> nameAndId, ArrayList<ArrayList<String>> inputData) {

        //Storage for working variables
        HashMap<String, String> cv = new HashMap<>();

        String id = inputData.get(0).get(0); // Variable for saving id to identify id of the compared data (ID Flag)
        String dateMark1 = inputData.get(0).get(1); // Variable for saving date mark to identify date mark of the compared data (date mark Flag)
        String datetime1 = inputData.get(0).get(2);// Variable for saving datetie to identify datetime of the compared data (datetime Flag)
        String prevDatetime = ""; // Variable for saving previous datetime worked with
        boolean lintasHari = false; // Flag for indicating if a data is consist of two dates
        boolean lompat = false; // Flag for showing the pointer "index" should jump according to certain rules.
        int index = 1; // Pointer to traverse through data
        int diffHours = 0; // Variable for saving the sum of time gap

        while (index < inputData.size()) { //Traversing through the data is begun

            String id2 = inputData.get(index).get(0);
            String dateMark2 = inputData.get(index).get(1);
            String datetime2 = inputData.get(index).get(2);

            //If the ID is same as the current one.
            if (id.equals(id2) && lintasHari == false) {

                //If the current date mark is same as previous date mark.
                if (dateMark1.equals(dateMark2)) {

                    //If the diffHours has been already more than 7 hours.
                    if (diffHours > 6) {

                        //Insert diffHours, datetime1, prevDatetime, id to finalResult
                        finalResult.add(subContentFinalResult(id, datetime1, prevDatetime, diffHours, "scenario 1"));

                        //Clear diffHours
                        //Insert datetime2 to datetime1
                        //Insert dateMark2 to datemark1
                        diffHours = 0;
                        datetime1 = datetime2;
                        dateMark1 = dateMark2;

                        index++;
                    } //If the diffHours is less than 7 hours
                    else {

                        //Update prevDatetime to current datetime
                        diffHours = datetimeComparator(datetime1, datetime2);
                        prevDatetime = datetime2;

                        //if the pointer is near the end of inputData, 
                        //the sum of time gap should be written on arrayList regardless it is under or above the approved limit
                        if ((index + 1) == inputData.size()) {
                            finalResult.add(subContentFinalResult(id, datetime1, prevDatetime, diffHours, "scenario ujung"));
                        }
                        index++;

                    }

                } //If the current date mark isn't equal as previous date mark
                else {

                    String lintasHariMark = dateMark2 + " 00:00:00";
                    int tempDiffHours = datetimeComparator(datetime1, lintasHariMark);

                    if (diffHours < 6 && tempDiffHours < 6) {

                        finalResult.add(subContentFinalResult(id, datetime1, lintasHariMark, tempDiffHours, "scenario lintas hari"));

                        int tempDiffHours2 = datetimeComparator(lintasHariMark, datetime2);
                        diffHours = tempDiffHours + tempDiffHours2;
                        finalResult.add(subContentFinalResult(id, lintasHariMark, datetime2, diffHours, "scenario lintas hari"));
                        lintasHari = true;
                        lompat = true;

                    } else {

                        finalResult.add(subContentFinalResult(id, datetime1, prevDatetime, diffHours, "scenario 3"));
                        diffHours = 0;
                    }

                    datetime1 = datetime2;
                    dateMark1 = dateMark2;
                    //index += 2;
                    index++;
                }

            } //If the ID is different with the current ID.
            else {

                if (lompat == true) {

                    index++;
                    lompat = false;
                } else {

                    finalResult.add(subContentFinalResult(id, datetime1, prevDatetime, diffHours, "scenario 4"));

                    id = id2;
                    //index += 2;
                    index += 1;
                }

                diffHours = 0;
                datetime1 = datetime2;
                dateMark1 = dateMark2;
                lintasHari = false;

            }
        }
        convertFinalResultToFinalResultArray(idAndName);
        //Print the result *For debugging only or log purpose*
        /*for(ArrayList<String> data: finalResult){
            System.out.println(data);
        }*/
    }

    private static void convertFinalResultToFinalResultArray(HashMap<String, String> idAndName) {
        
        System.out.println("Mampir kesini loh");
        finalResultArray = new String[finalResult.size()][5];

        int i = 0;
        for (ArrayList<String> data : finalResult) {

            finalResultArray[i][0] = idAndName.get(data.get(0)); //Name
            finalResultArray[i][1] = data.get(0); //ID
            finalResultArray[i][2] = data.get(1); //In
            finalResultArray[i][3] = data.get(2); //Out
            finalResultArray[i][4] = data.get(3); //Name
            //For Debuging only
            //System.out.println(idAndName.get(data.get(0)) + " || " + data.get(0) + " || " + data.get(1) + " || " + data.get(2) + " ||" + data.get(3));
            i++;
        }

    }

    //private static ArrayList<String> subContentFinalResult(String id, String datetime1, String prevDatetime, int diffHous){
    private static ArrayList<String> subContentFinalResult(String id, String datetime1, String prevDatetime, int diffHous, String scenario) {
        ArrayList<String> result = new ArrayList<>();

        result.add(id);
        result.add(datetime1);
        result.add(prevDatetime);
        result.add(String.valueOf(diffHous));
        result.add(scenario);

        return result;
    }

    private static ArrayList<String> finalResultInsertorType2(ArrayList<String> finalResult,
            String id, String datetime1, String prevDatetime, int diffHours) {

        finalResult.add(id);
        finalResult.add(datetime1);
        finalResult.add(prevDatetime);
        finalResult.add(String.valueOf(diffHours));

        return finalResult;

    }

    private static HashMap<String, String> cvInsertorType2(HashMap<String, String> cv, String id, String datemark, String datetime) {
        cv.put("id", id);
        cv.put("datemark", datemark);
        cv.put("datetime1", datetime);
        cv.put("prevDatetime", " ");

        return cv;
    }

    private static ArrayList<String> finalResultInsertorType1(ArrayList<String> finalResult,
            String id, String datetime1, String prevDatetime, int diffHours) {

        finalResult.add(id);
        finalResult.add(datetime1);
        finalResult.add(prevDatetime);
        finalResult.add(String.valueOf(diffHours));

        return finalResult;

    }

    private static String[] cvInsertorType1(String[] cv, String id, String datemark, String datetime) {

        cv[0] = id;
        cv[1] = datemark;
        cv[2] = datetime;
        cv[3] = "";

        return cv;
    }

    private static int datetimeComparator(String comparatedDatetime1, String comparatedDatetime2) {
        int result = 0;

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yy HH:mm:ss");

        try {
            Date datetime1 = format.parse(comparatedDatetime1);
            Date datetime2 = format.parse(comparatedDatetime2);

            //in milliseconds
            long diff = datetime2.getTime() - datetime1.getTime();

            /*long diffSeconds = diff / 1000 % 60;
            long diffMinutes = diff / (60 * 1000) % 60;
            long diffHours = diff / (60 * 60 * 1000) % 24;
            long diffDays = diff / (24 * 60 * 60 * 1000);

            System.out.print(diffDays + " days, ");
            System.out.print(diffHours + " hours, ");
            System.out.print(diffMinutes + " minutes, ");
            System.out.print(diffSeconds + " seconds.");*/
            result = (int) diff / (60 * 60 * 1000) % 24;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    private static String datetimeComparatorType2(String comparatedDatetime1, String comparatedDatetime2) {
        String result = "";

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yy HH:mm:ss");

        try {
            Date datetime1 = format.parse(comparatedDatetime1);
            Date datetime2 = format.parse(comparatedDatetime2);

            //in milliseconds
            long diff = datetime2.getTime() - datetime1.getTime();

            long diffSeconds = diff / 1000 % 60;
            long diffMinutes = diff / (60 * 1000) % 60;
            long diffHours = diff / (60 * 60 * 1000) % 24;
            long diffDays = diff / (24 * 60 * 60 * 1000);

            /*System.out.print(diffDays + " days, ");
            System.out.print(diffHours + " hours, ");
            System.out.print(diffMinutes + " minutes, ");
            System.out.print(diffSeconds + " seconds.");*/
            result = diffDays + " days " + diffHours + " hours" + diffMinutes + " minutes " + diffSeconds + " seconds";
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    private static int datetimeComparatorType3(String comparatedDatetime1, String comparatedDatetime2) {
        int result = 0;

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yy HH:mm:ss");

        try {
            Date datetime1 = format.parse(comparatedDatetime1);
            Date datetime2 = format.parse(comparatedDatetime2);

            //in milliseconds
            long diff = datetime2.getTime() - datetime1.getTime();

            long diffSeconds = diff / 1000 % 60;
            long diffMinutes = diff / (60 * 1000) % 60;
            long diffHours = diff / (60 * 60 * 1000) % 24;
            long diffDays = diff / (24 * 60 * 60 * 1000);

            /*System.out.print(diffDays + " days, ");
            System.out.print(diffHours + " hours, ");
            System.out.print(diffMinutes + " minutes, ");
            System.out.print(diffSeconds + " seconds.");*/
            int convertedDays = (int) diffDays * 24;
            int convertedHours = (int) diffHours;
            result = convertedDays + convertedHours;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    private static int dateComparator(String comparatedDate1, String comparatedDate2) {
        int result = 0;

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yy");

        try {
            Date date1 = format.parse(comparatedDate1);
            Date date2 = format.parse(comparatedDate2);

            long diff = date2.getTime() - date1.getTime();

            result = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

}
