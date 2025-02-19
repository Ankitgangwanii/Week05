package com.tit.csvfilehandling.advanceproblem.jsontocsv;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.json.JSONArray;
import org.json.JSONObject;
import static java.lang.System.out;

public class JsonToCsvConverter {
    public static void convert(String jsonFilePath, String csvFilePath) {
        try {
            // read json file
            String content = new String(Files.readAllBytes(Paths.get(jsonFilePath)), StandardCharsets.UTF_8);
            if (content.trim().isEmpty()) {
                out.println("json file is empty: " + jsonFilePath);
                return;
            }

            // parse json array
            JSONArray jsonArray = new JSONArray(content);

            // write csv file
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFilePath))) {
                // write header
                JSONObject obj = jsonArray.getJSONObject(0);
                String[] keys = JSONObject.getNames(obj);
                writer.write(String.join(",", keys));
                writer.newLine();

                // write data
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObj = jsonArray.getJSONObject(i);
                    String[] values = new String[keys.length];
                    for (int j = 0; j < keys.length; j++) {
                        values[j] = jsonObj.get(keys[j]).toString();
                    }
                    writer.write(String.join(",", values));
                    writer.newLine();
                }
                out.println("json converted to csv successfully: " + csvFilePath);
            }
        } catch (Exception e) {
            out.println("error while converting json to csv: " + e.getMessage());
        }
    }
}