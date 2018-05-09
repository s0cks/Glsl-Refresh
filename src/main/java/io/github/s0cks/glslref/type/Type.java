package io.github.s0cks.glslref.type;

public final class Type{
    private final String name;
    private final int size;
    private final boolean isNumeric;

    public Type(String name, int size, boolean isNumber){
        this.name = name;
        this.size = size;
        this.isNumeric = isNumber;
    }

    public Type(int size, boolean isNumber){
        this.size = size;
        this.isNumeric = isNumber;
        if(this.size == 1){
            this.name = isNumber ? "int" : "float";
        } else{
            this.name = (isNumber ? "i" : "") + "vec" + this.size;
        }
    }

    public Value newInstance(){
        return new Value(this, false);
    }

    public int getSize(){
        return this.size;
    }

    public boolean isNumericType(){
        return this.isNumeric;
    }

    public boolean isCompatible(Type type){
        return (this.size == type.size || this.size == 1) &&
                (this.isNumeric == type.isNumeric);
    }

    public String getName(){
        return this.name;
    }

    @Override
    public String toString(){
        return this.name;
    }

    public static final Type INT = new Type("int", 1, true);
    public static final Type FLOAT = new Type("float", 1, false);
    public static final Type VEC2 = new Type("vec2", 2, false);
    public static final Type VEC3 = new Type("vec3", 3, false);
    public static final Type VEC4 = new Type("vec4", 4, false);
    public static final Type VOID = new Type("void", 0, true);
    public static final Type ERROR = new Type("__ERROR__", 0, true);
}