package com.tit.csvfilehandling.advanceproblem.mergecsvfile;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

public class MergeCSVFiles {
    public static void main(String[] args) {
        String file1 = "C:\\Users\\ankitgangwani\\OneDrive\\Documents\\Zoom\\student1.csv";
        String file2 = "C:\\Users\\ankitgangwani\\OneDrive\\Documents\\Zoom\\student2.csv";
        String outputFile = "C:\\Users\\ankitgangwani\\OneDrive\\Documents\\Zoom\\MergedCSVFile.csv";

        // Map to store merged records keyed by ID
        // The merged record will be an array of 5 strings: {ID, Name, Age, Marks, Grade}
        Map<String, String[]> mergedRecords = new HashMap<>();

        try (CSVReader reader1 = new CSVReader(new FileReader(file1))) {
            String[] header1 = reader1.readNext();  // Read header (assumed to be "ID,Name,Age")
            String[] row;
            while ((row = reader1.readNext()) != null) {

                String id = row[0];
                String[] merged = new String[5];
                merged[0] = id;
                merged[1] = row.length > 1 ? row[1] : "";
                merged[2] = row.length > 2 ? row[2] : "";
                merged[3] = "";  // Marks (to be filled from file2)
                merged[4] = "";  // Grade (to be filled from file2)
                mergedRecords.put(id, merged);
            }
        } catch (Exception e) {
            System.out.println("Error reading file1: " + e.getMessage());
            e.printStackTrace();
        }

        try (CSVReader reader2 = new CSVReader(new FileReader(file2))) {
            String[] header2 = reader2.readNext();  // Read header (assumed to be "ID,Marks,Grade")
            String[] row;
            while ((row = reader2.readNext()) != null) {

                String id = row[0];
                String marks = row.length > 1 ? row[1] : "";
                String grade = row.length > 2 ? row[2] : "";

                if (mergedRecords.containsKey(id)) {
                    // Update existing record with Marks and Grade
                    String[] merged = mergedRecords.get(id);
                    merged[3] = marks;
                    merged[4] = grade;
                } else {
                    // Create a new merged record if the ID doesn't exist in file1
                    String[] merged = new String[5];
                    merged[0] = id;
                    merged[1] = "";  // Name unknown
                    merged[2] = "";  // Age unknown
                    merged[3] = marks;
                    merged[4] = grade;
                    mergedRecords.put(id, merged);
                }
            }
        } catch (Exception e) {
            System.out.println("Error reading file2: " + e.getMessage());
            e.printStackTrace();
        }

        try (CSVWriter writer = new CSVWriter(new FileWriter(outputFile))) {

            String[] header = {"ID", "Name", "Age", "Marks", "Grade"};
            writer.writeNext(header);


            for (String[] record : mergedRecords.values()) {
                writer.writeNext(record);
            }

            System.out.println("Merged CSV file created successfully: " + outputFile);
        } catch (Exception e) {
            System.out.println("Error writing merged file: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

