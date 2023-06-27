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
public class For implements Instruction{
    private int begin;
    private int end;
    private LinkedList<Instruction> instructionList;

    public For(int begin, int end, LinkedList<Instruction> instructionList) {
        this.begin = begin;
        this.end = end;
        this.instructionList = instructionList;
    }
    
    @Override
    public Object execute(SymbolTable ts, JTextArea areaText, MainFrame mainFrame){
        int beginTmp = Integer.valueOf(String.valueOf(begin));
        int endTmp = Integer.valueOf(String.valueOf(end));
        for(int i=beginTmp; i<=endTmp; i++){
            SymbolTable localTable=new SymbolTable();
            localTable.addAll(ts);
            for(Instruction ins:instructionList){
                ins.execute(localTable, areaText, mainFrame);
            }
        }
        return null;
    }
    
}
