public class ListacomArrayOrdenada {

    // Representação
    private Comparable[] elements;	// array de objetos
    private int size;			// número de elementos na lista
    private int capacity;		// capacidade inicial da lista
   
    // Construtores
    public ListacomArrayOrdenada() {
	   capacity=5;
       elements=new Comparable[capacity];
       size=0;                  
   }  
   public ListacomArrayOrdenada(int capacity) {
	   this.capacity=capacity;
       elements=new Comparable[capacity];
       size=0;                  
   }  
   public int size() {
	   return size;
   }
   public boolean isEmpty() {
	   return (size==0);        
   }
	public void print() {
		if (size==0) 
			System.out.println("<----Lista Vazia---->");			
		else {
			System.out.println("<----Início---->");
			for (int i=0;i<size;i++) 
		        		System.out.println(elements[i]); 
			System.out.println("<----Fim---->");				
		}
	}   
	public int indexOf (Comparable elem ) {
	     for (int i=0;i<size;i++)
	       if (elements[i].equals(elem)) 
	         return i;
	     return -1;
	 }
   public boolean add (Comparable elem) {
	   aumenteCapacidadeSeNecessario();
	   elements[size]=elem;
	   size++;
	   return true; // considera que a lista sempre permite elementos repetidos. 
	}

	private void aumenteCapacidadeSeNecessario() {
		if  (size==capacity) {
			Comparable[] newElements=new Comparable[capacity*2];
	     		for (int i=0;i<size;i++) 
	        		newElements[i]=elements[i];
	     		elements=newElements;
	     		capacity*=2;
	       }
	}
	public void clear() {
		size=0;
		for (int i=0;i<size; i++)
			elements[i]=null;
	}

	public Comparable get (int index) {
	   	if (index<0 || index>size-1)
			throw new IndexOutOfBoundsException("Index="+index+" e Size="+size);
	 	else 
	     		return elements[index];
	}

	public void add (int index,Comparable elem) {
	if (index<0 || index>size)
	   throw new IndexOutOfBoundsException("Index="+index+" e Size="+size );
 	
       aumenteCapacidadeSeNecessario();
       for (int i=size;i>index;i--) 
         	elements[i]=elements[i-1];
       elements[index]=elem;
     	size++;
	}
	public Object remove (int index) {
		Object toBeDeleted;
		if (index<0 || index>size)
			throw new IndexOutOfBoundsException("Index="+index+" e Size="+size);
		else {
			toBeDeleted=elements[index];
		    size--;
		    for (int i=index;i<size;i++) 
		    	elements[i]=elements[i+1];
		}
		return toBeDeleted;
	}
	public boolean remove (Comparable elem) {
	     int index=indexOf(elem);
	     if (index<0) return false; 
	     remove(index);
	     return true;
	}
	public Comparable set (int index,Comparable elem) {
		if (index<0 || index>size)
			throw new IndexOutOfBoundsException("Index="+index+" e Size="+size );
	
		Comparable elementReplaced=elements[index];
		elements[index]=elem;
		return elementReplaced; 	
	}
	
	public void sort() {
	      Comparable tmp;
	      for (int i=0;i<size;i++) {
	        for (int j=i+1;j<size;j++) {
	           if (elements[i].compareTo(elements[j])>0) {
	               tmp=elements[i];
	               elements[i]=elements[j];
	               elements[j]=tmp;
	           }
	        }
	      }
	}
}
