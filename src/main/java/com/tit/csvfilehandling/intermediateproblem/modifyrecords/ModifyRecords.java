package com.tit.csvfilehandling.intermediateproblem.modifyrecords;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.tit.csvfilehandling.basicproblem.csvwriter.CsvWriter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;

public class ModifyRecords {
    public static void main(String[] args) {
        String file_Path1 = "C:\\Users\\ankitgangwani\\OneDrive\\Documents\\Zoom\\SearchRecord.csv";
        String file_Path2 ="C:\\Users\\ankitgangwani\\OneDrive\\Documents\\Zoom\\UpdatedData.csv";
        try(CSVReader reader = new CSVReader(new FileReader(file_Path1));
            CSVWriter writer = new CSVWriter(new FileWriter(file_Path2),
                    CSVWriter.DEFAULT_SEPARATOR,
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END);
        ){
            String[] line;
            boolean header = true;
            int indexSalary=0;
            int indexDepartment=0;
            while((line = reader.readNext())!=null){
                if(header){
                    for(int i = 0;i<line.length;i++){
                        if(line[i].equalsIgnoreCase("salary")){
                            indexSalary = i;
                        }
                        if(line[i].equalsIgnoreCase("department")){
                            indexDepartment = i;
                        }
                    }
                    header = false;
                    continue;
                }
                if(line[indexDepartment].equalsIgnoreCase("IT")){
                    int temp = (int) (Integer.parseInt(line[indexSalary])+Integer.parseInt(line[indexSalary]) * 0.1);
                    line[indexSalary] = String.valueOf(temp);
                  //  System.out.println(line[indexSalary]);
                }
                System.out.println(Arrays.toString(line));
                writer.writeNext(line);
                }

        } catch (Exception e) {
            System.out.println(e);
        }
        }
    }


