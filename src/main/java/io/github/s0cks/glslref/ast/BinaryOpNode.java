package io.github.s0cks.glslref.ast;

public final class BinaryOpNode
extends AbstractAstNode{
    private final BinaryOperation op;
    private final AstNode left;
    private final AstNode right;

    public BinaryOpNode(AstNode parent, BinaryOperation op, AstNode left, AstNode right){
        super("BinaryOp", parent);
        this.op = op;
        this.left = left;
        this.right = right;
    }

    public BinaryOpNode(BinaryOperation op, AstNode left, AstNode right){
        this(null, op, left, right);
    }

    public BinaryOperation getOperation(){
        return this.op;
    }

    public AstNode getLeft(){
        return this.left;
    }

    public AstNode getRight(){
        return this.right;
    }

    @Override
    public void accept(AstNodeVisitor vis) {
        vis.visitBinaryOp(this);
    }

    @Override
    public int hashCode(){
        int hash = super.hashCode();
        hash = hash * 31 ^ op.hashCode();
        hash = hash * 31 ^ this.left.hashCode();
        hash = hash * 31 ^ this.right.hashCode();
        return hash;
    }

    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof BinaryOpNode)) return false;
        if(!(super.equals(obj))) return false;
        BinaryOpNode op = (BinaryOpNode) obj;
        return this.getOperation().equals(op.getOperation()) &&
                this.getLeft().equals(op.getLeft()) &&
                this.getRight().equals(op.getRight());
    }
}