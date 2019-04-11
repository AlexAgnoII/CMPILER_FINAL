grammar PASCALetGrammar;

//P A R S E R S
program
   : programHeading block PERIOD
   ;

programHeading
   : PROGRAM identifier SEMICOLUMN
   ;

identifier
   : IDENTIFIER
   ;

block
   : (constantDefinitionPart | variableDeclarationPart | subroutineDeclarationPart)* statementGroup
   ;

constantDefinitionPart
   : CONST (constantDefinition SEMICOLUMN)+
   ;

constantDefinition
   : identifier EQUALS constant
   ;

constant
   : unsignedInteger | sign unsignedInteger | string
   ;

unsignedInteger
   : NUM_INT
   ;

sign
   : PLUS | MINUS
   ;

bool
   : TRUE | FALSE
   ;

string
   : STRING_LITERAL
   ;

variableDeclarationPart
   : VAR variableDeclaration (SEMICOLUMN variableDeclaration)* SEMICOLUMN
   ;

variableDeclaration
   : identifierList COLON type
   ;

identifierList
   : identifier (COMMA identifier)*
   ;

type
   : typeIdentifier | arrayType
   ;

typeIdentifier
   : CHAR | BOOLEAN | INTEGER | STRING
   ;

arrayType
   : ARRAY LBRACKET expression PERIODPERIOD expression RBRACKET OF INTEGER
   ;

subroutineDeclarationPart
   : subRoutineDeclaration SEMICOLUMN
   ;

subRoutineDeclaration
   : procedureDeclaration | functionDeclaration
   ;

procedureDeclaration
   : PROCEDURE identifier (formalParameterlist)? SEMICOLUMN block
   ;

functionDeclaration
   : FUNCTION identifier (formalParameterlist)? COLON resultType SEMICOLUMN block
   ;

formalParameterlist
   : LPAREN (parameterGroup (SEMICOLUMN parameterGroup)*)? RPAREN
   ;

parameterGroup
   : (identifierList COLON typeIdentifier)
   ;

resultType
   : typeIdentifier
   ;

statementGroup
   : BEGIN statements END
   ;

statements //1 or more sstatements. Captures statements with ; or final sstatement without ;
   : statement (SEMICOLUMN statement)*
   ;

statement
   : simpleStatement | structuredStatement
   ;

simpleStatement
   : assignmentStatement | procedureStatement | reservedStatements | emptyStatement
   ;

reservedStatements
   : writeStatement | readStatement
   ;

writeStatement
   : (WRITE | WRITELN) LPAREN ((expression COMMA expression) | expression)? RPAREN
   ;

readStatement
   : READLN LPAREN variable? RPAREN
   ;

structuredStatement
   : statementGroup | ifStatement | forStatement
   ;

ifStatement
   : IF expression THEN statement (ELSE statement)?
   ;

forStatement
   : FOR identifier ASSIGNMENT forList DO statement
   ;

forList
   : initialValue TO finalValue
   ;

initialValue
   : expression
   ;

finalValue
   : expression
   ;

assignmentStatement
   : variable ASSIGNMENT expression
   ;

variable
   : IDENTIFIER (LBRACKET expression RBRACKET)*
   ;

expression
   : simpleExpression (relationaloperator expression)?
   ;

simpleExpression
   : term (additiveOperator simpleExpression)?
   ;

term
   : signedFactor (multiplicativeOperator term)?
   ;

additiveOperator
   : PLUS | MINUS | OR
   ;

multiplicativeOperator
   : STAR | SLASH | MOD | AND
   ;

relationaloperator
   : EQUALS | NOTEQUALS | LESSTHAN | GREATERTHAN | LESSTHANOREQUALS | GREATERTHANOREQUALS
   ;

signedFactor
   : (PLUS | MINUS)? factor
   ;

factor
   : variable | LPAREN expression RPAREN | functionDesignator | unsignedConstant | NOT factor | bool
   ;

unsignedConstant
   : unsignedInteger | string
   ;

functionDesignator //function when called for an assignment.
   : identifier LPAREN (parameterList)? RPAREN
   ;

parameterList
   : actualParameter (COMMA actualParameter)*
   ;

actualParameter
   : expression
   ;

