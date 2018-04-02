package com.andredidier.kiss.rest;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MapperBasicTest {

    private Mapper mapper;

    @Before
    public void prepare() {
        mapper = new Mapper();
    }

    @Test
    public void testPlainPath() {
        mapper.listensTo("v1");
        assertTrue(mapper.accepts("/v1"));
    }

    @Test
    public void testPlainNegativePath() {
        mapper.listensTo("v1");
        assertFalse(mapper.accepts("/v2"));
    }

    @Test
    public void testNestedPlainPath() {
        mapper.listensTo("v1").then("secondPath");
        assertTrue(mapper.accepts("/v1/secondPath"));
    }
    @Test
    public void testNegativeNestedPlainPath() {
        mapper.listensTo("v1").then("secondPath1");
        assertFalse(mapper.accepts("/v1/secondPath2"));
    }
    @Test
    public void testWithParameter() {
        mapper.listensTo("v1").then("p1",Converters.Integer.use());
        assertTrue(mapper.accepts("/v1/123"));
    }
    @Test
    public void testNegativeWithStringValue() {
        mapper.listensTo("v1").then("p1",Converters.Integer.use());
        assertFalse(mapper.accepts("/v1/abc"));
    }
    @Test
    public void testNegativeWithIncorrentFormatValue() {
        mapper.listensTo("v1").then("p1",Converters.Integer.use());
        assertFalse(mapper.accepts("/v1/1.23"));
    }
}
