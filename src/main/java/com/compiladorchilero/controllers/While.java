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
public class While implements Instruction{
    
    private final Operation condition;
    private final LinkedList<Instruction> instructionList;

    public While(Operation a, LinkedList<Instruction> b) {
        this.condition=a;
        this.instructionList=b;
    }

    @Override
    public Object execute(SymbolTable ts) {
        while((Boolean)condition.execute(ts)){
            SymbolTable localTable=new SymbolTable();
            localTable.addAll(ts);
            for(Instruction ins:instructionList){
                ins.execute(localTable);
            }
        }
        return null;
    }   
}