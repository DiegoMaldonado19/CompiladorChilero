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
public class Read implements Instruction{
   
    private final String id;

    public Read(String a) {
        this.id = a;
    }

    @Override
    public Object execute(SymbolTable ts, JTextArea textArea, MainFrame mainFrame) {
        String name = JOptionPane.showInputDialog("Ingrese el contenido solicitado en el Area de Texto");
        for(Symbol sym: ts){
            if(sym.getId().equals(id)){
               if(name!=null){
                  ts.setValue(id, (Object)name);
               } else {
                  JOptionPane.showMessageDialog(mainFrame, "No ingreso ningun valor.");
               } 
            } else {
                JOptionPane.showMessageDialog(mainFrame, "Variable no existe en este scope.");
            }
        }
        return null;
    }
}
