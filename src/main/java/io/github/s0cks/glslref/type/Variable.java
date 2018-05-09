package io.github.s0cks.glslref.type;

public final class Variable{
    private final String name;
    private final Value value;

    public Variable(String name, Value value) {
        this.name = name;
        this.value = value;
    }

    public Variable(String name, float floatValue){
        this(name, new Value(true, floatValue));
    }

    public Variable(String name, int intValue){
        this(name, new Value(true, intValue));
    }

    public String getName(){
        return this.name;
    }

    public Value getValue(){
        return this.value;
    }
}