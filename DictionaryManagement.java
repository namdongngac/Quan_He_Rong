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
                
        
	public void dictionaryLookup(Dictionary Dic){
            System.out.print("Nhap tu muon tim : ");
            Scanner scan = new Scanner(System.in);
            String w = scan.nextLine();                        
            if(Dic.tm.get(w)!=null)
                System.out.println(Dic.tm.get(w));  
            else System.out.println("Tu khong ton tai trong tu dien");
        }
        public void dictionaryAdd(Dictionary Dic){
            Scanner scan = new Scanner(System.in);
            System.out.print("Nhap word_target : ");
            String wordtarget = scan.nextLine();
            System.out.print("Nhap word_explain : ");
            String wordexplain = scan.nextLine();
            if(Dic.tm.containsKey(wordtarget)){
                System.out.println("Từ đã tồn tại");
            }
            else{
                Dic.tm.put(wordtarget, wordexplain);
                System.out.println("Them tu thanh cong");
            }            
	
        }
        public void dictionaryDelete(Dictionary Dic){
            Scanner scan = new Scanner(System.in);
            System.out.print("Nhap tu muon xoa : ");
            String wordtarget = scan.nextLine();
            if(Dic.tm.containsKey(wordtarget)){
                Dic.tm.remove(wordtarget);
                System.out.println("Xoa tu thanh cong");
            }
            else System.out.println("Tu khong ton tai");
        }
        public void update(Dictionary Dic) throws IOException {
		File file = new File("dictionaries.dat");	
		//Map->file
		try(PrintWriter pw = new PrintWriter(file)) {		
			Dic.tm.forEach((key,vaulue)->pw.write(key+"\t"+vaulue+"\r\n"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block	
		}
		
		DictionaryManagement Dm = new DictionaryManagement();
		Dm.insertFromFile(Dic);//File -> mảng
	}
        public void dictionaryUpdate(Dictionary Dic) throws IOException{
            Set set = Dic.tm.entrySet();
            Iterator i = set.iterator();
            File f = new File("dictionaries.dat");
            FileWriter fw = new FileWriter(f);
            while(i.hasNext()){
                Map.Entry map = (Map.Entry) i.next();
                
                try {     
                                
                    fw.write(map.getKey()+"\t"+map.getValue()+"\r\n");                    
                   }            
                catch (IOException ex) {
                    Component rootPane = null;
                    JOptionPane.showMessageDialog(rootPane, ex);
                }
            }
            
        }
        public void dictionarySearch(Dictionary Dic){
            System.out.print("Nhap tu khoa muon tim : ");
            Scanner scan = new Scanner(System.in);
            String w = scan.nextLine();
            int j=1;
            System.out.println("No\t| English\t\t| Vietnamese");
            for(int i=0;i<Dic.getN();i++){
                String s = Dic.words[i].getWordTarget();
                if(s.startsWith(w)){                   
                    System.out.println(j +"\t" + "| "+ Dic.words[i].getWordTarget()+"\t\t| "+Dic.words[i].getWordExplain());
                    j++;
                }
            }
               
        }
}
