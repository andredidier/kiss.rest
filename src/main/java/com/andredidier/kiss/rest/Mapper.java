package com.andredidier.kiss.rest;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Mapper {

    private List<MappingBuilder> unprocessedBuilder;
    private List<Path> roots;

    public Mapper() {
        this.unprocessedBuilder = new LinkedList<>();
        this.roots = new LinkedList<>();
    }


    public MappingBuilder listensTo(String plainPath) {
        return new MappingBuilder().listensTo(plainPath);
    }

    private List<Path> getProcessedRoots() {
        for (MappingBuilder mb: unprocessedBuilder) {
            roots.add(mb.process());
        }
        return roots;
    }
}
