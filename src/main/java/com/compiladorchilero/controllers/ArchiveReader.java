/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.compiladorchilero.controllers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JTextArea;

/**
 *
 * @author CARIadmin
 */
public class ArchiveReader {
    public void readFile(File archive, JTextArea text) throws FileNotFoundException, IOException {
        FileReader fr = new FileReader(archive);
        BufferedReader br = new BufferedReader(fr);
   
        String line;
    
        while((line = br.readLine()) != null){
            text.append(line+"\n");
        }
        fr.close();
    }
}
