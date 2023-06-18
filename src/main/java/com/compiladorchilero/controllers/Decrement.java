/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.compiladorchilero.controllers;

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
    public Object execute(SymbolTable ts) {
        Object tmp = ts.getValue(id.toString());
        ts.setValue(id, ((Double) tmp - 1));
        return tmp;
    }
}
