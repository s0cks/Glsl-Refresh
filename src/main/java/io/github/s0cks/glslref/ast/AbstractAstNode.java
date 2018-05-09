package io.github.s0cks.glslref.ast;

abstract class AbstractAstNode
implements AstNode{
    protected final String name;
    protected final AstNode parent;

    protected AbstractAstNode(String name, AstNode parent){
        this.name = name;
        this.parent = parent;
    }

    @Override
    public int hashCode(){
        return com.google.common.base.Objects.hashCode(this.name, this.parent);
    }

    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof AstNode)) return false;
        AstNode node = (AstNode) obj;
        return this.getName().equals(node.getName()) &&
                this.getParent().equals(node.getParent());
    }

    @Override
    public final String getName(){
        return this.name;
    }

    @Override
    public final AstNode getParent(){
        return this.parent;
    }
}