package com.andredidier.kiss.rest;

public class PlainPath extends Path {
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Path with(String text) {
        this.text = text;
        return this;
    }

    @Override
    protected boolean matches(String part) {
        return text.equals(part);
    }
}
