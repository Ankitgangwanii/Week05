package com.tit.json.createjsonobject;

import org.json.JSONObject;

public class CreateJSON {
    public static void main(String[] args) {
        JSONObject jsonObject = new JSONObject();

        String[] subject = new String[]{"English","Math","Science","Social Science"};
        jsonObject.put("Name","Ankit");
        jsonObject.put("Age",21);
        jsonObject.put("Subject",subject);

        System.out.println(jsonObject.toString());
    }
}
