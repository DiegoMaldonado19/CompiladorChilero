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
public class Symbol {

    private final Type type;
    private final String id;
    private Object value;
    private LinkedList<Instruction> paramList;
    private LinkedList<Instruction> instructionList;

    public Symbol(String id, Type type) {
        this.type = type;
        this.id = id;
    }

    public Symbol(Type type, String id, LinkedList<Instruction> paramList, LinkedList<Instruction> instructionList) {
        this.type = type;
        this.id = id;
        this.paramList = paramList;
        this.instructionList = instructionList;
        this.value = null;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Type getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public LinkedList<Instruction> getParamList() {
        return paramList;
    }

    public void setParamList(LinkedList<Instruction> paramList) {
        this.paramList = paramList;
    }

    public LinkedList<Instruction> getInstructionList() {
        return instructionList;
    }

    public void setInstructionList(LinkedList<Instruction> instructionList) {
        this.instructionList = instructionList;
    }
    
    
}
