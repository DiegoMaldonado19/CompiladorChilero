/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.compiladorchilero.controllers;

import java.util.LinkedList;

/**
 *
 * @author ACER
 */
public class SymbolTable extends LinkedList<Symbol> {

    public SymbolTable() {
        super();
    }

    Object getValue(String id) {
        for (Symbol s : this) {
            if (s.getId().equals(id)) {
                return s.getValue();
            }
        }
        System.out.println("La variable " + id + " no existe en este ámbito.");
        return "Desconocido";
    }

    void setValue(String id, Object value) {
        for (Symbol s : this) {
            if (s.getId().equals(id)) {
                s.setValue(value);
                return;
            }
        }
        System.out.println("La variable " + id + " no existe en este ámbito, por lo "
                + "que no puede asignársele un valor.");
    }
}
