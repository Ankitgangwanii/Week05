package com.tit.csvfilehandling.basicproblem.csvwriter;

import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CsvWriter {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\ankitgangwani\\OneDrive\\Documents\\Zoom\\Csvwriter.csv";
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Number of Attributes:");
        int n = sc.nextInt();
        String[] attribute = new String[n];
        System.out.println("Enter the Attributes of Your Table:");
        for (int i = 0; i < n; i++) {
            attribute[i] = sc.next();
        }

        System.out.println("Enter Number of Data Rows you want to add:");
        int rows = sc.nextInt();
        String[][] data = new String[rows][n];
        System.out.println("Enter the Data for Each Row:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < n; j++) {
                data[i][j] = sc.next();
            }
        }


        try ( CSVWriter writer = new CSVWriter(new FileWriter(filePath),
                CSVWriter.DEFAULT_SEPARATOR,
                CSVWriter.NO_QUOTE_CHARACTER,
                CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                CSVWriter.DEFAULT_LINE_END);) {
            // Write attribute row
            writer.writeNext(attribute);
            // Write each data row
            for (int i = 0; i < rows; i++) {
                writer.writeNext(data[i]);
            }
            System.out.println("CSV file has been written successfully!");
        } catch (Exception e) {
            System.out.println("Error writing to the file: " + e.getMessage());
        }
    }
}
