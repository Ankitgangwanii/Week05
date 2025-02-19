package com.tit.csvfilehandling.advanceproblem.jsontocsv;


import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CsvToJsonConverter {
    public static void convert(String csvFilePath, String jsonFilePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(csvFilePath))) {
            // read header
            String headerLine = reader.readLine();
            if (headerLine == null) {
                System.out.println("csv file is empty: " + csvFilePath);
                return;
            }
            String[] headers = headerLine.split(",");

            // read data and convert to json array
            JSONArray jsonArray = new JSONArray();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                JSONObject obj = new JSONObject();
                for (int i = 0; i < headers.length; i++) {
                    obj.put(headers[i], values[i]);
                }
                jsonArray.put(obj);
            }

            // write json file
            Files.write(Paths.get(jsonFilePath), jsonArray.toString(4).getBytes(StandardCharsets.UTF_8));
            System.out.println("csv converted to json successfully: " + jsonFilePath);
        } catch (Exception e) {
            System.out.println("error while converting csv to json: " + e.getMessage());
        }
    }
}
