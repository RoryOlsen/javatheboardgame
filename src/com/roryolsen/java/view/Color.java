package com.roryolsen.java.view;

/**
 * Created by roryolsen on 8/13/14.
 */
public enum Color {

    RED("\u001B[31m"),
    RESET("\u001B[0m"),
    BLACK("\u001B[30m"),
    GREEN("\u001B[32m"),
    YELLOW("\u001B[33m"),
    BLUE("\u001B[34m"),
    PURPLE("\u001B[35m"),
    CYAN("\u001B[36m"),
    WHITE("\u001B[37m");

    private final String code;

    Color(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
