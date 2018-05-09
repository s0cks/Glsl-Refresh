package io.github.s0cks.glslref.ast.printer;

import io.github.s0cks.glslref.ast.AstNode;
import io.github.s0cks.glslref.ast.BinaryOpNode;
import io.github.s0cks.glslref.ast.BinaryOperation;
import io.github.s0cks.glslref.ast.BlockNode;
import io.github.s0cks.glslref.ast.LiteralNode;
import io.github.s0cks.glslref.ast.ReturnNode;
import io.github.s0cks.glslref.type.Value;
import org.junit.Test;

public class AstPrinterTest{
    @Test
    public void testPrint() throws Exception{
        AstNode root = new BlockNode();

        AstNode ten = new LiteralNode(new Value(true, 10));
        AstNode twenty = new LiteralNode(new Value(true, 20));

        root.addChild(new ReturnNode(
                root,
                new BinaryOpNode(
                        BinaryOperation.ADD,
                        ten,
                        twenty
                )
        ));

        root.accept(AstPrinter.SYS_OUT);
    }
}