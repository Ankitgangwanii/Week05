package com.tit.csvfilehandling.advanceproblem.jsontocsv;


public class JsonCsvConverterMain {
    public static void main(String[] args) {
        //define file path
        String jsonFilePath = "C:\\Users\\ankitgangwani\\OneDrive\\Documents\\Zoom\\student.json";
        String csvFilePath = "C:\\Users\\ankitgangwani\\OneDrive\\Documents\\Zoom\\student.csv";
        String outputJsonFilePath = "C:\\Users\\ankitgangwani\\OneDrive\\Documents\\Zoom\\studentoutput.json";

        // convert csv back to json
        CsvToJsonConverter.convert(csvFilePath, outputJsonFilePath);
        // convert json to csv
        JsonToCsvConverter.convert(jsonFilePath, csvFilePath);
    }

}
