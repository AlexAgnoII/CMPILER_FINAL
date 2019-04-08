import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;

public class PASCALet {

    public static void main (String[] args) throws IOException {

        //Lexical analysis
        CharStream cs = CharStreams.fromFileName("test.txt"); //get input
        PASCALetGrammarLexer lexer = new PASCALetGrammarLexer(cs);

        CommonTokenStream token = new CommonTokenStream(lexer);
        PASCALetGrammarParser parser = new PASCALetGrammarParser(token);
        ParseTree tree = parser.program();












    }
}
