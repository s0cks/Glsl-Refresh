package io.github.s0cks.glslref.ast;

import io.github.s0cks.glslref.type.Function;

public final class FunctionCallNode
extends AbstractAstNode{
    private final Function func;

    public FunctionCallNode(AstNode parent, Function func){
        super("FunctionCall", parent);
        this.func = func;
    }

    public Function getFunction(){
        return this.func;
    }

    @Override
    public void accept(AstNodeVisitor vis) {
        vis.visitFunctionCall(this);
    }
}