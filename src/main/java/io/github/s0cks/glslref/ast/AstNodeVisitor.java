package io.github.s0cks.glslref.ast;

public interface AstNodeVisitor{
    void visitBinaryOp(BinaryOpNode node);
    void visitBlock(BlockNode node);
    void visitFunctionCall(FunctionCallNode node);
    void visitLiteral(LiteralNode node);
    void visitReturn(ReturnNode node);
    void visitVariableLoad(VariableLoadNode node);
    void visitVariableStore(VariableStoreNode node);
}