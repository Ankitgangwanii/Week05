package com.tit.json.objecttojson;

public class StudentData {
    private String name;
    private int age;
    private int marks;

    public StudentData(String name, int age, int marks){
        this.name = name;
        this.age = age;
        this.marks = marks;
    }
    public String getName(){return name;}
    public int getAge(){return age;}
    public int getMarks(){return marks;}
}
