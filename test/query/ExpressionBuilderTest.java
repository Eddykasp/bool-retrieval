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

}
