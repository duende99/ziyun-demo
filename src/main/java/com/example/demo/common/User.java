package com.example.demo.common;

import lombok.Data;

public enum User {
    red("hong",1), blue("lan",2);
    private String name;
    private Integer code;

    private User(String name, Integer code) {
        this.name = name;
        this.code = code;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setCode(Integer code) {
        this.code = code;
    }
    public Integer getCode() {
        return code;
    }
}


class bbb {

    public static void main(String[] args) {
        Integer code = User.red.getCode();
        String name = User.red.getName();
        System.out.println(code + "  "+ name);
    }
}