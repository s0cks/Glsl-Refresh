package io.github.s0cks.glslref.ast;

import io.github.s0cks.glslref.type.Variable;

public final class VariableStoreNode
extends AbstractAstNode{
    private final Variable var;
    private final AstNode value;

    public VariableStoreNode(AstNode parent, Variable var, AstNode value){
        super("VariableStore", parent);
        this.var = var;
        this.value = value;
    }

    @Override
    public void accept(AstNodeVisitor vis) {
        vis.visitVariableStore(this);
    }

    public Variable getVariable(){
        return this.var;
    }

    public AstNode getValue(){
        return this.value;
    }
}