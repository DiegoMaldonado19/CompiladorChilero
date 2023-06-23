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
    public Object execute(SymbolTable ts, JTextArea areaText, MainFrame mainFrame) {
        if ((Boolean) condition.execute(ts, areaText, mainFrame)) {
            SymbolTable localTable = new SymbolTable();
            localTable.addAll(ts);
            for (Instruction in : instructionList) {
                in.execute(localTable, areaText, mainFrame);
            }
            return true;
        } else {
            boolean bandera = false;
            if (elseIfInstructionList != null) {
                for (Instruction in : elseIfInstructionList) {
                    if ((boolean) in.execute(ts, areaText, mainFrame)) {
                        bandera = true;
                        break;
                    }
                }
            }
            if (elseInstructionList != null && !bandera) {
                SymbolTable localTable = new SymbolTable();
                localTable.addAll(ts);
                for (Instruction in : elseInstructionList) {
                    in.execute(localTable, areaText, mainFrame);
                }
            }
        }
        return false;
    }
}
