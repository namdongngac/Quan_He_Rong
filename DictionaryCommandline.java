package com.ver2;

public class DictionaryCommandline extends DictionaryManagement{
	public void showAllWords(Dictionary Dic) {		
		System.out.println("No   | English          | Vietnamese");
		for(int j = 0; j<Dic.getN();j++) {
			System.out.println((j+1) +"    " + "| "+ Dic.words[j].getWordTarget()+"        | "+Dic.words[j].getWordExplain());
		}
	}
	public void dictionaryBasic(Dictionary Dic) {
		//DictionaryManagement Dm = new DictionaryManagement();
		insertFromCommandline(Dic);		
		showAllWords(Dic);
	}
	public void dictionaryAdvanced(Dictionary Dic) {
		insertFromCommandline(Dic);
		showAllWords(Dic);
		dictionaryLookup(Dic);
	}
}
