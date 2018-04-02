package com.andredidier.kiss.rest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Stack;

public abstract class Path {
    public final static String SEPARATOR = "/";

    private Path next;

    public final boolean checkRemaining(Stack<String> parts) {
        if (parts.isEmpty()) {
            return false;
        }
        String part = parts.pop();
        boolean matches = matches(part);
        if (!matches) {
            return false;
        }
        return (next == null && parts.isEmpty()) || (next != null && next.checkRemaining(parts));
    }

    protected abstract boolean matches(String part);

    public final boolean accepts(String path) {
        Stack<String> stack = new Stack<>();
        stack.addAll(Arrays.asList(path.split(SEPARATOR)));
        return checkRemaining(stack);
    }

    public final Path getNext() {
        return next;
    }

    public final void setNext(Path next) {
        this.next = next;
    }
}
