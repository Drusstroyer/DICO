import java.util.Iterator;


public class ConcreteDictionary extends Dictionary {
	static class Noed{
        String value;
        Noed left, right;

        Noed(String val){
            this.value = val;
            left=null;
            right=null;
        }
    }
	Noed Dico;
    public ConcreteDictionary(){
        this.Dico = new Noed("");
    }


	@Override
	public void add(String mot) {
        String index = mot.substring(0, 1);
        if(this.Dico.value.isEmpty()){
            Noed current = Dico;
            Dico.value = mot.substring(0, 1);
            for(int i =1; i < mot.length();i++){
                Noed nextchar = new Noed(mot.substring(i, i+1));
                System.out.println(nextchar.value);
                current.left = nextchar;
                current = current.left;
            }
            current.value = current.value+'*';
        }else if(this.Dico.value.equals(index)){
            Noed current = Dico.left;
            for(int i =1; i < mot.length();i++){
                Noed nextchar = new Noed(mot.substring(i, i+1));
                if( (current.value.equals(nextchar.value)) && (current.left != null) ){
                    current = current.left;
                }else{
                    if(current.left != null){
                        System.out.println(nextchar.value);
                        current.right = nextchar;
                        current = current.right;
                    }else{
                        System.out.println(nextchar.value);
                        current.left = nextchar;
                        current = current.left;
                    }
                }
            }
            current.value = current.value+'*';
        }else{
            Noed current = Dico;
            while(current.right != null || !(current.value.equals(index))){
                current = current.right;
            }
            if(current.value.equals(index)){
                for(int i =1; i < mot.length();i++){
                    Noed nextchar = new Noed(mot.substring(i, i+1));
                    if(current.left.value.equals(nextchar.value) || current.left.value.equals(nextchar.value +"*")){
                        current = current.left;
                    }else if(current.right.value.equals(nextchar.value) || current.right.value.equals(nextchar.value +"*")){
                        current = current.right;
                    }
                    current.left = nextchar;
                    current = current.left;
                }
                current.value = current.value+'*';
            }
            
        }
	}

	@Override
	public boolean find(String mot) {
		boolean found = false;
        Noed current = Dico;
        while(current.value.equals(mot.substring(0, 1))){
            current = current.right;
        }
        if(current.value.equals(mot.substring(0, 1))){
            for(int i =1; i <mot.length(); i++){
                if(current.left.value.equals(mot.substring(i, i+1))){
                    current = current.left;
                }else if(current.right.value.equals(mot.substring(i, i+1))){
                    current = current.right;
                }
            }
            if(current.value.equals(mot.substring(mot.length()-1,mot.length())+ "*")){
                found = true;
            }
            return found;
        }else{
            return found;
        }
        
	}

}
