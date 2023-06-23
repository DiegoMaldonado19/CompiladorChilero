/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.compiladorchilero.controllers;

import com.compiladorchilero.views.MainFrame;
import javax.swing.JTextArea;

/**
 *
 * @author ACER
 */
public class Print implements Instruction {

    private final Operation content;

    public Print(Operation content) {
        this.content = content;
    }

    @Override
    public Object execute(SymbolTable ts, JTextArea areaText, MainFrame mainFrame) {
        /*
        textArea.append(content.execute(ts).toString()+"\n");
         */
        System.out.println(content.execute(ts, areaText, mainFrame).toString() + "\n");
        return null;
    }
}
