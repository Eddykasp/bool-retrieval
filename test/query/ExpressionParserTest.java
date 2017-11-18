package query;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.LinkedList;

import org.junit.Test;

import datastructure.KeywordList;
import datastructure.KeywordParser;
import datastructure.Word;
import datastructure.WordMatrix;

public class ExpressionParserTest {
	
	@Test
	public void testTwoOperandsAndExpression() {
		String expression = "fox and dog";
		
		String textBodyA = "there is a fox and a dog";
		String textBodyB = "hello fox said the dog";
		String textBodyC = "what does the fox say";
		
		WordMatrix matrix = new WordMatrix();
		
		KeywordList keywordsA = KeywordParser.parseText(1, textBodyA);
		KeywordList keywordsB = KeywordParser.parseText(2, textBodyB);
		KeywordList keywordsC = KeywordParser.parseText(3, textBodyC);
		
		KeywordParser.addKeywordsToMatrix(matrix, keywordsA);
		KeywordParser.addKeywordsToMatrix(matrix, keywordsB);
		KeywordParser.addKeywordsToMatrix(matrix, keywordsC);
		
		Word result = null;
		Expression<Word> ex;
		try {
			ex = ExpressionParser.parseExpression(matrix, expression);
			LinkedList<Integer> expectedResult = new LinkedList<>();
			expectedResult.add(1);
			expectedResult.add(2);
			
			result = ex.evaluate();
			if(result == null) {
				fail();
			} else {
				assertEquals(expectedResult, result.getDocumentIds());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
		
	}
	
	@Test
	public void testTwoOperandsOrExpression() {
		String expression = "fox or dog";
		
		String textBodyA = "the fox is a dog";
		String textBodyB = "i am a dog";
		String textBodyC = "a snake is not a cat";
		
		WordMatrix matrix = new WordMatrix();
		
		KeywordList keywordsA = KeywordParser.parseText(1, textBodyA);
		KeywordList keywordsB = KeywordParser.parseText(2, textBodyB);
		KeywordList keywordsC = KeywordParser.parseText(3, textBodyC);
		
		KeywordParser.addKeywordsToMatrix(matrix, keywordsA);
		KeywordParser.addKeywordsToMatrix(matrix, keywordsB);
		KeywordParser.addKeywordsToMatrix(matrix, keywordsC);
		
		Word result = null;
		Expression<Word> ex;
		try {
			ex = ExpressionParser.parseExpression(matrix, expression);
			LinkedList<Integer> expectedResult = new LinkedList<>();
			expectedResult.add(1);
			expectedResult.add(2);
			
			result = ex.evaluate();
			if(result == null) {
				fail();
			} else {
				assertEquals(expectedResult, result.getDocumentIds());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testTwoOperandsAndNotExpression() {
		String expression = "fox andnot dog";
		
		String textBodyA = "the fox is a dog";
		String textBodyB = "i am a fox";
		String textBodyC = "a snake is not a fox";
		
		WordMatrix matrix = new WordMatrix();
		
		KeywordList keywordsA = KeywordParser.parseText(1, textBodyA);
		KeywordList keywordsB = KeywordParser.parseText(2, textBodyB);
		KeywordList keywordsC = KeywordParser.parseText(3, textBodyC);
		
		KeywordParser.addKeywordsToMatrix(matrix, keywordsA);
		KeywordParser.addKeywordsToMatrix(matrix, keywordsB);
		KeywordParser.addKeywordsToMatrix(matrix, keywordsC);
		
		Word result = null;
		Expression<Word> ex;
		try {
			ex = ExpressionParser.parseExpression(matrix, expression);
			LinkedList<Integer> expectedResult = new LinkedList<>();
			expectedResult.add(2);
			expectedResult.add(3);
			
			result = ex.evaluate();
			if(result == null) {
				fail();
			} else {
				assertEquals(expectedResult, result.getDocumentIds());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
	}

}
