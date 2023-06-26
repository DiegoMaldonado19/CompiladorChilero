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
public class FunctionDeclaration implements Instruction {

    private String identifier;
    private Type type;
    private LinkedList<Instruction> parameterList;
    private LinkedList<Instruction> instructionList;

    public FunctionDeclaration(String identifier, LinkedList<Instruction> instructionList) {
        this.identifier = identifier;
        this.type = null;
        this.parameterList = null;
        this.instructionList = instructionList;
    }

    public FunctionDeclaration(String identifier, LinkedList<Instruction> parameterList, LinkedList<Instruction> instructionList) {
        this.identifier = identifier;
        this.parameterList = parameterList;
        this.instructionList = instructionList;
        this.type = null;
    }

    public FunctionDeclaration(String type, String identifier, LinkedList<Instruction> instructionList) {
        this.identifier = identifier;
        this.parameterList = null;
        this.instructionList = instructionList;
        switch (type) {
            case "cadena":
                this.type = Type.STRING;
                break;
            case "entero":
                this.type = Type.NUMBER;
                break;
            case "flotante":
                this.type = Type.FLOAT;
                break;
            case "caracter":
                this.type = Type.CHARACTER;
                break;
            case "booleano":
                this.type = Type.BOOLEAN;
                break;
            default:
                this.type = Type.INVALID;
                break;
        }
    }

    public FunctionDeclaration(String type, String identifier, LinkedList<Instruction> parameterList, LinkedList<Instruction> instructionList) {
        this.identifier = identifier;
        this.parameterList = parameterList;
        this.instructionList = instructionList;
        switch (type) {
            case "cadena":
                this.type = Type.STRING;
                break;
            case "entero":
                this.type = Type.NUMBER;
                break;
            case "flotante":
                this.type = Type.FLOAT;
                break;
            case "caracter":
                this.type = Type.CHARACTER;
                break;
            case "booleano":
                this.type = Type.BOOLEAN;
                break;
            default:
                this.type = Type.INVALID;
                break;
        }
    }

    @Override
    public Object execute(SymbolTable ts, JTextArea areaText, MainFrame mainFrame) {
        if (type == null && parameterList == null) {
            ts.add(new Symbol(null, identifier, null, instructionList));
        } else if (type == null && parameterList != null) {
            ts.add(new Symbol(null, identifier, parameterList, instructionList));
        } else if (type != null && parameterList == null) {
            ts.add(new Symbol(type, identifier, null, instructionList));
        } else if (type != null && parameterList != null) {
            ts.add(new Symbol(type, identifier, parameterList, instructionList));
        }
        return null;
    }
}
