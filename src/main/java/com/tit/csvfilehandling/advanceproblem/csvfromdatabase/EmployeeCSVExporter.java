package com.tit.csvfilehandling.advanceproblem.csvfromdatabase;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

public class EmployeeCSVExporter {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/AnkitDB";
        String user = "Ankit12";
        String password = "12042003";
        String filePath = "C:\\Users\\ankitgangwani\\OneDrive\\Documents\\Zoom\\EmployeeData.csv";

        exportToCSV(url, user, password, filePath);
    }

    public static void exportToCSV(String url, String user, String password, String filePath) {
        String query = "SELECT employee_id, name, department, salary FROM employees";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query);
             FileWriter writer = new FileWriter(filePath)) {

            writer.write("Employee ID,Name,Department,Salary\n");
            while (rs.next()) {
                writer.write(rs.getInt("employee_id") + ","
                        + rs.getString("name") + ","
                        + rs.getString("department") + ","
                        + rs.getDouble("salary") + "\n");
            }

            System.out.println("CSV file generated successfully: " + filePath);

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
