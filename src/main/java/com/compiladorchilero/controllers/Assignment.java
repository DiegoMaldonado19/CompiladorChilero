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
public class Assignment implements Instruction {

    private final String id;
    private final Operation value;

    public Assignment(String a, Operation b) {
        this.id = a;
        this.value = b;
    }

    @Override
    public Object execute(SymbolTable ts, JTextArea areaText, MainFrame mainFrame) {
        ts.setValue(id, value.execute(ts, areaText, mainFrame));
        return null;
    }
}
