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
public class Increment implements Instruction{

    private final String id;

    public Increment(String id) {
        this.id = id;
    }

    /**
     * Metodo que ejecuta el incremento de una variables mediante el incremento
     * postfijo, por lo tanto incrementa la variable en 1 y retorna el valor
     * antiguo.
     *
     * @param ts tabla de símbolos del ámbito padre de la sentencia asignación.
     * @return el valor anterior al incremento.
     */
    @Override
    public Object execute(SymbolTable ts,JTextArea areaText, MainFrame mainFrame) {
        Object tmp = ts.getValue(id.toString());
        ts.setValue(id, ((Double) tmp + 1));
        return tmp;
    }
}
