import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;
import java.util.HashMap;

public class PASCALet {

    public static void main (String[] args) throws IOException {

        //Lexical analysis
        CharStream cs = CharStreams.fromFileName("test.txt"); //get input
        PASCALetGrammarLexer lexer = new PASCALetGrammarLexer(cs);

        CommonTokenStream token = new CommonTokenStream(lexer);
        PASCALetGrammarParser parser = new PASCALetGrammarParser(token);
        ParseTree tree = parser.program();

        //Gather all Functions.
        HashMap<String, PASCALetFunction> functions = new HashMap<>();
        PASCALetFunctionVisitor functionVisitor = new PASCALetFunctionVisitor(functions);
        functionVisitor.visit (tree);

        //Gather all procedures.
        HashMap<String, PASCALetProcedure> procedure = new HashMap<>();
        PASCALetProcedureVisitor procedureVisitor = new PASCALetProcedureVisitor(procedure);
        procedureVisitor.visit(tree);

        //test
        //ShowAllSubroutines(functions, procedure);

        //Evaluation visitor here:



    }

    private static void ShowAllSubroutines(HashMap<String, PASCALetFunction> functions, HashMap<String, PASCALetProcedure> procedure) {

        System.out.println("Functions: ");
        for(String key : functions.keySet()) {
           System.out.print(functions.get(key) + " | ");
        }

        System.out.println("\n\nProcedures: ");
        for(String key : procedure.keySet()) {
            System.out.print(procedure.get(key) + " | ");
        }

    }
}
