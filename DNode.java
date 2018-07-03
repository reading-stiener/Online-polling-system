/*
 *	COM212 Data Structure (S. James Lee)
 *	Node class for doubly linked list adjusted from Goodrich
 *
 *	1/19/2018
*/

public class DNode <E> {

	protected E element;  	// integer element stored by a node
	protected DNode next, prev; // Pointers to next and previous nodes

	/** Constructor that creates a node with given  */
	public DNode(E e, DNode p, DNode n) {
		element = e;
		prev = p;
		next = n;
	}

	/** Returns the element of this node */
	public E getElement() {  return element; }

	/** Returns the previous node of this node */
	public DNode getPrev() {  return prev; }

	/** Returns the next node of this node */
	public DNode getNext() {  return next; }

	/** Sets the element of this node */
	public void setElement(E newElem) { element = newElem; }

	/** Sets the previous node of this node */
	public void setPrev(DNode newPrev) { prev = newPrev; }

	/** Sets the next node of this node */
	public void setNext(DNode newNext) { next = newNext; }

	public String toString() {
		// implement toString method to return element value in String type
		return element.toString();
	}

	public static void main(String [] args) {}
}
