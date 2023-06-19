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
public class Switch implements Instruction{
    private Object expression;
    private LinkedList<Instruction> caseList;

    public Switch(Object expression, LinkedList<Instruction> caseList) {
        this.expression = expression;
        this.caseList = caseList;
    }
    
    @Override
    public Object execute(SymbolTable ts) {
        SymbolTable localTable = new SymbolTable();
        localTable.addAll(ts);
        for(Instruction in: caseList){
            in.execute(localTable);
        }
        return null;
    }
}
