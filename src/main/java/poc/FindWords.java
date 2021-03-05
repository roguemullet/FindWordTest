package poc;

import java.util.*;


public class FindWords {
	Permutation perm = new Permutation();
	Dictionary dictionary;
	Set<String> foundWords = new HashSet<String>();
	
	public FindWords(Dictionary Dictionary) {
		this.dictionary = Dictionary;

	}
	
	public Set<String> findWords(String word){
		List<String> permutations = perm.getPermutations(word);
		for(String str: permutations) {
			this.searchForWords(str);
		}
		
		return foundWords;
	}
	
	public void searchForWords(String str) {		
		int strLength = str.length();
		
		for(int i = 0; i < strLength; i++) {
			if(dictionary.isEnglishWord(str.substring(i))) {
				this.foundWords.add(str.substring(i));
			}
		}
	}
}
