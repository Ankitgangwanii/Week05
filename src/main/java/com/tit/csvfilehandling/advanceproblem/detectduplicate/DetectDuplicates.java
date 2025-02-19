package com.tit.csvfilehandling.advanceproblem.detectduplicate;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class DetectDuplicates {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\ankitgangwani\\OneDrive\\Documents\\Zoom\\duplicatecsv.csv";
        Map<String, List<String[]>> recordMap = new HashMap<>();

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] header = reader.readNext();
            if (header == null) {
                System.out.println("CSV file is empty.");
                return;
            }

            int idIndex = -1;
            for (int i = 0; i < header.length; i++) {
                if (header[i].equalsIgnoreCase("ID")) {
                    idIndex = i;
                    break;
                }
            }

            if (idIndex == -1) {
                System.out.println("ID column not found in the CSV file.");
                return;
            }

            String[] row;
            while ((row = reader.readNext()) != null) {
                String id = row[idIndex];
                recordMap.computeIfAbsent(id, k -> new ArrayList<>()).add(row);
            }

            boolean duplicatesFound = false;
            System.out.println("Duplicate records based on ID:");
            for (Map.Entry<String, List<String[]>> entry : recordMap.entrySet()) {
                List<String[]> records = entry.getValue();
                if (records.size() > 1) {
                    duplicatesFound = true;
                    System.out.println("Duplicate ID: " + entry.getKey());
                    for (String[] record : records) {
                        System.out.println(Arrays.toString(record));
                    }
                    System.out.println();
                }
            }

            if (!duplicatesFound) {
                System.out.println("No duplicate records found.");
            }

        } catch (Exception e) {
            System.out.println("Error reading the CSV file: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
