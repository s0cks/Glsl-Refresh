package io.github.s0cks.glslref.ast;

import java.util.List;

public interface AstNode{
    String getName();
    AstNode getParent();
    void accept(AstNodeVisitor vis);

    default void addChild(AstNode node){}
    default void removeChild(AstNode node){}

    default void replaceWith(AstNode node){
        AstNode parent = this.getParent();
        parent.removeChild(this);
        parent.addChild(node);
    }

    default List<AstNode> getChildren(){
        return null;
    }
}