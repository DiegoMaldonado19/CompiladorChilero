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
public class Decrement implements Instruction {

    private final String id;

    public Decrement(String id) {
        this.id = id;
    }

    @Override
    public Object execute(SymbolTable ts, JTextArea areaText, MainFrame mainFrame) {
        Object tmp = ts.getValue(id.toString());
        ts.setValue(id, ((Double) tmp - 1));
        return tmp;
    }
}
