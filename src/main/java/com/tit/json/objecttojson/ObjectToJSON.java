package com.tit.json.objecttojson;

import org.json.JSONObject;

public class ObjectToJSON {
    public static void main(String[] args) {
        Car car = new Car("G-Wagon",1111,"G-Class");
        JSONObject jsonObject1 = new JSONObject(car);
        System.out.println(jsonObject1);
        }
}
