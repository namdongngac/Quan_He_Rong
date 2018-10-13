/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import java.io.IOException;

/**
 *
 * @author admin
 */
public class Main {
	public static void main(String[] args) throws IOException {
                
		System.out.println("Ban hay chon thao tac");
                System.out.println("1. Tra cuu tu chinh xac");
                System.out.println("2. Tra cuu tu bang tu khoa");
                System.out.println("3. Them tu vao tu dien");
                System.out.println("4. Xoa tu trong tu dien");
                System.out.println("5. Hien thi du lieu tu dien");
                System.out.println("6. Thoat ung dung");	
		Dictionary Dic = new Dictionary();		
		DictionaryCommandline Dc = new DictionaryCommandline();
		//Dc.dictionaryBasic(Dic);
                Dc.dictionaryAdvanced(Dic);
                
	}

}
