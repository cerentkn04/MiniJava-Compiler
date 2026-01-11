# MiniJava Compiler - Parser & AST

This project implements a Parser and Abstract Syntax Tree (AST) generator for the MiniJava language using JFlex and java-cup.

## Features
- **LALR(1) Parser**: Handles MiniJava grammar with disambiguated variable/statement rules.
- **AST Generation**: Produces a full tree with line number tracking.
- **Visitors**: 
  - `-A`: Prints a vertically indented Abstract Syntax Tree.
  - `-P`: Pretty-prints the AST back into legal Java code.

## How to Build
1. Generate Scanner: `java -jar tools/jflex.jar spec/scanner.flex`
2. Generate Parser: `java -jar tools/java-cup-11b.jar -destdir spec/ -expect 1 spec/parser.cup`
3. Compile: `javac -cp ".:tools/java-cup-11b-runtime.jar:src:spec" MiniJava.java`

## How to Run
`java -cp ".:tools/java-cup-11b-runtime.jar:src:spec" MiniJava -A YourFile.java`
