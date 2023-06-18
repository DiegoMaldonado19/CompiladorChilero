/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.compiladorchilero.controllers;

/**
 *
 * @author ACER
 */
public class Symbol {

    private final Type type;
    private final String id;
    private Object value;

    public Symbol(String id, Type type) {
        this.type = type;
        this.id = id;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Type getType() {
        return type;
    }

    public String getId() {
        return id;
    }
}
