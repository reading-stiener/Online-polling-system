public class HeapNode<K, V>{ 
	public K key; 
	public V value; 
	public HeapNode(K k, V v){ 
		key = k; 
		value = v; 
	} 
	public K getKey(){ return key; }
	public V getElement(){ return value; } 
	public void setKey(K k){ key = k; } 
	public void setElement(V s){ value = s; } 
	public String toString(){ 
		return "(" + key + "," + value + ")"; 
	} 
} 
 