procedureStatement
   : identifier (LPAREN (parameterList)? RPAREN)?
   ;

emptyStatement
   :
   ;




//L E X E RS

//For program statements blocks keywords.
PROGRAM
   : P R O G R A M
   ;

BEGIN
   : B E G I N
   ;

END
   : E N D
   ;

//pascal reserved function calls
WRITE
   : W R I T E
   ;

WRITELN
   : W R I T E L N
   ;

READLN
    : R E A D L N
    ;


//Subroutines keywords
PROCEDURE
   : P R O C E D U R E
   ;

FUNCTION
   : F U N C T I O N
   ;


//Iterative keywords
FOR
   : F O R
   ;

TO
   : T O
   ;

DO
   : D O
   ;

//Conditional keywords
IF
   : I F
   ;

THEN
   : T H E N
   ;

ELSE
   : E L S E
   ;

//Variable keywords
VAR
   : V A R
   ;

STRING
   : S T R I N G
   ;

CHAR
   : C H A R
   ;

INTEGER
   : I N T E G E R
   ;

BOOLEAN
   : B O O L E A N
   ;

ARRAY
   : A R R A Y
   ;

OF
   : O F
   ;

CONST
   : C O N S T
   ;


//Boolean values keywords
TRUE
   : T R U E
   ;

FALSE
   : F A L S E
   ;

//Boolean operators keywords
AND
   : A N D
   ;

OR
   : O R
   ;

NOT
   : N O T
   ;

//Arithmetic operators
LBRACKET
   : '['
   ;

RBRACKET
   : ']'
   ;

LPAREN
   : '('
   ;

RPAREN
   : ')'
   ;

STAR
   : '*'
   ;

SLASH
   : '/'
   ;

MOD
   : '%'
   ;

PLUS
   : '+'
   ;

MINUS
   : '-'
   ;

//Relational Operators
EQUALS
   : '='
   ;

NOTEQUALS
   : '<>'
   ;

GREATERTHAN
   : '>'
   ;

LESSTHAN
   : '<'
   ;

LESSTHANOREQUALS
   : '<='
   ;

GREATERTHANOREQUALS
   : '>='
   ;

//AssignmentOperator
ASSIGNMENT
   : ':='
   ;

SEMICOLUMN
   : ';'
   ;

COLON
   : ':'
   ;

COMMA
   : ','
   ;

IDENTIFIER
   : ('a' .. 'z' | 'A' .. 'Z' | '_') ('a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_')*
   ;

NUM_INT
   : ('0' .. '9')+
   ;

STRING_LITERAL
   : '\'' .*? '\''
   ;

PERIOD
   : '.'
   ;

PERIODPERIOD
   : '..'
   ;

COMMENT1
   : '(*' .*? '*)' -> skip
   ;

COMMENT2
   : '{' . *? '}' -> skip
   ;

WHITESPACES
   : [ \t\r\n] -> skip
   ;


fragment A
   : 'a' | 'A'
   ;


fragment B
   : 'b' | 'B'
   ;


fragment C
   : 'c' | 'C'
   ;


fragment D
   : 'd' | 'D'
   ;


fragment E
   : 'e' | 'E'
   ;


fragment F
   : 'f' | 'F'
   ;


fragment G
   : 'g' | 'G'
   ;


fragment H
   : 'h' | 'H'
   ;


fragment I
   : 'i' | 'I'
   ;


fragment J
   : 'j' | 'J'
   ;


fragment K
   : 'k' | 'K'
   ;


fragment L
   : 'l' | 'L'
   ;


fragment M
   : 'm' | 'M'
   ;


fragment N
   : 'n' | 'N'
   ;


fragment O
   : 'o' | 'O'
   ;


fragment P
   : 'p' | 'P'
   ;


fragment Q
   : 'q' | 'Q'
   ;


fragment R
   : 'r' | 'R'
   ;


fragment S
   : 's' | 'S'
   ;


fragment T
   : 't' | 'T'
   ;


fragment U
   : 'u' | 'U'
   ;


fragment V
   : 'v' | 'V'
   ;


fragment W
   : 'w' | 'W'
   ;


fragment X
   : 'x' | 'X'
   ;


fragment Y
   : 'y' | 'Y'
   ;


fragment Z
   : 'z' | 'Z'
   ;