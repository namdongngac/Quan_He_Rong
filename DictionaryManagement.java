package com.ver2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class DictionaryManagement {//extends Dictionary{
	public void insertFromCommandline(Dictionary Dic){//Hàm nhập liệu 
		Scanner scan = new Scanner(System.in);
		System.out.print("Mời bạn nhập số từ ");
		int n = Integer.parseInt(scan.nextLine());
		Dic.setN(n); 
		Word[] words = new Word[n];		
		for(int i = 0;i<words.length;i++) {
			String wordtarget = scan.nextLine();		
			String wordexplain = scan.nextLine();		
			words[i] = new Word(wordtarget,wordexplain);		
		}
		Dic.Dictionary(words);
		
	}
	public void insertFromFile(Dictionary Dic) throws IOException{
		File file = new File("dictionaries.dat ");
		int i = 0;
		if(!file.exists())
		{
			file.createNewFile();
		}
		FileInputStream fileInputStream = new FileInputStream(file);
		//int r = fileInputStream.read();
		Word words[] = new Word[300000] ;
		String line = new String();
		Scanner dictionaries = new Scanner(fileInputStream);
		while(dictionaries.hasNextLine()) {
			line = dictionaries.nextLine();//Đọc 1 dòng
			if(line.trim()!="") {//Nếu dòng khác khoảng trắng
				String temp[] = line.split("\t");
				String wordtarget = temp[0];
				String wordexplain = temp[1];
				//System.out.println(wordtarget);
				words[i] = new Word(wordtarget, wordexplain);//
				i++;
				}
		}	
		Dic.setN(i);
		Dic.Dictionary(words);
		dictionaries.close();
	}
	public void dictionaryLookup(Dictionary Dic) {
		System.out.println("Vui lòng nhập từ bạn muốn tra");
		 Scanner scan = new Scanner(System.in);
		 String wordTrans = scan.nextLine();
		 for(int i = 0; i< Dic.words.length;i++) {
			 if(wordTrans.equals(Dic.words[i].getWordTarget())) {
				 System.out.println("| English          | Vietnamese");
				 System.out.println("| "+Dic.words[i].getWordTarget()+"        |"+Dic.words[i].getWordExplain());
			     break;
			 }else System.out.println("Từ điền chưa cập nhật từ bạn muốn tìm");
		 }
	}	
	}

