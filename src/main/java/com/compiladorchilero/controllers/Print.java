/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.compiladorchilero.controllers;

import com.compiladorchilero.views.MainFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author ACER
 */
public class Print implements Instruction {

    private Operation content;
    private String id;
    private OperationType type;

    public Print(Operation content) {
        this.content = content;
    }
    
    public Print(String id, Operation content, OperationType type){
        this.id = id;
        this.type = type;
        this.content = content;
    }

    @Override
    public Object execute(SymbolTable ts, JTextArea areaText, MainFrame mainFrame) {
        if (this.type == OperationType.IDENTIFIER) {
            for (Symbol sym : ts) {
                if (sym.getId().equals(id)) {
                    areaText.append(content.execute(ts, areaText, mainFrame) + "\n");
                } else {
                    JOptionPane.showMessageDialog(mainFrame, "Variable no existe en este scope.");
                }
            }
        } else {
            areaText.append(content.execute(ts, areaText, mainFrame) + "\n");
        }
        return null;
    }
}
