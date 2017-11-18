package datastructure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class WordMatrix {
	
	private ArrayList<Word> words;
	
	public WordMatrix() {
		words = new ArrayList<>();
	}
	
	public ArrayList<Word> getWords(){
		return this.words;
	}
	
	public Word getWord(String string) {
		if(words.size() == 0) {
			return null;
		}
		int index = Collections.binarySearch(words, new Word(string, -1));
		if(index < 0) {
			return null;
		}
		return words.get(index);
	}
	
	public void addWord(String word, int docId) {
		Word existing = getWord(word);
		if(existing != null){
			existing.addOccurence(docId);
			return;
		}
		words.add(new Word(word, docId));
		words.sort(new Comparator<Word>() {

			@Override
			public int compare(Word arg0, Word arg1) {
				return arg0.compareTo(arg1);
			}
			
		});
	}

}
