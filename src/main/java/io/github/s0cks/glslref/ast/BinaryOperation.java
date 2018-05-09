package io.github.s0cks.glslref.ast;

public enum BinaryOperation{
    ADD("+"),
    SUB("-"),
    MUL("*"),
    DIV("/"),
    MOD("%");

    private final String sign;

    BinaryOperation(String sign){
        this.sign = sign;
    }

    @Override
    public String toString(){
        return this.sign;
    }
}