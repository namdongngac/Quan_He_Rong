/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary2;
import java.util.*;
/**
 *
 * @author admin
 */
public class Dictionary {	
	private int n;//Số lượng tự
	public Word words[]; //= new Word[n];
        public String str[];
        public TreeMap tm;
	public int getN() {
		return this.n;
	}
	public void setN(int n) {
		this.n = n;
	}
	public void Dictionary(Word[] words) {
		
		this.words = words;
	}
        public void Dictionnary(TreeMap tm){
            this.tm = tm;
        }
        public void Dictionnary(String[] str){
            this.str = str;
        }
}
