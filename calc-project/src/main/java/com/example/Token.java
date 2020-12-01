package com.example;


public final class Token {
  private TokenType type;
  private Object obj;

  public Token() {
  }

  public Token(TokenType type, Object obj) {
    this.type = type;
    this.obj = obj;
  }

  public TokenType getType() {
    return type;
  }

  public Object getObject() {
    return obj;
  }

}
