package io.github.s0cks.glslref.ast;

import io.github.s0cks.glslref.type.Variable;

public final class VariableLoadNode
extends AbstractAstNode{
    private final Variable var;

    public VariableLoadNode(AstNode parent, Variable var){
        super("VariableLoad", parent);
        this.var = var;
    }

    @Override
    public void accept(AstNodeVisitor vis){
        vis.visitVariableLoad(this);
    }

    public Variable getVariable(){
        return this.var;
    }
}