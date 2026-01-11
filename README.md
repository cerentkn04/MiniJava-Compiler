# MiniJava Compiler - Parser & AST

This project implements a complete compiler front-end for the MiniJava language, featuring a lexical scanner (JFlex), an LALR(1) parser (CUP), and an Abstract Syntax Tree (AST) generator.

## 🚀 How to Build and Run

Follow these steps in your terminal to build the compiler and test it with the provided sample files.

### 1. Build and Run the Project
First, generate the scanner/parser and compile the Java source code. Then, you can run the compiler using the `./mj` script.

```bash
# Build the compiler
./build 

# Run the Compiler to view the Abstract Syntax Tree (AST) with line numbers:
./mj -A Sample.java

# Run the Compiler to view the PrettyPrint (Round-Trip) output:
./mj -P Verify.java
