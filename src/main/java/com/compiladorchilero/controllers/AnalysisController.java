/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.compiladorchilero.controllers;

import com.compiladorchilero.analyzers.*;
import com.compiladorchilero.models.Token;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author ACER
 */
public class AnalysisController {
    private LinkedList<Instruction> AST;
    public void startAnalysis(JTextArea writingArea, JTextArea errorLogArea, JTextArea resultArea, JFrame mainFrame) {
        StringReader input = new StringReader(writingArea.getText());
        Lexer lexer = new Lexer(input);
        Parser parser = new Parser(lexer, writingArea);

        try {
            parser.parse();
            AST=parser.getAST();
            fillTextAreas(errorLogArea, resultArea, parser.getErrorList(), lexer.getErrorList());
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(mainFrame, "Error encontrado durante la tarea de parsing");
        }
        
        executeAST(AST, mainFrame);
        this.AST.clear();
    }
    
    private void fillTextAreas(JTextArea errorLogArea, JTextArea resultArea, LinkedList<String> syntaxErrors, ArrayList<String> lexicalErrors){
       
        errorLogArea.setText("");
        resultArea.setText("");
        
        errorLogArea.append("Errores Lexicos: \n");
        for(String error:lexicalErrors){
            errorLogArea.append(error+"\n");
        }
        
        errorLogArea.setText("Errores Sintacticos: \n");
        for(String error:syntaxErrors){
            errorLogArea.append(error+"\n");
        }
    }
    
    private static void executeAST(LinkedList<Instruction> ast, JFrame mainFrame) {
        if(ast==null){
            JOptionPane.showMessageDialog(mainFrame, "No es posible ejecutar las instrucciones porque el árbol no fue cargado de forma adecuada por la existencia de errores léxicos o sintácticos.");
            return;
        }
        SymbolTable ts=new SymbolTable();

        for(Instruction ins:ast){
            if(ins!=null)
                ins.execute(ts);
        }
    }
}
