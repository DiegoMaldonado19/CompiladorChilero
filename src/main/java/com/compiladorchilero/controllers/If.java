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
public class If implements Instruction{

    private final Operation condition;
    private final LinkedList<Instruction> instructionList;
    private LinkedList<Instruction> elseInstructionList;
    private LinkedList<Instruction> elseIfInstructionList;

    public If(Operation a, LinkedList<Instruction> b) {
        this.condition = a;
        this.instructionList = b;
    }

    public If(Operation a, LinkedList<Instruction> b, LinkedList<Instruction> c) {
        this.condition = a;
        this.instructionList = b;
        this.elseInstructionList = c;
    }

    public If(Operation a, LinkedList<Instruction> b, LinkedList<Instruction> l, LinkedList<Instruction> c) {
        this.condition = a;
        this.instructionList = b;
        this.elseIfInstructionList = l;
        this.elseInstructionList = c;
    }

    @Override
    public Object execute(SymbolTable ts) {
        if ((Boolean) condition.execute(ts)) {
            SymbolTable localTable = new SymbolTable();
            localTable.addAll(ts);
            for (Instruction in : instructionList) {
                in.execute(localTable);
            }
            return true;
        } else {
            boolean bandera = false;
            if (elseIfInstructionList != null) {
                for (Instruction in : elseIfInstructionList) {
                    if ((boolean) in.execute(ts)) {
                        bandera = true;
                        break;
                    }
                }
            }
            if (elseInstructionList != null && !bandera) {
                SymbolTable localTable = new SymbolTable();
                localTable.addAll(ts);
                for (Instruction in : elseInstructionList) {
                    in.execute(localTable);
                }
            }
        }
        return false;
    }
}
