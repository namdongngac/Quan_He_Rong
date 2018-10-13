/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import java.io.IOException;
import java.util.*;
/**
 *
 * @author admin
 */
public class DictionaryCommandline extends DictionaryManagement{
	public void showAllWords(Dictionary Dic) {		
		System.out.println("No    | English            | Vietnamese");
		for(int j = 0; j<Dic.getN();j++) {
			System.out.println((j+1) +"     " + "| "+ Dic.words[j].getWordTarget()+"                | "+Dic.words[j].getWordExplain());
		}
	}
	public void dictionaryBasic(Dictionary Dic) {	
		insertFromCommandline(Dic);
		showAllWords(Dic);
	}
        public void dictionaryAdvanced(Dictionary Dic) throws IOException{
            boolean end = false;
            Scanner sc = new Scanner(System.in);
            insertFromFile(Dic);
            while(!end){
                String choice = sc.nextLine();
                if("1".equals(choice))dictionaryLookup(Dic);
                else if("2".equals(choice))dictionarySearch(Dic);
                else if("3".equals(choice))dictionaryAdd(Dic);
                else if("4".equals(choice))dictionaryDelete(Dic);
                else if("5".equals(choice))showAllWords(Dic);
                else if("6".equals(choice))end = true;
                else System.out.println("Khong hop le, moi ban nhap lua chon tu 1 den 6");
                dictionaryUpdate(Dic);
            }
     
        }
}
