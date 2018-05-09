package io.github.s0cks.glslref.parser;

import com.google.common.base.Preconditions;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

public final class Parser
implements Closeable{
    private final StringBuilder buffer = new StringBuilder();
    private final InputStream input;

    public Parser(InputStream input){
        Preconditions.checkArgument(input != null, "input == null");
        this.input = input;
    }

    @Override
    public void close() throws IOException{
        this.input.close();
    }
}