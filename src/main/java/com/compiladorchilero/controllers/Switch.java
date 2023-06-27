/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.compiladorchilero.controllers;

import com.compiladorchilero.views.MainFrame;
import java.util.LinkedList;
import javax.swing.JTextArea;

/**
 *
 * @author ACER
 */
public class Switch implements Instruction{
    private Object expression;
    private LinkedList<Case> caseList;

    public Switch(Object expression, LinkedList<Case> caseList) {
        this.expression = expression;
        this.caseList = caseList;
    }
    
    @Override
    public Object execute(SymbolTable ts, JTextArea areaText, MainFrame mainFrame) {
        boolean found = false;
        SymbolTable localTable = new SymbolTable(mainFrame);
        localTable.addAll(ts);
        for(Case c: caseList){
            if(c.getValue()!=null && c.getValue().equals(expression)){
                c.execute(localTable, areaText, mainFrame);
                found = true;
            }
        }
        
        if(found == false){
            caseList.getLast().execute(localTable, areaText, mainFrame);
        }
        
        return null;
    }
}
