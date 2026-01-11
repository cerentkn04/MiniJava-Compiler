import java.io.FileReader;
import java_cup.runtime.Symbol;

public class ScanTest {
    public static void main(String[] args) throws Exception {
        MiniJavaScanner scanner =
            new MiniJavaScanner(new FileReader("Factorial.mj"));

        Symbol s;
        do {
            s = scanner.next_token();
            System.out.println(
                sym.terminalNames[s.sym] +
                (s.value != null ? " (" + s.value + ")" : "")
            );
        } while (s.sym != sym.EOF);
    }
}

