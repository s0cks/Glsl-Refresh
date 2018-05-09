package io.github.s0cks.glslref.type;

import com.google.common.collect.ImmutableList;
import io.github.s0cks.glslref.ast.BlockNode;

import java.util.ArrayList;
import java.util.List;

public final class Function{
    private final List<Variable> parameters = new ArrayList<>();
    private final String name;
    private final Type returnType;

    private BlockNode code;

    public Function(String name, Type returnType){
        this.name = name;
        this.returnType = returnType;
    }

    public void setCode(BlockNode node){
        this.code = node;
    }

    public BlockNode getCode(){
        return this.code;
    }

    public String getName(){
        return this.name;
    }

    public Type getReturnType(){
        return this.returnType;
    }

    public List<Variable> getParameters(){
        return ImmutableList.copyOf(this.parameters);
    }

    public Variable getParameter(String name){
        return this.getParameters()
                .stream()
                .filter((p)->p.getName().equals(name))
                .findAny()
                .orElse(null);
    }

    public int getInputSize(){
        return this.parameters.stream()
                .mapToInt((p)->p.getValue().getType().getSize())
                .sum();
    }
}