package com.tit.json.objecttojson;

public class Car {
    private String car_Name;
    private int car_Num;
    private String car_Model;

    public Car(String car_Name, int car_Num, String car_Model){
        this.car_Model = car_Model;
        this.car_Num = car_Num;
        this.car_Name = car_Name;
    }
    public String getCar_Name(){return car_Name;}
    public int getCar_Num(){return car_Num;}
    public String getCar_Model(){return car_Model;}
}
