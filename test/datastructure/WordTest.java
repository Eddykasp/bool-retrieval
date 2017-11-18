package datastructure;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

import query.BooleanOperable;

public class WordTest {
	
	@Test
	public void testConstructorNormal() {
		Word word = new Word("test", 1);
		assertEquals("test", word.getWord());
		assertEquals(1, word.numberOfOccurences());
		int docId = word.getDocumentIds().getFirst();
		assertEquals(1, docId);
	}
	
	@Test
	public void testAddNewDocumentId() {
		Word word = new Word("test", 1);
		word.addOccurence(2);
		assertEquals(2, word.numberOfOccurences());
		int docIdOne = word.getDocumentIds().getFirst();
		assertEquals(1, docIdOne);
		int docIdTwo = word.getDocumentIds().get(1);
		assertEquals(2, docIdTwo);
	}
	
	@Test
	public void testAddNewDocIdBeforeFirst() {
		Word word = new Word("test", 2);
		int initialDocIdOne = word.getDocumentIds().getFirst();
		assertEquals(2, initialDocIdOne);
		word.addOccurence(1);
		int docIdOne = word.getDocumentIds().getFirst();
		assertEquals(1, docIdOne);
		int docIdTwo = word.getDocumentIds().get(1);
		assertEquals(2, docIdTwo);
	}
	
	@Test
	public void testAddNewDocInMiddle() {
		Word word = new Word("test", 1);
		word.addOccurence(3);
		int initialSecondDocId = word.getDocumentIds().get(1);
		assertEquals(3, initialSecondDocId);
		word.addOccurence(2);
		int secondDocId = word.getDocumentIds().get(1);
		assertEquals(2, secondDocId);
		int thirdDocId = word.getDocumentIds().get(2);
		assertEquals(3, thirdDocId);
	}
	
	@Test
	public void testBooleanAnd() {
		Word wordA = new Word("test", 1);
		wordA.addOccurence(3);
		wordA.addOccurence(4);
		wordA.addOccurence(6);
		wordA.addOccurence(7);
		
		Word wordB = new Word("check", 1);
		wordB.addOccurence(2);
		wordB.addOccurence(4);
		wordB.addOccurence(5);
		wordB.addOccurence(6);
		wordB.addOccurence(8);
		wordB.addOccurence(9);
		
		Word result = wordA.booleanAnd(wordB);
		
		LinkedList<Integer> expectedResult = new LinkedList<>();
		expectedResult.add(1);
		expectedResult.add(4);
		expectedResult.add(6);
		assertEquals(expectedResult, result.getDocumentIds());
	}
	
	@Test
	public void testBooleanOr() {
		Word wordA = new Word("test", 1);
		wordA.addOccurence(2);
		wordA.addOccurence(4);
		wordA.addOccurence(5);
		
		Word wordB = new Word("check", 2);
		wordB.addOccurence(5);
		wordB.addOccurence(6);
		wordB.addOccurence(8);
		
		Word result = wordA.booleanOr(wordB);
		
		LinkedList<Integer> expectedResult = new LinkedList<Integer>();
		expectedResult.add(1);
		expectedResult.add(2);
		expectedResult.add(4);
		expectedResult.add(5);
		expectedResult.add(6);
		expectedResult.add(8);
		
		assertEquals(expectedResult, result.getDocumentIds());
	}
	
	@Test
	public void testBooleanAndNot() {
		Word wordA = new Word("test", 1);
		wordA.addOccurence(2);
		wordA.addOccurence(4);
		wordA.addOccurence(5);
		
		Word wordB = new Word("check", 2);
		wordB.addOccurence(5);
		wordB.addOccurence(6);
		
		Word result = wordA.booleanAndNot(wordB);
		
		LinkedList<Integer> expectedResult = new LinkedList<Integer>();
		expectedResult.add(1);
		expectedResult.add(4);
		
		assertEquals(expectedResult, result.getDocumentIds());
	}

}
