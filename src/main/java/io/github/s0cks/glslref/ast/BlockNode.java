package io.github.s0cks.glslref.ast;

import com.google.common.collect.ImmutableList;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class BlockNode
extends AbstractAstNode{
    private final Set<AstNode> children = new HashSet<>();

    public BlockNode(AstNode parent){
        super("Sequence",  parent);
    }

    public BlockNode(){
        this(null);
    }

    public List<AstNode> getChildren(){
        return ImmutableList.copyOf(this.children);
    }

    @Override
    public void accept(AstNodeVisitor vis){
        vis.visitBlock(this);
    }

    public void addChild(AstNode node){
        this.children.add(node);
    }

    public void removeChild(AstNode node){
        this.children.remove(node);
    }

    @Override
    public int hashCode(){
        int hash = super.hashCode();
        hash = hash * 31 ^ this.children.hashCode();
        return hash;
    }

    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof BlockNode)) return false;
        if(!(super.equals(obj))) return false;
        BlockNode seq = (BlockNode) obj;
        if(this.children.size() != seq.children.size()) return false;
        return this.children.equals(seq.children);
    }
}