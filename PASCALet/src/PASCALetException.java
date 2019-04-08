import org.antlr.v4.runtime.ParserRuleContext;

public class PASCALetException  extends RuntimeException {


    public PASCALetException(ParserRuleContext ctx) {
        this("Illegal expression: "  + ctx.getText(), ctx);
    }

    public PASCALetException(String msg, ParserRuleContext ctx) {
        super(msg + " line:" + ctx.start.getLine());
    }
}
