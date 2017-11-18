package datastructure;

import java.util.HashSet;

public class KeywordList {
	
	private HashSet<String> keywords;
	private int documentId;
	
	public KeywordList(int documentId) {
		this.documentId = documentId;
		keywords = new HashSet<>();
	}
	
	public void addKeyword(String keyword) {
		keywords.add(keyword);
	}
	
	public int getDocumentId() {
		return documentId;
	}
	
	public HashSet<String> getKeywords(){
		return keywords;
	}

}
