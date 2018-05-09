package io.github.s0cks.glslref.parser;

public final class Token{
    private final TokenKind kind;
    private final String text;
    private final int row;
    private final int col;

    public Token(TokenKind kind, String text, int row, int col){
        this.kind = kind;
        this.text = text;
        this.row = row;
        this.col = col;
    }

    public Token(TokenKind kind, String text){
        this(kind, text, -1, -1);
    }

    public Token(TokenKind kind){
        this(kind, kind.toString());
    }

    public TokenKind getKind(){
        return this.kind;
    }

    public String getText(){
        return this.text;
    }

    public int getRow(){
        return this.row;
    }

    public int getColumn(){
        return this.col;
    }
}