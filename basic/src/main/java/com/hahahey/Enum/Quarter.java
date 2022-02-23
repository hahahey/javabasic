package com.hahahey.Enum;


/**
 * 枚举
 **/
public enum Quarter {

    /**
     *
     **/
    SPRING1(),
    SUMMER1(),
    AUTUMN1(),
    WINTER1(),

    SPRING("春"),
    SUMMER("夏"),
    AUTUMN("秋"),
    WINTER("冬");

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    //enum的构造器只能是private
    private Quarter() {
    }

    private Quarter(String name) {
        this.name = name;
    }



}
