package com.ver3;

import java.io.IOException;
import java.util.Scanner;
import java.util.TreeMap;

import com.ver2.Dictionary;

import com.ver2.DictionaryCommandline;
 
public class DictionaryCommandLine {
	
public void dictionarySearcher(Dictionary Dic) {//Hàm tìm kiếm từ
		
		Scanner scan = new Scanner(System.in);
		System.out.println("nhập từ bạn muốn tra ");
		String s = scan.nextLine();
		int j =0;
		System.out.println("No   | English\t\t| Vietnamese");
		for(int i=0;i<Dic.getN();i++) {
			String prefix = Dic.words[i].getWordTarget();
			if(prefix.startsWith(s)) {
				System.out.println((j+1) +"    " + "| "+ Dic.words[i].getWordTarget()+"\t\t| "+Dic.words[i].getWordExplain());
				j++;
			}
		}
		if(j==0) System.out.println("Từ này chưa có trong từ điển");
	}

}
