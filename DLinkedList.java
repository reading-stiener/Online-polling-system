/*
 *	COM212 Data Structure (S. James Lee)
 *	DLinkedList class for doubly linked list adjusted from Goodrich
 *
 *	1/19/2018
 */


public  class DLinkedList<E> {

	protected int size;	 				// number of elements
	protected DNode<E> header, trailer;	// sentinels

	/** Constructor that creates an empty list */
	public DLinkedList() {
		size = 0;
		header =  new DNode<E>(null, null,  null);		// create header
		trailer =  new DNode<E>(null, header,  null);	// create trailer
		header.setNext(trailer);	 				// make header and trailer point to each other
	}

	/** Returns the number of elements in the list */
	public int size() { return size; }

	/** Returns whether the list is empty */
	public boolean isEmpty() {

		return (size == 0);
	}

	/** Returns the element of the first node of the list */
	public E getFirst()	 throws IllegalStateException {
		if (isEmpty())	throw  new IllegalStateException("List is  empty");
		return (E)header.getNext().getElement();
	}

	/** Returns the element of the last node of the list */
	public E getLast()	throws IllegalStateException {
		if (isEmpty())	throw  new IllegalStateException("List is  empty");
		return (E)trailer.getPrev().getElement();
	}

	/** Returns the node before the given node v. An error occurs if v
	* is the header */
	private DNode<E> getPrev(DNode<E> v)  throws IllegalArgumentException {
		if (v == header)  throw	 new IllegalArgumentException
		("Cannot move  back	 past  the	header of  the	list");

		return v.getPrev();
	}

	/** Returns the node after the given node v. An error occurs if v
	* is the trailer */
	private DNode<E> getNext(DNode<E> v)  throws IllegalArgumentException {
		if (v == trailer)  throw  new IllegalArgumentException
		("Cannot move  forward past	 the  trailer of  the  list");

		return v.getNext();
	}

	public void addFirst(E e) {
		addBetween(e, header, header.getNext());
	}

	public void addLast(E e) {
		addBetween(e,trailer.getPrev(),trailer);
	}

	public E removeFirst() {
		if (size == 0)
			return null;

		return (E)remove(header.getNext());
	}

	public E removeLast() {
		if (size == 0)
			return null;

		return (E)remove(trailer.getPrev());
	}

	private void addBetween(E e, DNode<E> p, DNode<E> n) {
		DNode<E> newNode = new DNode(e, p, n);
		p.setNext(newNode);
		n.setPrev(newNode);
		size++;
	}

	public E remove(DNode<E> v) {

		DNode<E> p = v.getPrev();
		DNode<E> n = v.getNext();
		p.setNext(n);
		n.setPrev(p);

		v.setPrev(null);
		v.setNext(null);

		size--;

		return v.getElement();
	}
	public DNode<E> get(E element){ 
		DNode <E> curNode = header.getNext(); 
		while (curNode != trailer){ 
			if (curNode.getElement() == element) 
				return curNode; 
			curNode = curNode.getNext(); 
		} 
		return null; 
	} 

	public String toString() {
		// this method returns string including values of all elements in the list
		// as DNode has its own toString method (you should implement it),
		// you may directly concatenae it to compose a string
		if (size==0)
			return "";

		DNode<E> curNode = header.getNext();
		String outStr = "";
		while (curNode != trailer) {
			outStr = outStr + curNode;
			curNode = curNode.getNext();
		}

		return outStr;

	}

	public static void main(String [] args) {}
}
