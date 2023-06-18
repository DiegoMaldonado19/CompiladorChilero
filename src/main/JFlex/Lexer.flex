/* Declaracion de paquetes */
package com.compiladorchilero.analyzers;

import java_cup.runtime.Symbol;
import java.util.*;
import com.compiladorchilero.models.*;

%%

/* Codigo de usuario */
%{
    StringBuffer string_buff = new StringBuffer();

    private ArrayList<String>  errorList;  

    private Symbol symbol(int type, Object value) {
        return new Symbol(type, new Token(value.toString(), yyline + 1, yycolumn + 1));
    }

    private Symbol symbol(int type) {
        return new Symbol(type, new Token(null, yyline + 1, yycolumn + 1));
    }

    private void error(String lexeme, String message){
        errorList.add(String.format("Error lexico en el texto: , %s, linea %d, columna %d, %s)", lexeme, yyline+1, yycolumn+1, message));
    }

    public ArrayList<String> getErrorList(){
        return errorList;
    }
%}

/* Codigo al iniciar analizador */
%init{
    errorList = new ArrayList();
    yyline = 1; 
    yychar = 1;    
%init}

/* Codigo que se ejecuta el finalizar el analisis */
%eofval{
    return token(EOF);
%eofval}

/* Declaracion de atributos que tendra nuestra clase */
%public
%class Lexer
%cup
%line
%column
%type java_cup.runtime.Symbol
%unicode

/* Macros */
digit = [\d]+
decimal = [\d]+[\.][\d]+
identifier = ([\_][a-zA-Z][a-zA-Z0-9]+)|([a-zA-Z]([A-Za-z0-9]|[\_])+)
whitespace = [\s]+
newline = [\n]
character_const = [\'][A-Za-z0-9][\']

/* Palabras reservadas */
int = "entero"
string = "cadena"
float = "flotante"
character = "caracter"
if = "si"
else = "sino"
for = "para"
while = "mientras"
read = "Leer"
write = "Escribir"
switch = "switch"
case = "caso"
break = "break"

/* Estados */
%state STRING
%state COMMENT

%%

<YYINITIAL>{
    {whitespace}                  {/*ignore*/}
    [\"]                          {   string_buff.setLength(0); yybegin(STRING); }
    "/*"                          { yybegin(COMMENT); }
    [\{]                          { return symbol(ParserSym.LBRACE, yytext()); }
    [\}]                          { return symbol(ParserSym.RBRACE, yytext()); }
    [\:]                          { return symbol(ParserSym.COLON, yytext()); }
    [\,]                          { return symbol(ParserSym.COMMA, yytext()); }
    [\;]                          { return symbol(ParserSym.SEMICOLON, yytext()); }
    [\(]                          { return symbol(ParserSym.LPAREN, yytext()); }
    [\)]                          { return symbol(ParserSym.RPAREN, yytext()); }
    [\=]                          { return symbol(ParserSym.EQUALS, yytext()); }
    [\+]                          { return symbol(ParserSym.PLUS, yytext()); }
    "++"                          { return symbol(ParserSym.INCREMENT, yytext()); }
    "--"                          { return symbol(ParserSym.DECREMENT, yytext()); }
    [\-]                          { return symbol(ParserSym.MINUS, yytext()); }
    [\*]                          { return symbol(ParserSym.MULT, yytext()); }
    [\/]                          { return symbol(ParserSym.DIV, yytext()); }
    [\<]                          { return symbol(ParserSym.LT, yytext()); }    /*<=*/
    [\>]                          { return symbol(ParserSym.GT, yytext()); }    /*>=*/
    [\!]                          { return symbol(ParserSym.EXCLAMATION, yytext()); }
    [\|\|]                        { return symbol(ParserSym.OR, yytext()); }
    {character_const}             { return symbol(ParserSym.CHARACTER_CONST, yytext()); }
    {character}                   { return symbol(ParserSym.CHARACTER); }
    {int}                         { return symbol(ParserSym.INT, yytext()); }
    {string}                      { return symbol(ParserSym.STRING, yytext()); }
    {float}                       { return symbol(ParserSym.FLOAT, yytext()); }
    {if}                          { return symbol(ParserSym.IF, yytext()); }
    {else}                        { return symbol(ParserSym.ELSE, yytext()); }
    {for}                         { return symbol(ParserSym.FOR, yytext()); }
    {while}                       { return symbol(ParserSym.WHILE, yytext()); }
    {read}                        { return symbol(ParserSym.READ, yytext()); }
    {write}                       { return symbol(ParserSym.WRITE, yytext()); }

    {identifier}                  { return symbol(ParserSym.IDENTIFIER, yytext()); }
    {digit}                       { return symbol(ParserSym.INT_CONST, yytext()); }
    {decimal}                     { return symbol(ParserSym.FLOAT_CONST, yytext()); }
}

/* Reglas para constantes string */
<STRING>{
    \"               {  yybegin(YYINITIAL);
                        /*
                        AbstractSymbol string = AbstractTable.stringtable.addString(string_buf.toString());
                        */
                        return symbol(ParserSym.STR_CONST, string_buff.toString()); }
                        

    [^\n\r\"\\]+     { string_buff.append(yytext()); }

    \\b              { string_buff.append('\b'); }
    \\n              { string_buff.append('\n'); }
    \\t              { string_buff.append('\t'); }
    \\f              { string_buff.append('\f'); }

    \\r              { string_buff.append('\r'); }
    \\\"             { string_buff.append('\"'); }
    \\               { string_buff.append('\\'); }

    \\0            {    yybegin(YYINITIAL);
                        error(yytext(), "Cadena contiene un caracter nulo"); }

   <<EOF>>          {   yybegin(YYINITIAL); 
                        error(yytext(), "No se encontró simbolo para finalizar la cadena \""); } 

}

/* Reglas para comentarios */
<COMMENT>{
    [\*\/]           { yybegin(YYINITIAL); }

    .                { /*ignore */ }

    {newline}        { /*ignore*/ }

    {whitespace}     { /*ignore*/ } 

    <<EOF>>          {  yybegin(YYINITIAL); 
                        error(yytext(), "No se encontró simbolo de final de comentario */"); }  
}

/* Reglas para errores */
[^]                  {  error(yytext(), "Simbolo no encontrado dentro de las especificaciones lexicas."); }

<<EOF>>         { return symbol(ParserSym.EOF); }