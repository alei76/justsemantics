package semantictools;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * A WordToSemClassTable is a Mapping from words to SemanticClass objects. Its indented use is to lookup what class a word belongs to, or to add a word->semantic class association.
 * For the reverse lookup Semantic Class -> word list, use SemClassToWordsTable. 
 * @author dvalsamou
 *
 */
public class WordToSemClassTable extends HashMap<String, SemanticClass> {
	private static final long serialVersionUID = 1L;

	public SemanticClass getSemanticClassOf(String word){
		return this.get(word);
	}
	public Boolean inTheSameClass(String word1, String word2){
		if (getSemanticClassOf(word1) == null || getSemanticClassOf(word2) == null) return false;
		return getSemanticClassOf(word1).equals(getSemanticClassOf(word2));
	}

	/**
	 * Add all the words of a given SemanticClass (parameter) to this mapping
	 * @param completeSemclass
	 */
	public void populate(SemanticClass completeSemclass){
		for (String word:completeSemclass.getWords()){
			this.put(word,completeSemclass);
		}
	}
	/**
	 * Add all the words of a given set of SemanticClass objects (parameter) to this mapping
	 * @param semclasses
	 */
	public void populateAll(ArrayList<SemanticClass> semclasses){
		for (SemanticClass semclass:semclasses){
			populate(semclass);
		}
	}
	/**
	 * Get all the words included in this mapping
	 * @return
	 */
	public ArrayList<String> getWords(){
		return new ArrayList<String> (keySet());
	}


}
