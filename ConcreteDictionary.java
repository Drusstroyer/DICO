import java.util.ArrayList;
import java.util.Iterator;


public class ConcreteDictionary extends Dictionary {
	ArrayList<String> Dico;
	public ConcreteDictionary(){
		Dico = new ArrayList<String>();

	}
	@Override
	public void add(String mot) {
		
		if(!(this.Dico.contains(mot))){
			this.Dico.add(mot);
		}
	}

	@Override
	public boolean find(String mot) {
		return this.Dico.contains(mot);
	}

	@Override
	public Iterator<String> wordIterator() {
		
		Iterator<String> it = this.Dico.iterator();
		return it;
	}
}
