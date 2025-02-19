package com.tit.csvfilehandling.advanceproblem.encryptdecrypt;



import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import static java.lang.System.out;

public class EncryptDecrypt {
    private static String encrypt(String data) {
        StringBuilder sb = new StringBuilder();
        int shift = 3;
        for (char ch : data.toCharArray()) {
            sb.append((char) (ch + shift));
        }
        return sb.toString();
    }
    // method to decrypt
    private static String decrypt(String data) {
        StringBuilder sb = new StringBuilder();
        int shift = 3;
        for (char ch : data.toCharArray()) {
            sb.append((char) (ch - shift));
        }
        return sb.toString();
    }
    private static void encryptCsvData(String inputFilePath, String outputFilePath) {
        try (CSVReader reader = new CSVReader(new FileReader(inputFilePath));
             CSVWriter writer = new CSVWriter(new FileWriter(outputFilePath))) {

            String[] row;
            boolean isHeader = true;
            while ((row = reader.readNext()) != null) {
                if (isHeader) {
                    writer.writeNext(row);
                    isHeader = false;
                    continue;
                }
                // encrypt email and number
                row[1] = encrypt(row[1]);
                row[2] = encrypt(row[2]);

                writer.writeNext(row);
            }
            out.println("csv file written with encrypted data");
        } catch (IOException | CsvValidationException e) {
            out.println("exception- " + e.getMessage());
        }
    }
    private static void readAndDecryptCsv(String filePath) {
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] row;
            boolean isHeader = true;
            while ((row = reader.readNext()) != null) {
                if (isHeader) {
                    out.println("\nid, email, number");
                    isHeader = false;
                    continue;
                }
                // decrypt sensitive email and number
                row[1] = decrypt(row[1]);
                row[2] = decrypt(row[2]);
                out.println(String.join(", ", row));
            }
        } catch (IOException | CsvValidationException e) {
            out.println("exception- " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // define input and output file paths
        String inputFilePath = "C:\\Users\\ankitgangwani\\OneDrive\\Documents\\Zoom\\CsvFile1.csv";
        String encryptedFilePath = "C:\\Users\\ankitgangwani\\OneDrive\\Documents\\Zoom\\encrypted.csv";

        //encrypt csv data
        encryptCsvData(inputFilePath, encryptedFilePath);

        //read encrypted csv data
        out.println("\nreading encrypted data");
        readAndDecryptCsv(encryptedFilePath);
    }
}
