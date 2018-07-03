// ArrayList based heap implementation

import java.util.*; 

public class HeapArrayList <K, V> {
	
	protected ArrayList < HeapNode<K, V> > heap;
	protected Comparator<K> comp;
		
		
		
	public HeapArrayList() {
		heap = new ArrayList< HeapNode<K,V> >();
		heap.add(0,null);	// we don't use the first spot in the arraylist
		comp = new DefaultComparator<K>();
	}
	
	public int size() { return heap.size()-1;}
	public boolean isEmpty() { return heap.size() == 1;}
	public V getMax(){ 
		if (isEmpty())
			return null; 
		return heap.get(1).getElement(); 
	} 

	public HeapNode<K, V> root() {
		if (isEmpty())
			return null;
			
		return heap.get(1);
	}
	
	public V removeMax() {
		
		if (heap.size()==1)	// heap is empty
			return null;
		
		HeapNode<K, V> root = heap.get(1);	// root node
		
		if (heap.size() == 2) {		// root is the only one
			heap.remove(1);
		} else {
		//	System.out.println("size "+ heap.size());  
		//	System.out.println(heap.get(heap.size() - 1)); 
			heap.set(1, heap.get(heap.size()-1));
		//	System.out.println(heap.get(1)); 
			heap.remove(heap.size()-1);
			downHeap(1);
		}
				
		return root.getElement();
	}

		
	
	public void insert(K k, V v) {
		HeapNode<K, V> node = new HeapNode<K,V>(k, v);
		heap.add(heap.size(), node);
		upHeap(heap.size()-1);		
	}
	
	public void swap(int x, int y) {
		HeapNode<K,V> tempNode = heap.get(x);
		heap.set(x, heap.get(y));
		heap.set(y, tempNode);
		
	}
	public ArrayList<HeapNode <K, V>> getHeap(){
		return heap; 
	} 
 
		
 
		
	
	public void upHeap(int v) {
		
		// compare v's key to parent's key
		// check if v has a parent
		if (v == 1)		// root. no more to go
			return;
		
		int u = (int)(v / 2);	// parent index
		if (comp.compare(heap.get(v).getKey(), heap.get(u).getKey()) > 0 ) {
			swap(u, v);

			upHeap(u);	
		}
		// else: do nothing
	}
	
	public void downHeap(int v) {
		
		// check if v has children
		int u = v * 2;	// assume left child
		
		// external node?
		if (heap.size()-1  < u){
			//System.out.println("i run"); 
			return;
		}
		// find node for next progress
		else if (heap.size()-1 > u) {	// has both children
			
			if (comp.compare(heap.get(u+1).getKey(), heap.get(u).getKey() ) > 0)
				u = u+1;
		}

		// recursive call
		if ( comp.compare( heap.get(u).getKey(), heap.get(v).getKey()) > 0 ) {
			//System.out.println("this rums "); 
			swap(u, v);
			//System.out.println("this runs too");
			//System.out.println("u " + u); 
			downHeap(u);	
		}
		
	} 
	
	
	public String toString() {
		
		return heap.toString();
	}
	
	
	public static void main(String[] args) {
		
		HeapArrayList <Integer, String> h = new HeapArrayList<Integer, String>();
		h.insert(1, "1");
		h.insert(3, "3");
		h.insert(5, "5");
		h.insert(10, "10");
		h.insert(8, "8");
		h.insert(4, "4");
		System.out.println(h);
		h.removeMax();
		System.out.println(h);
		h.removeMax();
		System.out.println(h);

		
		
	}	
}
