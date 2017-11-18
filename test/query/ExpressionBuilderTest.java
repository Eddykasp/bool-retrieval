package query;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;

import org.junit.Test;

import datastructure.Word;

public class ExpressionBuilderTest {
	
	@Test
	public void testSimpleBuild() {
		Word wordA = new Word("test", 1);
		wordA.addOccurence(3);
		wordA.addOccurence(5);
		
		Word wordB = new Word("apple", 2);
		wordB.addOccurence(3);
		
		ExpressionBuilder<Word> builder = new ExpressionBuilder<>();
		builder.append(null, wordA);
		builder.append(new AndOperator<Word>(), wordB);
		
		Expression<Word> expression = builder.getExpression();
		Word result = expression.evaluate();
		
		LinkedList<Integer> expectedResult = new LinkedList<>();
		expectedResult.add(3);
		
		assertEquals(expectedResult, result.getDocumentIds());
	}
	
	@Test
	public void verifyBuildWithOutputStringAnd() {
		// "test and car"
		
		Word wordA = new Word("test", 1);
		
		Word wordB = new Word("car", 2);
		
		ExpressionBuilder<Word> builder = new ExpressionBuilder<>();
		builder.append(null, wordA);
		builder.append(new AndOperator<Word>(), wordB);
		
		Expression<Word> resultExpression = builder.getExpression();
		
		String expectedResult = "(test [1] AND car [2])";
		
		assertEquals(expectedResult, resultExpression.toString());
	}
	
	@Test
	public void testBuildExpressionWithThreeArguments() {
		// "apple or car and roof"
		
		Word wordA = new Word("apple", 1);
		Word wordB = new Word("car", 1);
		Word wordC = new Word("roof", 2);
		
		ExpressionBuilder<Word> builder = new ExpressionBuilder<>();
		builder.append(null, wordA);
		builder.append(new AndOperator<Word>(), wordB);
		builder.append(new OrOperator<Word>(), wordC);
		
		Expression<Word> resultExpression = builder.getExpression();
		
		String expectedResult = "((apple [1] AND car [1]) OR roof [2])";
		
		System.out.println(resultExpression.evaluate());
		assertEquals(expectedResult, resultExpression.toString());
		
	}

}
