package io.github.s0cks.glslref.ast.printer;

import com.google.common.base.Preconditions;
import io.github.s0cks.glslref.ast.AstNodeVisitor;
import io.github.s0cks.glslref.ast.BinaryOpNode;
import io.github.s0cks.glslref.ast.BlockNode;
import io.github.s0cks.glslref.ast.FunctionCallNode;
import io.github.s0cks.glslref.ast.LiteralNode;
import io.github.s0cks.glslref.ast.ReturnNode;
import io.github.s0cks.glslref.ast.VariableLoadNode;
import io.github.s0cks.glslref.ast.VariableStoreNode;

import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.EnumSet;

public final class AstPrinter
implements Closeable, AstNodeVisitor {
    private final PrintWriter out;
    private final EnumSet<Flags> flags;
    private int indent = 0;
    private int blockCount = 0;

    public AstPrinter(OutputStream out, Flags... flags){
        Preconditions.checkArgument(out != null, "out == null");
        this.out = new PrintWriter(out);
        this.flags = EnumSet.copyOf(Arrays.asList(flags));
    }

    private void indent(){
        for(int i = 0; i < this.indent; i++) out.write(' ');
    }

    private void println(String msg){
        this.out.println(msg);
        if(this.flags.contains(Flags.FLUSH_ON_WRITE)) this.out.flush();
    }

    private void printfln(String msg, Object... args){
        this.println(String.format(msg, args));
    }

    private void printf(String msg, Object... args){
        this.out.printf(msg, args);
        if(this.flags.contains(Flags.FLUSH_ON_WRITE)) this.out.flush();
    }

    private void print(String msg){
        this.out.print(msg);
        if(this.flags.contains(Flags.FLUSH_ON_WRITE)) this.out.flush();
    }

    @Override
    public void close() throws IOException{
        if(this.flags.contains(Flags.CLOSE_ON_FINISH)) this.out.close();
    }

    @Override
    public void visitBinaryOp(BinaryOpNode node){
        node.getLeft().accept(this);
        this.printf(" %s ", node.getOperation().toString());
        node.getRight().accept(this);
    }

    @Override
    public void visitBlock(BlockNode node){
        boolean first = this.blockCount == 0;
        this.blockCount++;

        if(!first){
            this.println("{");
            this.indent++;
        }

        node.getChildren().forEach((child)->{
            this.indent();
            child.accept(this);
            this.print("\n");
        });

        if(!first){
            this.indent--;
            this.println("}\n");
        }
    }

    @Override
    public void visitFunctionCall(FunctionCallNode node){
        this.printf("%s()", node.getFunction().getName());
    }

    @Override
    public void visitLiteral(LiteralNode node){
        this.printf("%s", node.getValue());
    }

    @Override
    public void visitReturn(ReturnNode node){
        this.printf("return ");
        node.getValue().accept(this);
        this.printf(";");
    }

    @Override
    public void visitVariableLoad(VariableLoadNode node){
        this.printf("$%s", node.getVariable().getName());
    }

    @Override
    public void visitVariableStore(VariableStoreNode node){
        this.printf("%s := ", node.getVariable().getName());
        node.getValue().accept(this);
        this.print(";");
    }

    public static final AstPrinter SYS_OUT = new AstPrinter(System.out, Flags.FLUSH_ON_WRITE);

    enum Flags{
        FLUSH_ON_WRITE,
        CLOSE_ON_FINISH;
    }
}