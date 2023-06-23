/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.compiladorchilero.controllers;

import com.compiladorchilero.views.MainFrame;
import javax.swing.JTextArea;

/**
 *
 * @author ACER
 */
public class Operation implements Instruction {

    private OperationType type;
    private Operation leftOperator;
    private Operation rightOperator;
    private Object value;

    public Operation(Operation leftOperator, Operation rightOperator, OperationType type) {
        this.type = type;
        this.leftOperator = leftOperator;
        this.rightOperator = rightOperator;
    }

    public Operation(Operation leftOperator, OperationType type) {
        this.type = type;
        this.leftOperator = leftOperator;
    }

    public Operation(String a, OperationType type) {
        this.value = a;
        this.type = type;
    }

    public Operation(Double a) {
        this.value = a;
        this.type = type.NUMBER;
    }

    @Override
    public Object execute(SymbolTable ts, JTextArea areaText, MainFrame mainFrame) {
        double op=0;

        /* ======== OPERACIONES ARITMETICAS ======== */
        if (type == this.type.DIVISION) {
            try {
                op = (Double) leftOperator.execute(ts,areaText, mainFrame) / (Double) rightOperator.execute(ts, areaText, mainFrame);
            } catch (Exception e) {
                
            } 
            
            return op;

        } else if (type == this.type.MULTIPLICATION) {
            return (Double) leftOperator.execute(ts,areaText,mainFrame) * (Double) rightOperator.execute(ts,areaText,mainFrame);
        } else if (type == this.type.SUBSTRACTION) {
            return (Double) leftOperator.execute(ts,areaText,mainFrame) - (Double) rightOperator.execute(ts,areaText,mainFrame);
        } else if (type == this.type.ADDITION) {
            return (Double) leftOperator.execute(ts,areaText,mainFrame) + (Double) rightOperator.execute(ts,areaText,mainFrame);
        } else if (type == this.type.NEGATIVE) {
            return (Double) leftOperator.execute(ts,areaText,mainFrame) * -1;

        } /* ======== OPERACIONES UNARIOS ======== */ else if (type == this.type.NUMBER) {
            return new Double(value.toString());
        } else if (type == this.type.IDENTIFIER) {
            return ts.getValue(value.toString());
        } else if (type == this.type.STRING) {
            return value.toString();
        } else if (type == this.type.CHARACTER) {
            return generateChar();
        } /* ======== OPERACIONES RELACIONALES ======== */ else if (type == this.type.GREATHER_THAN) {
            return ((Double) leftOperator.execute(ts,areaText,mainFrame)).doubleValue() > ((Double) rightOperator.execute(ts,areaText,mainFrame)).doubleValue();
        } else if (type == this.type.LESS_THAN) {
            return ((Double) leftOperator.execute(ts,areaText,mainFrame)).doubleValue() < ((Double) rightOperator.execute(ts,areaText,mainFrame)).doubleValue();
        } else if (type == this.type.EQUALS_EQUALS) {
            return leftOperator.execute(ts,areaText,mainFrame) == rightOperator.execute(ts,areaText,mainFrame);
        } else if (type == this.type.GREATHER_THAN_EQUALS) {
            return ((Double) leftOperator.execute(ts,areaText,mainFrame)).doubleValue() >= ((Double) rightOperator.execute(ts,areaText,mainFrame)).doubleValue();
        } else if (type == this.type.LESS_THAN_EQUALS) {
            return ((Double) leftOperator.execute(ts,areaText,mainFrame)).doubleValue() <= ((Double) rightOperator.execute(ts,areaText,mainFrame)).doubleValue();
        } else if (type == this.type.BOOLEAN) {
            if (String.valueOf(value).equals("true")) {
                return true;
            } else if (String.valueOf(value).equals("false")) {
                return false;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    /**
     * Metodo que obtiene un valor char del Token CARACTER
     *
     * @return un valor de tipo char obtenido de una cadena
     */
    private char generateChar() {
        String cad = this.value.toString().substring(1, this.value.toString().length() - 1);
        switch (cad) {
            case "\\n":
                return '\n';
            case "\\'":
                return '\'';
            case "\\\"":
                return '\"';
            case "\\\\":
                return '\\';
            default:
                return cad.isEmpty() ? '\0' : cad.charAt(0);
        }
    }
}
