package datastructure;

import java.util.Iterator;
import java.util.LinkedList;

import query.BooleanOperable;

public class Word implements Comparable<Word>, BooleanOperable {
	
	private String word;
	private LinkedList<Integer> documentIds;
	
	private Word() {
		word = "";
		documentIds = new LinkedList<>();
	}
	
	public Word(String word, int documentId) {
		this.word = word;
		documentIds = new LinkedList<Integer>();
		documentIds.add(documentId);
	}
	
	public String toString() {
		return this.word + " " + documentIds;
	}
	
	private void setDocumentIds(LinkedList<Integer> docIds) {
		this.documentIds = docIds;
	}
	
	public int numberOfOccurences() {
		return documentIds.size();
	}

	public String getWord() {
		return word;
	}

	public LinkedList<Integer> getDocumentIds() {
		return documentIds;
	}
	
	public void addOccurence(int documentId) {
		if(documentIds.size() == 0 || documentId < documentIds.getFirst()) {
			documentIds.add(0, documentId);
			return;
		} else {
			Iterator<Integer> itr = documentIds.iterator();
			int counter = 0;
			while(itr.hasNext()) {
				int next = itr.next();
				if(next == documentId) {
					return;
				} else if(next > documentId) {
					break;
				} else {
					counter++;
					continue;
				}
			}
			documentIds.add(counter, documentId);
		}
	}

	@Override
	public int compareTo(Word otherWord) {
		return this.word.compareTo(otherWord.getWord());
	}

	@Override
	public Word booleanAnd(BooleanOperable operandB) {
		Iterator<Integer> listA = this.documentIds.iterator();
		Iterator<Integer> listB = ((Word)operandB).getDocumentIds().iterator();
		Word result = this.getEmptyWord();
		if(!listA.hasNext() || !listB.hasNext()) {
			return result;
		};
		int docIdA = listA.next();
		int docIdB = listB.next();
		do {
			
			if(docIdA == docIdB) {
				result.addOccurence(docIdA);
				if(!listA.hasNext() || !listB.hasNext()) {
					break;
				}
				docIdA = listA.next();
				docIdB = listB.next();
				
			} else if(docIdA < docIdB) {
				if(!listA.hasNext()) {
					break;
				}
				docIdA = listA.next();
			} else if(docIdB < docIdA) {
				if(!listA.hasNext()) {
					break;
				}
				docIdB = listB.next();
			}
		} while(listA.hasNext() && listB.hasNext());
		
		if(listA.hasNext()) {
			do {
				if(docIdA == docIdB) {
					result.addOccurence(docIdA);
				}
				docIdA = listA.next();
			} while(listA.hasNext() && docIdB > docIdA);
		}
		
		if(listB.hasNext()) {
			do {
				if(docIdA == docIdB) {
					result.addOccurence(docIdB);
				}
			} while(listB.hasNext() && docIdA > docIdB);
		}
		return result;
	}

	public Word getEmptyWord() {
		
		return new Word();
	}

	@Override
	public Word booleanOr(BooleanOperable operandB) {
		Iterator<Integer> listA = this.documentIds.iterator();
		Iterator<Integer> listB = ((Word)operandB).getDocumentIds().iterator();
		Word result = this.getEmptyWord();
		if(!listA.hasNext() && !listB.hasNext()) {
			return result;
		};
		int docIdA = listA.next();
		int docIdB = listB.next();
		do {
			if(docIdA == docIdB) {
				result.addOccurence(docIdA);
				if(!listA.hasNext() || !listB.hasNext()) {
					break;
				}
				docIdA = listA.next();
				docIdB = listB.next();
				
			} else if(docIdA < docIdB) {
				result.addOccurence(docIdA);
				if(!listA.hasNext()) {
					break;
				}
				docIdA = listA.next();
			} else if(docIdB < docIdA) {
				result.addOccurence(docIdB);
				if(!listB.hasNext()) {
					break;
				}
				docIdB = listB.next();
			}
		} while(listA.hasNext() && listB.hasNext());
		if(listA.hasNext()) {
			result.addOccurence(docIdA);
		} else if(listB.hasNext()) {
			result.addOccurence(docIdB);
		}
		while(listA.hasNext()) {
			result.addOccurence(listA.next());
		}
		while(listB.hasNext()) {
			result.addOccurence(listB.next());
		}
		return result;
	}

	@Override
	public Word booleanAndNot(BooleanOperable operandB) {
		Iterator<Integer> listA = this.documentIds.iterator();
		Iterator<Integer> listB = ((Word)operandB).getDocumentIds().iterator();
		Word result = this.getEmptyWord();
		if(!listA.hasNext() || !listB.hasNext()) {
			return result;
		};
		int docIdA = listA.next();
		int docIdB = listB.next();
		do {
			
			if(docIdA == docIdB) {
				if(!listA.hasNext() || !listB.hasNext()) {
					break;
				}
				docIdA = listA.next();
				docIdB = listB.next();
				
			} else if(docIdA < docIdB) {
				result.addOccurence(docIdA);
				if(!listA.hasNext()) {
					break;
				}
				docIdA = listA.next();
			} else if(docIdB < docIdA) {
				if(!listB.hasNext()) {
					break;
				}
				docIdB = listB.next();
			}
		} while(listA.hasNext() && listB.hasNext());
		while(listA.hasNext()) {
			result.addOccurence(listA.next());
		}
		return result;
	}

}
