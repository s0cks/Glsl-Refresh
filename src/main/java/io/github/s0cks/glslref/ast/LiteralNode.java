package io.github.s0cks.glslref.ast;

import io.github.s0cks.glslref.type.Value;

public final class LiteralNode
extends AbstractAstNode{
    private final Value value;

    public LiteralNode(AstNode parent, Value value){
        super("Literal", parent);
        this.value = value;
    }

    public LiteralNode(Value value){
        this(null, value);
    }

    public Value getValue(){
        return this.value;
    }

    @Override
    public void accept(AstNodeVisitor vis){
        vis.visitLiteral(this);
    }

    @Override
    public int hashCode(){
        int hash = super.hashCode();
        hash = hash * 31 ^ this.value.hashCode();
        return hash;
    }

    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof LiteralNode)) return false;
        LiteralNode lit = (LiteralNode) obj;
        return lit.getValue().equals(this.getValue()) &&
                this.getParent().equals(lit.getParent());
    }
}