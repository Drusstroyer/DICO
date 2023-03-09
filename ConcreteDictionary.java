import java.util.Enumeration;
import java.util.Hashtable;

public class ConcreteDictionary extends Dictionary {
	Hashtable<Character,Hashtable<String,Integer>> Dico;
	
	public ConcreteDictionary(){
		Dico = new Hashtable<Character,Hashtable<String,Integer>>();

	}
	@Override
	public void add(String mot) {
		char index = mot.charAt(0);
		if (this.Dico.containsKey(index)){
			this.Dico.get(index).put(mot, 1);
		}else{
			Hashtable<String,Integer> NewElem = new Hashtable<String,Integer>();
			NewElem.put(mot, 1);
			this.Dico.put(index, NewElem);
		}
	}

	@Override
	public boolean find(String mot) {
		boolean found = false;
		Enumeration<Character> keys = this.Dico.keys();
		char current = keys.nextElement();
		while(keys.hasMoreElements() && !found){
			if(Dico.get(current).containsKey(mot)){
				found = true;
			}else{
				current = keys.nextElement();
			}
		}

		return found;
	}
}
