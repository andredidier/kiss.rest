package com.andredidier.kiss.rest;

public class IntegerConverter implements Converter<Integer> {
    public Integer from(String text) {
        return Integer.parseInt(text);
    }

    public String from(Integer integer) {
        return String.format("%d", integer);
    }

    public String getRegexPattern() {
        return "\\d+";
    }
}
