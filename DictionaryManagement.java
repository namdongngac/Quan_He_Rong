/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import java.util.*;
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
import java.io.File;
//import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/**
 *
 * @author admin
 */
public class DictionaryManagement {
	public void insertFromCommandline(Dictionary Dic){
		Scanner scan = new Scanner(System.in);
		System.out.print("Moi ban nhap so tu : ");
		int n = scan.nextInt();
		Dic.setN(n); 
                TreeMap tm = new TreeMap();
		Word[] words = new Word[n];		
		for(int i = 0;i<words.length;i++) {
			String wordtarget = scan.nextLine();
			
			String wordexplain = scan.nextLine();
			
			words[i] = new Word(wordtarget,wordexplain);
		}
		Dic.Dictionary(words);
		
	}
        /*public void insertFromFile(Dictionary Dic){
            Word[] words = new Word[100000];
            TreeMap tm = new TreeMap();
            try {                
                // tao doi tuong luong va lien ket nguon du lieu
                File f = new File("dictionaries.dat");
                BufferedReader br;
                // doc du lieu
                FileReader fr = new FileReader(f);
                br = new BufferedReader(fr);
                String line;
                int i=0;
                while ((line = br.readLine()) != null){
                    
                    String[] temp = line.split("\t");
                    String wordtarget = temp[0].trim();
                    String wordexplain = temp[1].trim();
                    words[i] = new Word(wordtarget,wordexplain);
                    tm.put(wordtarget, wordexplain);
                    i++;
                }
                Dic.setN(i);
                Dic.Dictionary(words);
                Dic.Dictionnary(tm);
                // dong luong
                fr.close();
                br.close(); 
                } 
            catch (IOException ex) {
                System.out.println("Lỗi đọc file : "+ex);
            }
        }*/
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
                    i++;
                }
                Dic.setN(i);
                Dic.Dictionary(words);
                Dic.Dictionnary(tm);
            } 
            catch (IOException ex) {
                System.out.println("Read file ERROR : "+ex);
            }
        }
                
        
	public void dictionaryLookup(Dictionary Dic){
            System.out.print("Nhap tu muon tim : ");
            Scanner scan = new Scanner(System.in);
            String w = scan.nextLine();             
            /*for(int i=0;i<Dic.getN();i++){
                if(Dic.words[i].getWordTarget().equals(w)){
                    System.out.println("No    | English            | Vietnamese");
                    System.out.println((i+1) +"     " + "| "+ Dic.words[i].getWordTarget()+"                | "+Dic.words[i].getWordExplain());
                    break;
                }
            }*/
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
        public void dictionaryUpdate(Dictionary Dic)throws IOException{
            Set set = Dic.tm.entrySet();
            Iterator i = set.iterator();
            File f = new File("dictionaries.dat");
            FileWriter fw = new FileWriter(f);;
            while(i.hasNext()){
                Map.Entry map = (Map.Entry) i.next();
                
                try {     
                                
                    fw.write(map.getKey()+"\t"+map.getValue()+"\r\n");                    
                   }            
                catch (IOException ex) {
                    System.out.println("Write File ERROR : " + ex);
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
