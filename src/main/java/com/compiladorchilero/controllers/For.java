/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.compiladorchilero.controllers;

import java.util.LinkedList;

/**
 *
 * @author ACER
 */
public class For implements Instruction{
    private Operation begin;
    private Operation end;
    private LinkedList<Instruction> instructionList;

    public For(Operation begin, Operation end, LinkedList<Instruction> instructionList) {
        this.begin = begin;
        this.end = end;
        this.instructionList = instructionList;
    }
    
    @Override
    public Object execute(SymbolTable ts){
        int beginTmp = Integer.valueOf(String.valueOf(begin));
        int endTmp = Integer.valueOf(String.valueOf(end));
        for(int i=beginTmp; i<endTmp; i++){
            SymbolTable localTable=new SymbolTable();
            localTable.addAll(ts);
            for(Instruction ins:instructionList){
                ins.execute(localTable);
            }
        }
        return null;
    }
    
}
