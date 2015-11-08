import java.util.Arrays;

//UIUC CS125 FALL 2014 MP. File: LinkedList.java, CS125 Project: Challenge6-RecursionSee, Version: 2015-10-26T21:57:48-0500.725586880
/**
 * @author qilezhi2
 *
 */
public class LinkedList {
	// Get and Set methods are NOT necessary!

	private LinkedList next; 	
	private final String word;

	/** Constructs this link.
	 * @param word ; a single word (never null).
	 * @param next ; the next item in the chain (null, if there are no more items).
	 */
	public LinkedList(String word, LinkedList next) {
		this.word = word;
		this.next = next;
	}

	/**
	 * Converts the entire linked list into a string representation.
	 */
	public String toString() {
		if (next == null)
			return word;// BASE CASE; no more recursion required

		// Recursive case:
		String restOfString = next.toString(); // Forward Recursion
		return word + ";" + restOfString;
	}

	/**
	 * Returns the number of entries in the linked list.
	 * @return number of entries.
	 */
	public int getCount() {
		if (next == null)
			return 1; // BASE CASE; no more recursion required!

		// Recursive case:
		return 1 + next.getCount(); // Forward recursion
	}
	
	/** Creates a new LinkedList entry at the end of this linked list.
	 * Recursively finds the last entry then adds a new link to the end.
	 * @param word
	 */
	public void append(String word) {
		if (this.next==null) this.next = new LinkedList(word, null);
		else this.next.append(word);
	}
	
	/**
	 * Recursively counts the total number of letters used.
	 * 
	 * @return total number of letters in the words of the linked list
	 */
	public int getLetterCount() {
		// returns the total number of letters. word1.length() +
		// word2.length()+...
		// "A" -> "CAT" -> null returns 1 + 3 = 4.
		if (this.next == null) return this.word.length();
		else return this.word.length() + this.next.getLetterCount();
	}

	/**
	 * Recursively searches for and the returns the longest word.
	 * @return the longest word i.e. word.length() is maximal.
	 */
	public String getLongestWord() {
		// recursive searches for the longest word
		if ( (this.next == null) || (this.word.length() >= this.next.getLongestWord().length()) ) return this.word;
		else return this.next.getLongestWord();
	}

	/** Converts linked list into a sentence (a single string representation).
	* Each word pair is separated by a space.
	* A period (".") is appended after the last word.
	* The last link represents the last word in the sentence.*/
	public String getSentence() {
		if (this.next == null)  return this.word + ".";
		else return this.word + " " + this.next.getSentence();
	}
	
	/**
	 * Converts linked list into a sentence (a single string representation).
	 * Each word pair is separated by a space. A period (".") is appended after
	 * the last word. The last link represents the first word in the sentence
	 * (and vice versa). The partialResult is the partial string constructed
	 * from earlier links. This partialResult is initially an empty string. 
	 */
	public String getReversedSentence(String partialResult) {
		if (this.next==null) { 
			if (partialResult=="") return this.word + "."; // If there is only one LinkedList,
			else return this.word + " " + partialResult + "."; // If there are more than one LinkedLists,
		}
		else {
			if (partialResult=="") {
				partialResult = this.word;
				return this.next.getReversedSentence(partialResult);
			}
			else {
				partialResult = this.word + " " + partialResult; // A space is needed.
				return this.next.getReversedSentence(partialResult);
			}
		}
	}
	

	/** Creates a linked list of words from an array of strings.
	 * Each string in the array is a word. */
	public static LinkedList createLinkedList(String[] words) {
		// Hint: This is a wrapper method. You'll need to create your
		// own recursive method.
		// Yes this is possible _without_ loops!
		if (words.length==1) return new LinkedList(words[0], null);
		else {
			return new LinkedList(words[0],
					createLinkedList(Arrays.copyOfRange(words, 1, words.length))); // Copy part of the array.
		}
	}

	/**
	 * Searches for the following word in the linked list. Hint: use .equals not ==
	 * to compare strings.
	 * 
	 * @param word
	 * @return true if the linked list contains the word (case sensitive)
	 */
	public boolean contains(String word) {
		if (this.next==null) return this.word.equals(word);
		else {
			if (this.word.equals(word)) return true;
			else return this.next.contains(word);
		}
	}

	/** Recursively searches for the given word in the linked list.
	 * If this link matches the given word then return this link.
	 * Otherwise search the next link.
	 * If no matching links are found return null.
	 * @param word the word to search for.
	 * @return The link that contains the search word.
	 */
	public LinkedList find(String word) {
		if (this.next==null) {
			if (this.word.equals(word)) return this;
			else return null;
		}
		else {
			if (this.word.equals(word)) return this;
			else return this.next.find(word);
		}
	}

	/**
	 * Returns the last most link that has the given word, or returns null if
	 * the word cannot be found.
	 * Hint: Would forward recursion be useful?
	 * @param word the word to search for.
	 * @return the last LinkedList object that represents the given word, or null if it is not found.
	 */
	public LinkedList findLast(String word) {
		if (this.next==null) {
			if (this.word.equals(word)) return this;
			else return null;
		}
		else {
			if (this.word.equals(word) && !this.next.contains(word)) return this; // Return this only if this.next.contains==false.
			else return this.next.findLast(word);
		}
	}

	public LinkedList insert(String word) {
		if (word.compareToIgnoreCase(this.word)<0) return new LinkedList(word, this); // Put the word in the front.
		else {
			if (word.compareToIgnoreCase(this.word)>0 && this.next==null) 
				this.next = new LinkedList(word,null); // Add one LinkedList.
			else this.next = this.next.insert(word); // Recursion.
			}
		return this;
	}

}
