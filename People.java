package com.example.demo3;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class People {

    static ArrayList<People> list = new ArrayList<People>();

    private String name;
    private String email;
    public String password;
    private long phone;
    public String userName;

    People(String userName, String fullName, String email, String password, long phone){
        this.userName = userName;
        this.name = fullName;
        this.email = email;
        this.password = password;
        this.phone= phone;
    }

    public String toString(){
        return "Username: " + userName +
                " | Name: " + name +
                " | Email: " + email +
                " | Phone #: " + phone;
    }
}
