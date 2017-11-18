package datastructure;

public class KeywordParser {
	
	public static KeywordList parseText(int documentId, String textBody) {
		KeywordList keywords = new KeywordList(documentId);
		String [] allWords = textBody.split(" ");
		for (String word : allWords) {
			word = word.toLowerCase();
			keywords.addKeyword(word);
		}
		return keywords;
	}
	
	public static void addKeywordsToMatrix(WordMatrix matrix, KeywordList words) {
		if(matrix == null) {
			return;
		}
		
		for(String word : words.getKeywords()) {
			matrix.addWord(word, words.getDocumentId());
		}
	}

}
