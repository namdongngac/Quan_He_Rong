/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary2;

import java.awt.Component;
import java.util.*;
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
//import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
/**
 *
 * @author admin
 */
public class DictionaryManagement {
    
    	DefaultListModel<String> model = new DefaultListModel<>();
        public void insertFromFile(Dictionary Dic){
            // tao doi tuong lien ket nguon du lien
            
            Word[] words = new Word[200000];
            TreeMap tm = new TreeMap();
            File f = new File("dictionaries.dat");
            try(Scanner sc=new Scanner(f)) {                
                // doc du lieu va luu vào mang
                String line;
                int i=0;
                while (sc.hasNext()){
                    line = sc.nextLine() ;
                    
                    String temp[] = line.split("\t");
                    
                    String wordtarget = temp[0];
                    String wordexplain = temp[1];
                    words[i] = new Word(wordtarget,wordexplain);
                    tm.put(wordtarget, wordexplain);
                    model.addElement(wordtarget);                  
                    i++;
                }
                Dic.setN(i);
                Dic.Dictionary(words);
                Dic.Dictionnary(tm);               
                
            } 
            catch (IOException ex) {
                Component rootPane = null;
                JOptionPane.showMessageDialog(rootPane, ex);
            }
        }
                
        public void update(Dictionary Dic) throws IOException {
		File file = new File("dictionaries.dat");	
		//Map->file
		try(PrintWriter pw = new PrintWriter(file)) {		
			Dic.tm.forEach((key,vaulue)->pw.write(key+"\t"+vaulue+"\r\n"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block	
		}
		this.insertFromFile(Dic);
	}
       
        
}
