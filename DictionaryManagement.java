package com.ver3;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.Scanner;
import java.util.TreeMap;

import com.ver2.Dictionary;
import com.ver2.DictionaryCommandline;

public class DictionaryManagement extends DictionaryCommandLine{
	//Hàm lấy dữ liệu từ file vào Treemap
	public void insertFromFileMap(TreeMap<String, String> mapWord)throws IOException{
		File file = new File("dictionaries.dat ");
		int i = 0;
		if(!file.exists())
		{
			file.createNewFile();
		}
		FileInputStream fileInputStream = new FileInputStream(file);
		
		Scanner dictionaries = new Scanner(fileInputStream);
		String line = new String();
		while(dictionaries.hasNextLine()) {
			line = dictionaries.nextLine();
			if(line.trim()!="") {
				String[] temp = line.split("\t");
				String Target = temp[0];
				String Explain = temp[1];
				mapWord.put(Target, Explain);
				
			}
		}
		
	}
	public void addWord(TreeMap<String, String> mapWord) {//Thêm từ
		System.out.println("Nhập từ bạn muốn thêm\n");
		Scanner scan = new Scanner(System.in);
		String s_Target = scan.nextLine();
		System.out.println("Nhập nghĩa của từ bạn muốn thêm \n");
		String s_Explain = scan.nextLine();
		mapWord.put(s_Target, s_Explain);
	}
	public void deleteWord(TreeMap<String, String> mapWord,String key) {//Xóa từ
		mapWord.remove(key);
	}
	//VCL
	public void repairWord(TreeMap<String, String> mapWord,String wordRepair,String s_Target,String s_Explain) {
		mapWord.put(s_Target, s_Explain);
		deleteWord(mapWord, wordRepair);
		
	}
	//Xuất dữ liệu từ điển ra file mới"dictionariesWrite.dat"
	public void dictionaryExportToFile(TreeMap<String, String> mapWord)  {
		File file = new File("dictionariesWrite.dat");
		
			
			try(PrintWriter pw = new PrintWriter(file)) {
				
				mapWord.forEach((key,vaulue)->pw.write(key+"\t"+vaulue+"\r\n"));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				
			}
					
	}
	//Cập nhật từ điển sau khi thao tác 
	public void update(TreeMap<String, String> mapWord,Dictionary Dic) throws IOException {
		File file = new File("dictionaries.dat");	
		//Map->file
		try(PrintWriter pw = new PrintWriter(file)) {		
			mapWord.forEach((key,vaulue)->pw.write(key+"\t"+vaulue+"\r\n"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block	
		}
		
		com.ver2.DictionaryManagement Dm = new com.ver2.DictionaryManagement();
		Dm.insertFromFile(Dic);//File -> mảng
	}
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
	//Hệ thông thao tác trên từ điển
	public void ShowMenu(TreeMap<String, String> mapWord,Dictionary Dic) throws IOException {
		System.out.println("1.Thêm từ");
		System.out.println("2.Xóa từ");
		System.out.println("3.Xuất toàn bộ dữ liệu từ điển");
		System.out.println("4.Tìm kiếm từ");
		System.out.println("5.Sửa từ");
		System.out.println("6.Xuất dữ liệu từ điển ra file");
		System.out.println("7.Thoát chương trình");
		Scanner scan = new Scanner(System.in);
		String key  = new String();
		boolean end = false;
		while(!end){
			key = scan.nextLine();
			
			switch (key) {
			case "1"://Thêm từ
				addWord(mapWord);
				System.out.println("Từ đã được thêm thành công");
				update(mapWord, Dic);
				break;
			case "2"://Xóa từ		
				System.out.println("Nhập từ bạn muốn xóa");
				Scanner s = new Scanner(System.in);
				String wordDelete = s.nextLine();
				deleteWord(mapWord,wordDelete);
				update(mapWord, Dic);
				System.out.println("Xóa từ thành công");
				break;
			case "3"://Xuất toàn bộ dữ liệu từ điển	
				DictionaryCommandline Dc = new DictionaryCommandline();
				Dc.showAllWords(Dic);
				break;
			case "4"://Tìm kiếm từ
				dictionarySearcher(Dic);
				break;
			case "5"://Sửa từ
				Scanner s1 = new Scanner(System.in);
				System.out.println("nhập từ bạn muốn sửa ");
				String wordRepair = s1.nextLine();
				System.out.println("Nhập từ bạn muốn sửa thành ");
				String s_Target = s1.nextLine();
				System.out.println("Nhập nghĩa mới của từ ");
				String s_Explain = s1.nextLine();
				repairWord(mapWord,wordRepair ,s_Target, s_Explain);
				update(mapWord, Dic);
				System.out.println("Từ đã được sửa thành công");
				break;
			case "6"://Xuất dữ liệu từ điển ra file
				dictionaryExportToFile(mapWord);
				System.out.println("Xuất thành công dữ liệu. Bạn có thể mở file dictionariesWrite.dat để xem dữ liệu");
				break;
			case "7": 
				end = true;				
				System.out.println("Thoát chương trình thành công");
				break;
			default:
				System.out.println("nhập sai mời nhập lại\n");
				break;
			}
		}
		
	}

}
