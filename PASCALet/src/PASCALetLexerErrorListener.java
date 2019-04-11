import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

public class PASCALetLexerErrorListener extends BaseErrorListener {

    public static PASCALetLexerErrorListener INSTANCE = new PASCALetLexerErrorListener();

    public void syntaxError(Recognizer<?, ?> recognizer,
                            Object offendingSymbol,
                            int line,
                            int charPositionInLine,
                            String msg,
                            RecognitionException re) {

        throw new PASCALetLexerParserException("Lexical error: " + msg + " at line: " + line);

    }


}
