package com.andredidier.kiss.rest;

public interface Converter<V> {
    V from(String text);
    String from(V v);
    String getRegexPattern();
}
