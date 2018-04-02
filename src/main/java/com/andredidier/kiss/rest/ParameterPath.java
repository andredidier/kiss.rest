package com.andredidier.kiss.rest;

public class ParameterPath<V> extends Path {
    private String name;
    private Converter<V> converter;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public V convert(String text) {
        if (converter == null) {
            return null;
        }
        return converter.from(text);
    }

    public Converter<V> getConverter() {
        return converter;
    }

    public void setConverter(Converter<V> converter) {
        this.converter = converter;
    }

    public ParameterPath<V> with(String name) {
        this.name = name;
        return this;
    }
    public ParameterPath<V> with(Converter<V> converter) {
        this.converter = converter;
        return this;
    }

    public ParameterPath<V> and(String name) {
        return with(name);
    }
    public ParameterPath<V> and(Converter<V> converter) {
        return with(converter);
    }

    @Override
    protected boolean matches(String part) {
        return part != null && part.matches(converter.getRegexPattern());
    }
}
