package com.tit.csvfilehandling.advanceproblem.validatecsvdata;


import com.opencsv.CSVReader;
import java.io.FileReader;
import java.util.regex.Pattern;

public class ValidateCSVData {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\ankitgangwani\\OneDrive\\Documents\\Zoom\\CsvEmailValidate.csv";

        // Regex pattern for a valid email
        Pattern emailPattern = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
        // Regex pattern for a valid phone number (exactly 10 digits)
        Pattern phonePattern = Pattern.compile("^\\d{10}$");

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] header = reader.readNext();

            if (header == null) {
                System.out.println("The CSV file is empty.");
                return;
            }

            int emailIndex = -1;
            int phoneIndex = -1;

            for (int i = 0; i < header.length; i++) {
                if (header[i].equalsIgnoreCase("Email")) {
                    emailIndex = i;
                }
                if (header[i].equalsIgnoreCase("Phone Numbers") || header[i].equalsIgnoreCase("Phone")) {
                    phoneIndex = i;
                }
            }

            if (emailIndex == -1 || phoneIndex == -1) {
                System.out.println("Required columns (Email or Phone Numbers) are missing.");
                return;
            }

            String[] row;
            while ((row = reader.readNext()) != null) {
                String email = row[emailIndex];
                String phone = row[phoneIndex];

                boolean valid = true;
                StringBuilder errorMessages = new StringBuilder();

                // Validate email format
                if (email == null || !emailPattern.matcher(email).matches()) {
                    valid = false;
                    errorMessages.append("Invalid email format. ");
                }

                // Validate phone number (exactly 10 digits)
                if (phone == null || !phonePattern.matcher(phone).matches()) {
                    valid = false;
                    errorMessages.append("Phone number must contain exactly 10 digits.");
                }

                // If row is invalid, print the row and error message(s)
                if (!valid) {
                    System.out.println("Invalid row: " + String.join(", ", row));
                    System.out.println("Error: " + errorMessages.toString());
                } else {
                    // Optionally process valid rows...
                }
            }
        } catch (Exception e) {
            System.out.println("Error reading the CSV file: " + e.getMessage());
        }
    }
}

