import java.text.Normalizer;

public class ListaEncadeadaOrdenada {
	// Representação
	private ListNode head;
	private ListNode tail;
	private int size;

	private class ListNode {
		private Comparable element;
		private ListNode next;

		private ListNode(Comparable e, ListNode n) {
			element = e;
			next = n;
		}
	}

	// Construtores
	public ListaEncadeadaOrdenada() {
		size = 0;
		head = tail = null;
	}

	// Métodos
	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return (head == null);
	}

	public boolean add(Comparable elem) {
		ListNode newElement = new ListNode(elem, null);
		if (head == null) // insere em uma lista vazia
			head = tail = newElement;
		else
			tail.next = newElement;
		tail = newElement;
		size++;
		return true;
	}

	public void clear() {
		head = tail = null;
		size = 0;
	}

	public void print() {
		if (size == 0)
			System.out.println("<----Lista Vazia---->");

		else {
			System.out.println("<----Início---->");
			ListNode itr = head;
			while (itr != null) {
				System.out.println(itr.element);
				itr = itr.next;
			}
			System.out.println("<----Fim---->");
		}

	}

	public Comparable get(int index) {
		if (index < 0 || index > size - 1)
			throw new IndexOutOfBoundsException("Index=" + index + " e Size=" + size);
		else {
			if (index == 0) // caso particular (previous = null)
				return head.element;
			ListNode previous = findPrevious(index);
			return previous.next.element;
		}
	}

	private ListNode findPrevious(int index) {
		ListNode itr = head;
		ListNode previous = null;
		for (int i = 0; i < size; i++) {
			if (i == index)
				return previous;
			previous = itr;
			itr = itr.next;
		}
		return previous;
	}

	public int indexOf(Comparable elem) {
		ListNode itr = head;
		for (int i = 0; i < size; i++) {
			if (itr.element.equals(elem)) {
				return i;
			} else {
				itr = itr.next;
			}
		}
		return -1;
	}

	public void add(int index, Comparable elem) {
		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException("Index=" + index + " e Size=" + size);
		else {
			if (index == 0) { // insere o elemento na posicao head
				if (head == null) { // insere em uma lista vazia
					ListNode newElement = new ListNode(elem, null);
					head = tail = newElement;
				} else { // insere em uma lista com um ou mais elementos
					ListNode newElement = new ListNode(elem, head);
					head = newElement;
				}
			} else {
				ListNode previous = findPrevious(index);
				ListNode newElement = new ListNode(elem, previous.next);
				previous.next = newElement;
				if (newElement.next == null) // o novo elemento e o novo tail
					tail = newElement;
			}
		}
		size++;
	}

	public Comparable remove(int index) {
		Comparable toBeDeleted;
		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException("Index=" + index + " e Size=" + size);
		else {
			if (index == 0) { // remove o elemento na posicao head
				toBeDeleted = head.element;
				if (head == tail) // remove de uma lista com um unico elemento
					head = tail = null;
				else // remove de uma lista com mais de um elemento
					head = head.next;
			} else { // remove um elemento diferente do head
				ListNode previous = findPrevious(index);
				toBeDeleted = previous.element;
				if (previous.next == tail) // considera a remocao do no tail
					tail = previous;
				previous.next = previous.next.next;
			}
			size--;
		}
		return toBeDeleted;
	}

	public boolean remove(Comparable elem) {
		int index = indexOf(elem);
		if (index < 0)
			return false;
		remove(index);
		return true;
	}

	public Comparable set(int index, Comparable elem) {
		Comparable toBeOverridden;
		if (index < 0 || index > size - 1)
			throw new IndexOutOfBoundsException("Index=" + index + " e Size=" + size);
		else {
			if (index == 0) {
				toBeOverridden = head.element;
				head.element = elem;
			} else {
				ListNode previous = findPrevious(index);
				toBeOverridden = previous.next.element;
				previous.next.element = elem;
			}
		}
		return toBeOverridden;
	}

	public void sort() {
	    if (head == null || head.next == null) { // Lista vazia ou com um elemento apenas
	        return;
	    }

	    ListNode itr;
	    Comparable tmp;
	    boolean troca;

	    do {
	        troca = false;
	        itr = head; 
	        
	        while (itr.next != null) {
	            String nome1 = removerAcentos(itr.element.toString()).toUpperCase();
	            String nome2 = removerAcentos(itr.next.element.toString()).toUpperCase();

	            if (nome1.compareTo(nome2) > 0) {
	                tmp = itr.element;
	                itr.element = itr.next.element;
	                itr.next.element = tmp;
	                troca = true;
	            }
	            itr = itr.next; 
	        }
	    } while (troca); 
	}

	private String removerAcentos(String texto) { // Retirar os acentos
		return Normalizer.normalize(texto, Normalizer.Form.NFD)
				.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
	}
}