package com.andredidier.kiss.rest;

import java.util.LinkedList;
import java.util.concurrent.Callable;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class MappingBuilder {
    private Path root;
    private Path current;

    private Mapper mapper;

    public MappingBuilder() {
    }

    private MappingBuilder listensTo(Path p) {
        current = p;
        if(root == null) {
            root = p;
        }
        return this;
    }

    public MappingBuilder listensTo(String text) {
        return listensTo(new PlainPath().with(text));
    }
    public <T> MappingBuilder listensTo(String name, Converter<T> converter) {
        return listensTo(new ParameterPath<T>().with(name).and(converter);
    }

    public MappingBuilder then(String path) {

        return this;
    }
    public <V> MappingBuilder then(String name, Converter<V> converter) {
        return this;
    }

    public BiConsumer<String, PathHandler> respondsWith() {
        Path p;
        return (text, executor) -> {
            if (p.accepts(text)) {
                executor.execute();
            }
        } ;
    }

    public Path process() {
        return null;
    }
}
