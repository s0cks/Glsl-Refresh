package io.github.s0cks.glslref.type;

public final class Value{
    private final boolean isConstant;
    private final Type type;
    private int intValue;
    private float floatValue;

    Value(Type type, boolean isConstant){
        this.type = type;
        this.isConstant = isConstant;
    }

    public Value(boolean isConstant, float floatValue){
        this(Type.FLOAT, isConstant);
        this.floatValue = floatValue;
    }

    public Value(float floatValue){
        this(false, floatValue);
    }

    public Value(boolean isConstant, int intValue){
        this(Type.INT, isConstant);
        this.intValue = intValue;
    }

    public Value(int intValue){
        this(false, intValue);
    }

    public Type getType(){
        return this.type;
    }

    public boolean isOfType(Type type){
        return this.getType().equals(type);
    }

    public boolean isConstant(){
        return this.isConstant;
    }

    public int asInteger(){
        return this.intValue;
    }

    public float asFloat(){
        return this.floatValue;
    }

    @Override
    public String toString(){
        if(!this.isConstant()) return this.type.getName();
        if(!(this.isOfType(Type.FLOAT) || this.isOfType(Type.INT))) return this.type.getName();
        return String.format(
                "%s[%s]",
                this.getType(),
                this.isOfType(Type.FLOAT) ?
                        this.asFloat() :
                        this.asInteger()
        );
    }
}