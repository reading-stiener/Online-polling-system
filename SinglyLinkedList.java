public class SinglyLinkedList<E> {
	
	private Node<E> head = null;
	private Node<E> tail = null;
	private int size = 0;
	
	public SinglyLinkedList() {
		// not much to do here!
	}
	
	public int size() { return size;}
	public boolean isEmpty() { return size == 0;}
	
	public E first() {
		if (isEmpty())
			return null;
		
		return head.getElement();
	}
	
	public E last() {
		if (isEmpty())
			return null;
		
		return tail.getElement();
	}
	
	public E get(int index) {
		
		// error check
		if (index >= size) {
			System.out.println("Error: index out of range");
			return null;
		}
			
		Node<E> n = head;
		for (int i=0; i<index; i++) {
			n = n.getNext();
		}
		
		return n.getElement();
	}
	public boolean isInList(E e){ 
		Node <E> n = head; 
		while (n != null){ 
			if (n.getElement() == e)
				return true; 
			n = n.getNext(); 
		} 
		return false; 
	} 

	
	public void addFirst(E s) {
		Node<E> n = new Node<>(head, s);
		head = n;
		
		if (size==0)
			tail = n;
		
		size++;
	}
	
	public void addLast(E s) {
		Node<E> n = new Node<>(s);
		if (size == 0)
			head = n;
		else
			tail.setNext(n);
				
		tail = n;		
			
		size++;
	}
	
	public E removeFirst() {
		
		if (isEmpty()) {
			System.out.println("Error: The list is empty.");
			return null;
		}
		
		E s = head.getElement();
		head = head.getNext();
		size--;
		if (size==0)
			tail = null;
			
		return s;
	}
	
	public String toString() {
		
		if (size == 0)
			return "The list is empty";
		
		String outstr = "";
		Node<E> n = head;	
		while (n != null) {
			outstr = outstr + n.getElement().toString() + "\n";
			n = n.getNext();
		} 
		return outstr;
	}
	
	public static void main(String[] args) {
		
	}
}
