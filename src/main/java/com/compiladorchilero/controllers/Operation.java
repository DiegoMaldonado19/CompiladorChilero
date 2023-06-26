/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.compiladorchilero.controllers;

import com.compiladorchilero.views.MainFrame;
import javax.swing.JOptionPane;
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
    
    public Operation(Double a, OperationType type){
        this.value = a;
        this.type = type.FLOAT;
    }

    public OperationType getType() {
        return type;
    }

    @Override
    public Object execute(SymbolTable ts, JTextArea areaText, MainFrame mainFrame) {
        double op = 0;
        boolean boolOp = false;

        /* ======== OPERACIONES ARITMETICAS ======== */
        if (type == this.type.DIVISION) {
            try {
                return (Double) leftOperator.execute(ts, areaText, mainFrame) / (Double) rightOperator.execute(ts, areaText, mainFrame);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(mainFrame, "Error encontrado durante la operacion");
            }
            return op;
        } else if (type == this.type.MULTIPLICATION) {
            try {
                op = (Double) leftOperator.execute(ts, areaText, mainFrame) * (Double) rightOperator.execute(ts, areaText, mainFrame);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(mainFrame, "Error encontrado durante la operacion");
            }
            return op;
        } else if (type == this.type.SUBSTRACTION) {
            try {
                op = (Double) leftOperator.execute(ts, areaText, mainFrame) - (Double) rightOperator.execute(ts, areaText, mainFrame);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(mainFrame, "Error encontrado durante la operacion");
            }
            return op;
        } else if (type == this.type.ADDITION) {
            try {
                op = (Double) leftOperator.execute(ts, areaText, mainFrame) + (Double) rightOperator.execute(ts, areaText, mainFrame);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(mainFrame, "Error encontrado durante la operacion");
            }
            return op;
        } else if (type == this.type.NEGATIVE) {
            try {
                op = (Double) leftOperator.execute(ts, areaText, mainFrame) * -1;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(mainFrame, "Error encontrado durante la operacion");
            }
            return op;
        } /* ======== OPERACIONES UNARIOS ======== */ else if (type == this.type.NUMBER) {
            return new Double(value.toString());
        } else if(type == this.type.FLOAT){
            return new Double(value.toString());
        }
        else if (type == this.type.IDENTIFIER) {
            return ts.getValue(value.toString());
        } else if (type == this.type.STRING) {
            return value.toString();
        } else if (type == this.type.CHARACTER) {
            return generateChar();
        } /* ======== OPERACIONES RELACIONALES ======== */ else if (type == this.type.GREATHER_THAN) {
            try {
                boolOp = ((Double) leftOperator.execute(ts, areaText, mainFrame)) > ((Double) rightOperator.execute(ts, areaText, mainFrame));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(mainFrame, "Error encontrado durante la operacion");
            }
            return boolOp;
        } else if (type == this.type.LESS_THAN) {
            try {
                boolOp = ((Double) leftOperator.execute(ts, areaText, mainFrame)) < ((Double) rightOperator.execute(ts, areaText, mainFrame));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(mainFrame, "Error encontrado durante la operacion");
            }
            return boolOp;
        } else if (type == this.type.EQUALS_EQUALS) {
            try {
                boolOp = leftOperator.execute(ts, areaText, mainFrame) == rightOperator.execute(ts, areaText, mainFrame);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(mainFrame, "Error encontrado durante la operacion");
            }
            return boolOp;
        } else if (type == this.type.GREATHER_THAN_EQUALS) {
            try {
                boolOp = ((Double) leftOperator.execute(ts, areaText, mainFrame)).doubleValue() >= ((Double) rightOperator.execute(ts, areaText, mainFrame)).doubleValue();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(mainFrame, "Error encontrado durante la operacion");
            }
            return boolOp;
        } else if (type == this.type.LESS_THAN_EQUALS) {
            try {
                boolOp = ((Double) leftOperator.execute(ts, areaText, mainFrame)).doubleValue() <= ((Double) rightOperator.execute(ts, areaText, mainFrame)).doubleValue();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(mainFrame, "Error encontrado durante la operacion");
            }
            return boolOp;
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
        String cad = this.value.toString();
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
