/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.compiladorchilero.controllers;

import com.compiladorchilero.analyzers.*;
import com.compiladorchilero.models.Token;
import java.io.StringReader;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author ACER
 */
public class AnalysisController {

    public void startAnalysis(JTextArea writingArea, JTextArea errorLogArea, JTextArea resultArea, JFrame mainFrame) {
        StringReader input = new StringReader(writingArea.getText());
        Lexer lexer = new Lexer(input);
        Parser parser = new Parser(lexer);

        try {
            parser.parse();
            fillTextAreas(errorLogArea, resultArea, parser.getTokenList(), parser.getErrorList());
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(mainFrame, "Error encontrado durante la tarea de parsing");
        }
    }
    
    private void fillTextAreas(JTextArea errorLogArea, JTextArea resultArea, ArrayList<Token> tokenList, ArrayList<String> errorList){
       
        errorLogArea.setText("");
        resultArea.setText("");
        
        for(Token token:tokenList){
            resultArea.append(token.getLexeme()+"\n");
        }
        
        for(String error:errorList){
            errorLogArea.append(error+"\n");
        }
    }
}
