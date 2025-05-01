grammar LRec;

@header {
package antlr;
}

expr: LET IDENT EQ base_expr IN expr # Let
    | LET FUN IDENT IDENT EQ base_expr IN expr # LetFun
    | LET REC IDENT IDENT EQ base_expr IN expr # LetRec
    | base_expr # BaseExpr
    ;

base_expr:
      base_expr DIV base_expr # Div
    | base_expr MUL base_expr # Mul
    | base_expr ADD base_expr # Add
    | base_expr SUB base_expr # Sub
    | base_expr EQQ base_expr # Eq
    | base_expr LT base_expr # Lt
    | base_expr GT base_expr # Gt
    | base_expr AND base_expr # And
    | base_expr OR base_expr # Or
    | IF base_expr THEN expr ELSE expr # Cond
    | prim prim # App
    | prim # Fact 
    ;

prim: BACKSLASH IDENT DOT expr # Lambda
    | REC IDENT '(' IDENT ')' DOT expr # Rec
    | IDENT # Var
    | INT # Int
    | TRUE # True
    | FALSE # False
    | '(' expr ')' # Parens
    ;


INT : [0-9]+ ;

MUL: '*' ;
DIV: '/' ;
SUB: '-' ;
ADD: '+' ;
EQ: '=';
BACKSLASH: '\\';
DOT: '.';
LET: 'let';
IN: 'in';
REC: 'rec';
FUN: 'fun';
TRUE: 'true';
FALSE: 'false';
EQQ: '==' ;
AND: '&&' ;
OR: '||' ;
LT: '<' ;
GT: '>' ;
IF: 'if' ;
THEN: 'then' ;
ELSE: 'else' ;
IDENT: [a-z][a-zA-Z0-9]*;
WS : [ \t\r\n]+ -> skip ;