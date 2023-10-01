package com.example.makemyhome;

public class UserData {
    public UserData(String city, String name, String email, String uuid, String password) {
        this.city = city;
        this.name = name;
        this.email = email;
        this.uuid = uuid;
        this.password = password;
    }

    String city,name,email,uuid,password;

    public void setCity(String city) {
        this.city = city;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCity() {
        return city;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getUuid() {
        return uuid;
    }

    public String getPassword() {
        return password;
    }





}
