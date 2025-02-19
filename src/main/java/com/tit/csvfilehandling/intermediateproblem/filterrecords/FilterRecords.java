package com.tit.csvfilehandling.intermediateproblem.filterrecords;

import com.opencsv.CSVReader;
import com.tit.csvfilehandling.basicproblem.csvreader.CsvReader;

import java.io.FileReader;

public class FilterRecords {
    public static void main(String[] args) {
        String file_Path = "C:\\Users\\ankitgangwani\\OneDrive\\Documents\\Zoom\\CsvFile1.csv";
        try(CSVReader reader = new CSVReader(new FileReader(file_Path))){
            String[] line;
            boolean header = true;
            int index=0;
            while((line = reader.readNext())!= null){
                if(header){
                    header = false;
                for(int i = 0;i<line.length;i++){
                    if(line[i].equalsIgnoreCase("marks")){
                        index=i;
                        break;
                    }
                }
                continue;
                }
                if(Integer.parseInt(line[index])>80){
                    for(int i=0;i<line.length;i++){
                    System.out.print(line[i]+"\t\t");
                }
                    System.out.println("");
            }
        }
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}


