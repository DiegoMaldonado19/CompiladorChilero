/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.compiladorchilero.controllers;

import com.compiladorchilero.views.MainFrame;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author ACER
 */
public class SymbolTable extends LinkedList<Symbol> {
    private MainFrame mainFrame;

    public SymbolTable(MainFrame mainFrame) {
        super();
        this.mainFrame = mainFrame;
    }

    Object getValue(String id) {
        for (Symbol s : this) {
            if (s.getId().equals(id)) {
                return s.getValue();
            }
        }
        JOptionPane.showMessageDialog(mainFrame, "La variable " + id.toString() + " no existe en este ámbito.");
        return "Desconocido";
    }

    void setValue(String id, Object value) {
        for (Symbol s : this) {
            if (s.getId().equals(id)) {
                s.setValue(value);
                return;
            }
        }
        JOptionPane.showMessageDialog(mainFrame, "La variable " + id.toString() + " no existe en este ámbito, por lo "
                + "que no puede asignársele un valor.");
    }
}
