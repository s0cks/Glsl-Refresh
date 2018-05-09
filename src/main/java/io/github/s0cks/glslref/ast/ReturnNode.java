package io.github.s0cks.glslref.ast;

public final class ReturnNode
extends AbstractAstNode{
    private final AstNode value;

    public ReturnNode(AstNode parent, AstNode value){
        super("Return", parent);
        this.value = value;
    }

    public AstNode getValue(){
        return this.value;
    }

    @Override
    public void accept(AstNodeVisitor vis){
        vis.visitReturn(this);
    }
}