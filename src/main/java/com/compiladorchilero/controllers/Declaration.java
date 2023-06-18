/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.compiladorchilero.controllers;

/**
 *
 * @author ACER
 */
public class Declaration implements Instruction{

    private final String id;
    Type type;

    public Declaration(String a, Type t) {
        id = a;
        type = t;
    }

    @Override
    public Object execute(SymbolTable ts) {
        ts.add(new Symbol(id, type));
        return null;
    }
}
