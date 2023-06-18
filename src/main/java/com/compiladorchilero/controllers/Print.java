/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.compiladorchilero.controllers;

/**
 *
 * @author ACER
 */
public class Print implements Instruction{
  
    private final Instruction content;
  
    public Print(Instruction content) {
        this.content = content;
    }

    @Override
    public Object execute(SymbolTable ts) {
        System.out.println(content.execute(ts).toString());
        return null;
    }
}
