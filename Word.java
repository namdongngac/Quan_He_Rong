/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary2;

/**
 *
 * @author admin
 */
public class Word {
	private String  WordTarget;
	private String WordExplain;
	public String getWordTarget() {
		return WordTarget;
	}
	public void setWordTarget(String wordTarget) {
		WordTarget = wordTarget;
	}
	public String getWordExplain() {
		return WordExplain;
	}
	public void setWordExplain(String wordExplain) {
		WordExplain = wordExplain;
	}
	public Word(String wordTarget, String wordExplain) {
		super();
		WordTarget = wordTarget;
		WordExplain = wordExplain;
	}
	

}
