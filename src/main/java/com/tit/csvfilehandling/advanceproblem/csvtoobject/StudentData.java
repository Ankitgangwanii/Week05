package com.tit.csvfilehandling.advanceproblem.csvtoobject;

import com.opencsv.bean.CsvBindByName;

public class StudentData {

        @CsvBindByName(column = "ID")
        private int id;

        @CsvBindByName(column = "Name")
        private String name;

        @CsvBindByName(column = "Email")
        private String email;

        @CsvBindByName(column = "Marks")
        private double marks;

        // Getters and setters

        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }
        public void setEmail(String email) {
            this.email = email;
        }

        public double getMarks() {
            return marks;
        }
        public void setMarks(double marks) {
            this.marks = marks;
        }

        @Override
        public String toString() {
            return "Student [ID=" + id + ", Name=" + name + ", Email=" + email + ", Marks=" + marks + "]";
        }
    }

