// Priority Queue with ArrayList based heap implementation

public class PQueueHeapArrayList <K, V> {

	private HeapArrayList<K,V> heap;
	
	public PQueueHeapArrayList() {
		heap = new HeapArrayList<K, V>();
	}
	
	public int size() { return heap.size();}
	public boolean isEmpty() { return heap.size() == 0;}
	
	public void insert(K k, V v) {
		heap.insert(k, v);
	}
	
	public V removeMin() {
		if (heap.size() == 0)
			return null;
			
		return heap.removeMin().getElement();
	}
	
	public V min() {
		if (heap.size() == 0)
			return null;
		
		return heap.root().getElement();
	}
	
	public String toString() {
		return heap.toString();
	}
	
	public static void main(String[] args) {
		
		PQueueHeapArrayList<Integer,String> pq = new PQueueHeapArrayList<Integer,String>();
		pq.insert(1, "1");
		pq.insert(3, "3");
		pq.insert(5, "5");
		pq.insert(10, "10");
		pq.insert(8, "8");
		pq.insert(4, "4");
		System.out.println(pq);
		System.out.println("min " + pq.removeMin() + " is removed.");
		System.out.println(pq);
		System.out.println("min " + pq.removeMin() + " is removed.");
		System.out.println(pq);
		
	}	
}