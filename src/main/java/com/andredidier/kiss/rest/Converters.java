package com.andredidier.kiss.rest;

public enum Converters {
    Integer(new IntegerConverter());
    private Converter c;
    Converters(Converter c) {
        this.c = c;
    }
    public <V> Converter<V> use() {
        return (Converter<V>)c;
    }

}
