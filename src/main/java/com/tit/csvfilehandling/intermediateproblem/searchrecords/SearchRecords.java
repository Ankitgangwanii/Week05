package com.tit.csvfilehandling.intermediateproblem.searchrecords;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.Scanner;

public class SearchRecords {
    public static void main(String[] args) {
        String file_Path="C:\\Users\\ankitgangwani\\OneDrive\\Documents\\Zoom\\SearchRecord.csv";
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Name to Search");
        String name = sc.next();
        try(CSVReader reader = new CSVReader(new FileReader(file_Path))){
            String[] line;
            int departmentIndex=0,salaryIndex = 0,nameIndex = 0;
            boolean header=true;
            while((line = reader.readNext())!=null){
                if(header){
                    for(int i = 0;i<line.length;i++){
                        if(line[i].equalsIgnoreCase("department")){
                            departmentIndex = i;
                        }
                        if(line[i].equalsIgnoreCase("salary")){
                            salaryIndex = i;
                        }
                        if(line[i].equalsIgnoreCase("name")){
                            nameIndex = i;
                        }
                        header = false;
                        continue;
                    }
                }
                if(line[nameIndex].equalsIgnoreCase(name)){
                    System.out.println("Name :"+line[nameIndex]+" \nDepartment :"+line[departmentIndex]+"\nSalary :"+line[salaryIndex]);
                }
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
