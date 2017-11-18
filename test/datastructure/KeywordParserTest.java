package datastructure;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class KeywordParserTest {
	
	@Test
	public void testParsingOneDocumentAndAddingToEmptyMatrix() {
		String sampleText = "This is a sample text containing a few duplicate "
				+ "words. This text must be processed.";
		KeywordList keywords = KeywordParser.parseText(1, sampleText);
		WordMatrix matrix = new WordMatrix();
		KeywordParser.addKeywordsToMatrix(matrix, keywords);
		assertNotNull(matrix.getWord("this"));
		assertNull(matrix.getWord("This"));
		assertEquals(12, matrix.getWords().size());
	}

}
