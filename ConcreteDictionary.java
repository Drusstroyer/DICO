import java.util.Iterator;


public class ConcreteDictionary extends Dictionary {
	static class Noed{
        String value;
        Noed left, right;
        boolean end;
        Noed(String val){
            this.value = val;
            this.end = false;
            this.left=null;
            this.right=null;
        }
    }
	Noed Dico;
    public ConcreteDictionary(){
        this.Dico = new Noed("");
    }


	@Override
	public void add(String mot) {
        Noed courant = this.Dico;
        add_rec(mot, courant);
        
	}

    public boolean add_rec(String mot, Noed courant){
        if(!(mot.isEmpty())){
            String index = mot.substring(0, 1);
            if(courant.value.isEmpty()){

                courant.value = index;
                if(courant.left == null){

                    Noed next = new Noed("");
                    courant.left = next;
                    
                }
                    
                    if(add_rec(mot.substring(1), courant.left)){
                        courant.end = true;                        
                    }
                
            }else if(courant.value.compareTo(index) == 0){

                if(courant.left == null){

                    Noed next = new Noed("");
                    courant.left = next;
                    
                }
                if(add_rec(mot.substring(1), courant.left)){
                    courant.end = true;                        
                }
                
            }else if(courant.value.compareTo(index) > 0){
                if(courant.right.value.compareTo(index) < 0){
                    
                    Noed nouveau = new Noed(index);
                    nouveau.right = courant.right;
                    courant.right = nouveau;
                    Noed next = new Noed("");
                    nouveau.left = next;
                    courant = nouveau;
                    
                }
                if(add_rec(mot.substring(1), courant.left)){
                    courant.end = true;                        
                }
            }


            return false;
        }else{
            
            return true;
        }
    }

	@Override
	public boolean find(String mot) {
        return false;
        
	}

}
