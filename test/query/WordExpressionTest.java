package query;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;

import org.junit.Test;

import datastructure.Word;

public class WordExpressionTest {
	
	@Test
	public void simpleAndExpression() {
		Word wordA = new Word("test", 2);
		wordA.addOccurence(3);
		wordA.addOccurence(4);
		Expression<Word> leftOperand = new AtomicExpression<Word>(wordA);
		
		Word wordB = new Word("check", 2);
		wordB.addOccurence(4);
		wordB.addOccurence(5);
		Expression<Word> rightOperand = new AtomicExpression<Word>(wordB);
		
		Expression<Word> mainExpression = new Expression<Word>(leftOperand, rightOperand, new AndOperator<Word>());
		Word result = mainExpression.evaluate();
		
		LinkedList<Integer> expectedResult = new LinkedList<Integer>();
		expectedResult.add(2);
		expectedResult.add(4);
		
		assertEquals(expectedResult, result.getDocumentIds());
	}
	
	@Test
	public void simpleOrExpressionTest() {
		Word wordA = new Word("test", 1);
		wordA.addOccurence(3);
		wordA.addOccurence(5);
		wordA.addOccurence(6);
		Expression<Word> leftOperand = new AtomicExpression<Word>(wordA);
		
		Word wordB = new Word("super", 2);
		wordB.addOccurence(4);
		wordB.addOccurence(6);
		Expression<Word> rightOperand = new AtomicExpression<Word>(wordB);
		
		Expression<Word> mainExpression = new Expression<Word>(leftOperand, rightOperand, new OrOperator<Word>());
		Word result = mainExpression.evaluate();
		
		LinkedList<Integer> expectedResult = new LinkedList<Integer>();
		expectedResult.add(1);
		expectedResult.add(2);
		expectedResult.add(3);
		expectedResult.add(4);
		expectedResult.add(5);
		expectedResult.add(6);
		
		assertEquals(expectedResult, result.getDocumentIds());
		
	}
	
	@Test
	public void simpleAndNotExpressionTest() {
		Word wordA = new Word("first", 2);
		wordA.addOccurence(3);
		wordA.addOccurence(6);
		wordA.addOccurence(7);
		Expression<Word> leftOperand = new AtomicExpression<Word>(wordA);
		
		Word wordB = new Word("second", 3);
		wordB.addOccurence(4);
		wordB.addOccurence(5);
		wordB.addOccurence(6);
		Expression<Word> rightOperand = new AtomicExpression<Word>(wordB);
		
		Expression<Word> mainExpression = new Expression<Word>(leftOperand, rightOperand, new AndNotOperator());
		Word result = mainExpression.evaluate();
		
		LinkedList<Integer> expectedResult = new LinkedList<>();
		expectedResult.add(2);
		expectedResult.add(7);
		
		assertEquals(expectedResult, result.getDocumentIds());
				
	}

}
