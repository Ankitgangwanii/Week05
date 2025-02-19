package com.tit.csvfilehandling.advanceproblem.csvtoobject;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.FileReader;
import java.util.List;

public class ParseCSV {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\ankitgangwani\\OneDrive\\Documents\\Zoom\\CsvFile1.csv";

        try (FileReader reader = new FileReader(filePath)) {
            CsvToBean<StudentData> csvToBean = new CsvToBeanBuilder<StudentData>(reader)
                    .withType(StudentData.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            List<StudentData> studentDatas = csvToBean.parse();
            for (StudentData StudentData : studentDatas) {
                System.out.println(StudentData);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
