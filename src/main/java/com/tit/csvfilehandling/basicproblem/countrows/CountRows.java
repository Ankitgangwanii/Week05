package com.tit.csvfilehandling.basicproblem.countrows;
import com.opencsv.CSVReader;
import java.io.FileReader;

public class CountRows {
    public static void main(String[] args) {
        String file_Path = "C:\\Users\\ankitgangwani\\OneDrive\\Documents\\Zoom\\Csvwriter.csv";
        try (CSVReader reader = new CSVReader(new FileReader(file_Path))) {
            int count = 0;
            while (reader.readNext() != null) {
                count++;
            }
            System.out.println(count - 1); // Subtract 1 if the first row is a header
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
