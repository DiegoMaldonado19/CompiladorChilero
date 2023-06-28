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
public class CallFunction implements Instruction{
    private String id;

    public CallFunction(String id){
        this.id=id;
    }

    @Override
    public Object execute(SymbolTable ts, JTextArea areaText, MainFrame mainFrame) {
        SymbolTable localTable = new SymbolTable(mainFrame);
        localTable.addAll(ts);
        LinkedList<Instruction> instructionList;
        for(Symbol sym: ts){
            if(sym.getId().equals(id)){
                instructionList = sym.getInstructionList();
               for(Instruction in: instructionList){
                   in.execute(localTable, areaText, mainFrame);
               }
            }
        }
        return null;
    }  
}
