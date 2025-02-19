package com.tit.csvfilehandling.advanceproblem.largecsvreader;

import com.opencsv.CSVReader;

import java.io.FileReader;

public class LargeCSV {

        public static void main(String[] args) {
            String filePath = "C:\\Users\\ankitgangwani\\OneDrive\\Documents\\Zoom\\large_file.csv";
            int chunkSize = 100;
            int totalProcessed = 0;

            try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
                String[] line;
                while (true) {
                    int countInChunk = 0;
                    // Process chunk of 100 lines
                    while (countInChunk < chunkSize && (line = reader.readNext()) != null) {
                        // Process the current line (for example, you can add your logic here)
                        countInChunk++;
                        totalProcessed++;
                    }


                    if (countInChunk == 0) {
                        break;
                    }

                    System.out.println("Processed " + totalProcessed + " records so far.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


