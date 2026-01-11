import java_cup.runtime.Symbol;

%%

%class MiniJavaScanner
%unicode
%cup
%public
%function next_token
%type java_cup.runtime.Symbol
%line
%column

Digit       = [0-9]
Letter      = [A-Za-z]
IdentStart  = {Letter}
IdentPart   = [A-Za-z0-9_]
IDENT       = {IdentStart}{IdentPart}*
INTLIT      = {Digit}+

%%

/* whitespace */
[ \t\r\n\f]+                       { }

/* single-line comment */
"//".* { }

/* multi-line comment (not nested) */
"/*"([^*]|\*+[^*/])*\*+\/          { }

/* special MiniJava print statement */
"System.out.println"               { return new Symbol(sym.PRINT, yyline, yycolumn); }

/* keywords */
"class"                            { return new Symbol(sym.CLASS, yyline, yycolumn); }
"public"                           { return new Symbol(sym.PUBLIC, yyline, yycolumn); }
"static"                           { return new Symbol(sym.STATIC, yyline, yycolumn); }
"void"                             { return new Symbol(sym.VOID, yyline, yycolumn); }
"main"                             { return new Symbol(sym.MAIN, yyline, yycolumn); }
"extends"                          { return new Symbol(sym.EXTENDS, yyline, yycolumn); }
"return"                           { return new Symbol(sym.RETURN, yyline, yycolumn); }
"int"                              { return new Symbol(sym.INT, yyline, yycolumn); }
"boolean"                          { return new Symbol(sym.BOOLEAN, yyline, yycolumn); }
"if"                               { return new Symbol(sym.IF, yyline, yycolumn); }
"else"                             { return new Symbol(sym.ELSE, yyline, yycolumn); }
"while"                            { return new Symbol(sym.WHILE, yyline, yycolumn); }
"this"                             { return new Symbol(sym.THIS, yyline, yycolumn); }
"new"                              { return new Symbol(sym.NEW, yyline, yycolumn); }
"true"                             { return new Symbol(sym.TRUE, yyline, yycolumn); }
"false"                            { return new Symbol(sym.FALSE, yyline, yycolumn); }
"length"                           { return new Symbol(sym.IDENTIFIER, yyline, yycolumn, "length"); }

/* operators */
"&&"                               { return new Symbol(sym.AND, yyline, yycolumn); }
"<"                                { return new Symbol(sym.LT, yyline, yycolumn); }
"+"                                { return new Symbol(sym.PLUS, yyline, yycolumn); }
"-"                                { return new Symbol(sym.MINUS, yyline, yycolumn); }
"*"                                { return new Symbol(sym.TIMES, yyline, yycolumn); }
"!"                                { return new Symbol(sym.NOT, yyline, yycolumn); }
"="                                { return new Symbol(sym.ASSIGN, yyline, yycolumn); }

/* punctuation */
";"                                { return new Symbol(sym.SEMICOLON, yyline, yycolumn); }
","                                { return new Symbol(sym.COMMA, yyline, yycolumn); }
"."                                { return new Symbol(sym.DOT, yyline, yycolumn); }
"("                                { return new Symbol(sym.LPAREN, yyline, yycolumn); }
")"                                { return new Symbol(sym.RPAREN, yyline, yycolumn); }
"{"                                { return new Symbol(sym.LBRACE, yyline, yycolumn); }
"}"                                { return new Symbol(sym.RBRACE, yyline, yycolumn); }
"["                                { return new Symbol(sym.LBRACKET, yyline, yycolumn); }
"]"                                { return new Symbol(sym.RBRACKET, yyline, yycolumn); }

/* integer literal */
{INTLIT}                           {
                                      try {
                                          int val = Integer.parseInt(yytext());
                                          return new Symbol(sym.INTEGER_LITERAL, yyline, yycolumn, val);
                                      } catch (NumberFormatException e) {
                                          System.err.println("Integer out of range: " + yytext());
                                          return new Symbol(sym.INTEGER_LITERAL, yyline, yycolumn, 0);
                                      }
                                   }

/* identifier */
{IDENT}                            { return new Symbol(sym.IDENTIFIER, yyline, yycolumn, yytext()); }

/* end of file */
<<EOF>>                            { return new Symbol(sym.EOF, yyline, yycolumn); }

/* illegal character */
.                                  { 
                                      System.err.println("Illegal char '" + yytext() + "' at line " + (yyline+1)); 
                                      throw new Error("Lexical error"); 
                                   }
