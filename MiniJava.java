import java_cup.runtime.*;
import java.io.*;
import AST.*;
import AST.Visitor.*;

public class MiniJava {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("Usage: java MiniJava [-S|-A|-P] filename.java");
            System.exit(1);
        }

        String flag = args[0];
        String filename = args[1];

        try {
            InputStream is = new FileInputStream(filename);
            Reader r = new InputStreamReader(is);
            MiniJavaScanner scanner = new MiniJavaScanner(r);
            
            // Handle Scanner-only mode
            if (flag.equals("-S")) {
                Symbol s;
                do {
                    s = scanner.next_token();
                    // You might need a method to print token names from sym.java
                    System.out.println("Token: " + s.sym + " Value: " + s.value);
                } while (s.sym != sym.EOF);
                System.exit(0);
            }

            // Handle Parser modes
            parser p = new parser(scanner);
            Symbol rootSymbol = p.parse();
            
            if (p.errorDetected) {
                System.exit(1);
            }

            Program program = (Program) rootSymbol.value;

            if (flag.equals("-A")) {
                // Abstract AST Printout
                program.accept(new ASTPrintVisitor());
            } else if (flag.equals("-P")) {
                // Decompiled Pretty Print
                program.accept(new PrettyPrintVisitor());
            } else {
                System.err.println("Unknown flag: " + flag);
                System.exit(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
