package com.tit.csvfilehandling.intermediateproblem.sortrecords;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.util.*;

public class SortRecords {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\ankitgangwani\\OneDrive\\Documents\\Zoom\\SearchRecord.csv";

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            List<String[]> records = new ArrayList<>();
            String[] header = reader.readNext(); // Read the header separately
            int salaryIndex = -1;

            // Find the index of "Salary" column
            for (int i = 0; i < header.length; i++) {
                if (header[i].equalsIgnoreCase("Salary")) {
                    salaryIndex = i;
                    break;
                }
            }

            if (salaryIndex == -1) {
                System.out.println("Salary column not found!");
                return;
            }

            // Read and store remaining records
            String[] line;
            while ((line = reader.readNext()) != null) {
                records.add(line);
            }

            // Sort records using a custom comparator
            Collections.sort(records, new SalaryComparator(salaryIndex));

            // Print header
            System.out.println(String.join("\t", header));

            // Print top 5 highest-paid employees
            for (int i = 0; i < Math.min(5, records.size()); i++) {
                System.out.println(String.join("\t", records.get(i)));
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

// Custom comparator for sorting by Salary (Descending Order)
class SalaryComparator implements Comparator<String[]> {
    private int salaryIndex;

    public SalaryComparator(int salaryIndex) {
        this.salaryIndex = salaryIndex;
    }

    @Override
    public int compare(String[] a, String[] b) {
        int salaryA = Integer.parseInt(a[salaryIndex]);
        int salaryB = Integer.parseInt(b[salaryIndex]);
        return Integer.compare(salaryB, salaryA); // Descending order
    }
}
