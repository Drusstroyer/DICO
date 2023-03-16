import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;


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
        String index = mot.substring(0, 1);
        if(this.Dico.value.compareTo(index) > 0){

            Noed nouveau = new Noed(index);
            nouveau.right = this.Dico;
            this.Dico = nouveau;

            Noed next = new Noed("");
            this.Dico.left = next;
        }
            
            
        add_rec(mot, this.Dico);
        
	}

    public boolean add_rec(String mot, Noed courant){


        if(!(mot.isEmpty())){
            String index = mot.substring(0, 1);
            
                
                
            if(courant.value.isEmpty()){

                courant.value = index;
                if(courant.left == null){

                    Noed next = new Noed("");
                    courant.left = next;
                    
                }else{
                    if(courant.left.value.compareTo(mot.substring(1,2)) >0){
                        Noed nouveau = new Noed(mot.substring(1,2));
                        nouveau.right = courant.left;
                        courant = nouveau;

                        Noed next = new Noed("");
                        courant.left = next;
                    }
                }
                    
                    if(add_rec(mot.substring(1), courant.left)){
                        courant.end = true;                        
                    }
                     
                     
                
            }else if(courant.value.compareTo(index) == 0){

                if(courant.left == null){

                    Noed next = new Noed("");
                    courant.left = next;
                    
                }else{
                    
                    if(courant.left.value.compareTo(mot.substring(1,2)) >0){
                        Noed nouveau = new Noed(mot.substring(1,2));
                        nouveau.right = courant.left;
                        courant.left = nouveau;
                    }
                }
                if(add_rec(mot.substring(1), courant.left)){
                    courant.end = true;                        
                }
                 
                
            }else if(courant.value.compareTo(index) < 0){
                if(courant.right != null){
                    
                    if(courant.right.value.compareTo(index) > 0){
                        
                        Noed nouveau = new Noed(index);
                        nouveau.right = courant.right;
                        courant.right = nouveau;
                        Noed next = new Noed("");
                        nouveau.left = next;
                        courant = nouveau;

                        if(add_rec(mot.substring(1), courant.left)){
                            courant.end = true;                        
                        }
                         
                    }else{
                        if(add_rec(mot,courant.right)){
                            courant.end = true;
                        }
                         
                    }

                }else{
                    Noed next = new Noed("");
                    courant.right = next;

                    if(add_rec(mot,courant.right)){
                        courant.end = true;
                    }
                     
                }

            }else{
                Noed nouveau = new Noed(index);
                nouveau.right = courant;
                courant = nouveau;

                Noed next = new Noed("");
                courant.left = next;
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
        boolean found = false;
        
        Noed courant = this.Dico;
        
        
            
            while(mot.length() !=0){
                String index = mot.substring(0,1);
                               
                if(courant.value.compareTo(index) ==0){
                    if(courant.left != null){
                        found = courant.end;
                        courant = courant.left;
                        mot = mot.substring(1);
                        
                    }          
                                
                }else if(courant.value.compareTo(index) > 0){
                     
                    if(courant.right != null){
                        courant = courant.right;
                    }else{
                        return false;
                    }
                    
                }else if(courant.value.compareTo(index) < 0){
                     
                    if(courant.right != null){
                        courant = courant.right;
                    }else{
                        return false;
                    }
                }
                
            }

        
        return found;
        
	}


    @Override
    public Iterator<Character> widthIterator() {
		LinkedList<Noed> fifo = new LinkedList<Noed>();
        ArrayList<Character> CharDico = new ArrayList<Character>();
        Noed courant = this.Dico;
        
        fifo.add(courant);
        if(!(courant.value.isEmpty()))
                CharDico.add(courant.value.charAt(0));
        while(fifo.size()>0){
            
            courant = fifo.removeFirst();

            if(courant.right != null){
                fifo.add(courant.right);
                if(!(courant.right.value.isEmpty()))
                    CharDico.add(courant.right.value.charAt(0));
            }

            if(courant.left != null){
                fifo.add(courant.left);
                if(!(courant.left.value.isEmpty()))
                    CharDico.add(courant.left.value.charAt(0));
            }

            

        }

        Iterator<Character> Iter = CharDico.iterator();
        return Iter;
    }


    @Override
    public Iterator<Character> prefixedDepthFirstIterator() {
		ArrayList<Character> CharDico = new ArrayList<Character>();
        Noed courant = this.Dico;

        
        if(!(courant.value.isEmpty())){
            CharDico.add(courant.value.charAt(0));
            if(courant.left != null)
                Prefix_iter(CharDico,courant.left);

            if(courant.right !=null)
                Prefix_iter(CharDico,courant.right);
        }
        

        Iterator<Character> Iter = CharDico.iterator();
        return Iter;
	}

    public void Prefix_iter(ArrayList<Character> CharDico, Noed courant){
         
        if(!(courant.value.isEmpty())){
            CharDico.add(courant.value.charAt(0));
            if(courant.left != null)
                Prefix_iter(CharDico,courant.left);

            if(courant.right !=null)
                Prefix_iter(CharDico,courant.right);
        }
            
    }
    public void infix_iter(ArrayList<Character> CharDico, Noed courant){
        if (!(courant.value.isEmpty())){
            
            if(courant.left != null)
                infix_iter(CharDico,courant.left);

            CharDico.add(courant.value.charAt(0));

            if(courant.right !=null)
                infix_iter(CharDico,courant.right);
        }
            
    }

    @Override
    public Iterator<Character> infixedDepthFirstIterator() {
		ArrayList<Character> CharDico = new ArrayList<Character>();
        Noed courant = this.Dico;

        
        if (!(courant.value.isEmpty())){
            
            if(courant.left != null)
                infix_iter(CharDico,courant.left);

            CharDico.add(courant.value.charAt(0));

            if(courant.right !=null)
                infix_iter(CharDico,courant.right);
        }
        

        Iterator<Character> Iter = CharDico.iterator();
        return Iter;
	}


    public void Postfix_iter(ArrayList<Character> CharDico, Noed courant){
        if (!(courant.value.isEmpty())){
            
            if(courant.left != null)
                Postfix_iter(CharDico,courant.left);

            CharDico.add(courant.value.charAt(0));

            if(courant.right !=null)
                Postfix_iter(CharDico,courant.right);
        }
            
    }

    @Override
    public Iterator<Character> postfixedDepthFirstIterator() {
		ArrayList<Character> CharDico = new ArrayList<Character>();
        Noed courant = this.Dico;

        
        if (!(courant.value.isEmpty())){
            
            if(courant.left != null)
                Postfix_iter(CharDico,courant.left);

            CharDico.add(courant.value.charAt(0));

            if(courant.right !=null)
                Postfix_iter(CharDico,courant.right);
        }
        

        Iterator<Character> Iter = CharDico.iterator();
        return Iter;
	}

}
