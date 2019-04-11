import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

public class PASCALetParserErrorListener extends BaseErrorListener {

    public static PASCALetParserErrorListener INSTANCE = new PASCALetParserErrorListener();

    public void syntaxError(Recognizer<?, ?> recognizer,
                            Object offendingSymbol,
                            int line,
                            int charPositionInLine,
                            String msg,
                            RecognitionException re) {

        throw new PASCALetLexerParserException("Syntax error: " + msg + " at line: " + line);
    }
}
