package query;

import datastructure.Word;
import datastructure.WordMatrix;

public class ExpressionParser {
	
	public static Expression<Word> parseExpression(WordMatrix invertedMatrix, String expression) throws Exception{
		if(invertedMatrix == null || expression == null) {
			throw new IllegalArgumentException("Arguments cannot be null");
		}
		String [] tokens = expression.split(" ");
		String firstToken = tokens[0].toLowerCase();
		
		if(firstToken.equals("and") || firstToken.equals("or") || firstToken.equals("andnot")) {
			throw new Exception("Invalid expression");
		}
		ExpressionBuilder<Word> builder = new ExpressionBuilder<>();
		Word word = invertedMatrix.getWord(firstToken);
		Word empty = new Word("", 0).getEmptyWord();
		if(word == null) {
			word = empty;
		}
		builder.append(null, word);
		for(int i = 1; i < tokens.length - 1; i++) {
			String current = tokens[i].toLowerCase();
			Operator<Word> nextOperator;
			switch(current) {
			case "and":
				nextOperator = new AndOperator<Word>();
				break;
			case "or":
				nextOperator = new OrOperator<Word>();
				break;
			case "andnot":
				nextOperator = new AndNotOperator<Word>();
				break;
			default:
				throw new Exception("Invalid expression");
			}
			
			// get next keyword
			current = tokens[++i].toLowerCase();
			word = invertedMatrix.getWord(current);
			if(word == null) {
				word = empty;
			}
			builder.append(nextOperator, word);
		}
		return builder.getExpression();
	}

}
