package com.ver3;

import java.io.File;
import com.ver2.Dictionary;
import com.ver2.DictionaryCommandline;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeMap;
import java.io.PrintWriter;
public class Main3 {
	
	public static void main(String[] args) throws IOException {

		//Tạo 1 đối tượng Từ điển
		Dictionary Dic = new Dictionary();//package com.ver2
		//Tạo Treemap để lưu từ điển và thao tác
		TreeMap<String, String> mapWord = new TreeMap<String,String>();
		DictionaryManagement Dm3 = new DictionaryManagement();//package com.ver3
		
		DictionaryCommandline Dc2 = new DictionaryCommandline();//package com.ver2
		try {//lưu vào mảng để chạy hàm search
			Dc2.insertFromFile(Dic);//Nạp dữ liệu từ điển 
		} catch (IOException e) {

			e.printStackTrace();
		}
		Dm3.insertFromFileMap(mapWord);						
		Dm3.ShowMenu(mapWord, Dic);
	}
}
