import java.io.PrintStream;
import java.util.Iterator;
import java.util.Hashtable;
/* https://www.geeksforgeeks.org/how-to-iterate-through-hashtable-in-java/ */
public abstract class Dictionary {
	Hashtable<Character,Hashtable<String,Integer>> Dico;
	
	public Dictionary(){
		Dico = new Hashtable<Character,Hashtable<String,Integer>>();

	}

	abstract public void add(String word);
	abstract public boolean find(String word);
	public Iterator<Character> prefixedDepthFirstIterator() {
		throw new UnsupportedOperationException();
	}
	public Iterator<Character> infixedDepthFirstIterator() {
		throw new UnsupportedOperationException();
	}
	public Iterator<Character> postfixedDepthFirstIterator() {
		throw new UnsupportedOperationException();
	}
	public Iterator<Character> widthIterator() {
		throw new UnsupportedOperationException();
	}
	public Iterator<String> wordIterator() {
		throw new UnsupportedOperationException();
	}
}
