/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.compiladorchilero.controllers;

import javax.swing.JTextArea;

/**
 *
 * @author ACER
 */
public class Print implements Instruction{
  
    private final Operation content;
    private JTextArea textArea;
  
    public Print(Operation content, JTextArea textArea) {
        this.content = content;
    }

    @Override
    public Object execute(SymbolTable ts) {
        /*
        textArea.append(content.execute(ts).toString()+"\n");
        */
        System.out.println(content.execute(ts).toString()+"\n");
        return null;
    }
}
