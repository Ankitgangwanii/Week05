package com.tit.csvfilehandling.basicproblem.csvreader;


import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;

public class CsvReader {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\ankitgangwani\\OneDrive\\Documents\\Zoom\\CsvFile1.csv";

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] details;
            while ((details = reader.readNext()) != null) {
                System.out.println(details[0] + "\t\t" + details[1] + "\t\t" + details[2] + "\t\t" + details[3]);
            }
        } catch (Exception e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}

