import java.io.FileReader;

public class ParseTest {
    public static void main(String[] args) throws Exception {
        MiniJavaScanner scanner =
            new MiniJavaScanner(new FileReader("Factorial.mj"));
        MiniJavaParser parser =
            new MiniJavaParser(scanner);

        parser.parse();
        System.out.println("Parse successful.");
    }
}

