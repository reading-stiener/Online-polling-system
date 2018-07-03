/**
 * COM212 Data Structure
 * DQueue implementation with List
 *
 * by S. James Lee
 */

public class ListDQueue<E> {

	private DLinkedList<E> aList;

	public ListDQueue() {
		aList = new DLinkedList<E>();
	}

	public int size() { return aList.size(); }
	public boolean isEmpty() { return aList.isEmpty();}

	public void addFirst(E e) {

		aList.addFirst(e);
	}

	public void addLast(E e) {

		aList.addLast(e);
	}

	public E removeFirst() {
		return aList.removeFirst();
	}

	public E removeLast() {
		return aList.removeLast();
	}

	public E getFirst() {
		return aList.first();
	}
	public void remove(E e){ 
		aList.remove(aList.get()); 
	} 

	public E getLast() {
		return aList.last();
	}

	public String toString() {

		return aList.toString();
	}

	public static void main(String[] args) {

		ArrayDQueue<String> myDQueue = new ArrayDQueue<String>();
		myDQueue.addFirst("James");
		myDQueue.addFirst("S.");
		myDQueue.addLast("Lee");
		System.out.println(myDQueue);
		myDQueue.removeFirst();
		System.out.println(myDQueue);
		myDQueue.removeLast();
		System.out.println(myDQueue);
	}
}
