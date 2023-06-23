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
public class Case implements Instruction{
    private Operation value;
    private LinkedList<Instruction> instructionList;

    public Case(Operation value, LinkedList<Instruction> instructionList) {
        this.value = value;
        this.instructionList = instructionList;
    }
    
    public Case(LinkedList<Instruction> instructionList){
        this.value = null;
        this.instructionList = instructionList;
    }

    @Override
    public Object execute(SymbolTable ts, JTextArea areaText, MainFrame mainFrame) {
       SymbolTable localTable = new SymbolTable();
        localTable.addAll(ts);
        for(Instruction in: instructionList){
            in.execute(localTable, areaText, mainFrame);
        }
        return null;
    }
    
    
}
