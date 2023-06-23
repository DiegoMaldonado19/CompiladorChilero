/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.compiladorchilero.controllers;

import com.compiladorchilero.views.MainFrame;
import javax.swing.JTextArea;

/**
 *
 * @author ACER
 */
public interface Instruction {
    public Object execute(SymbolTable ts, JTextArea areaText, MainFrame mainFrame);
}
