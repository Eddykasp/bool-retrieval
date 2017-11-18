package datastructure;

import static org.junit.Assert.*;

import org.junit.Test;

public class WordMatrixTest {
	
	@Test
	public void testConstructor() {
		WordMatrix matrix = new WordMatrix();
		assertNotNull(matrix.getWords());
	}
	
	@Test
	public void testGetWordFromEmptyMatrix() {
		WordMatrix matrix = new WordMatrix();
		assertNull(matrix.getWord("test"));
	}
	
	@Test
	public void testAddAndGetWord() {
		WordMatrix matrix = new WordMatrix();
		matrix.addWord("test", 1);
		Word word = matrix.getWord("test");
		int testDocId = word.getDocumentIds().getFirst();
		assertEquals(1, testDocId);
	}
	
	@Test
	public void testGetNonExistingWord() {
		WordMatrix matrix = new WordMatrix();
		matrix.addWord("test", 1);
		matrix.addWord("apple", 1);
		assertNull(matrix.getWord("car"));
	}

}
