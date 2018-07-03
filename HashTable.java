/*
 *	Simple HashTable implementation
 *
 *	COM212 Data Structure
 *	James Lee (james.lee@conncoll.edu)
*/


class HashEntry {
	private int key;
	private User value;
	
	HashEntry(int k, User v) { this.key = k; this.value = v; }     
	public int getKey() { return key; }
	public User getValue() { return value; }
}


class HashTable {

	// class fields
	private int capacity;
	private int size;
	private static HashEntry AVAILABLE = new HashEntry(0, null);
	private HashEntry[] table;
	
	// constructor
	public HashTable() {
		capacity = 1000;		// prime number
		size = 0;			// current size of the table
		table = new HashEntry[capacity];	// array to store entries
	}
	
	public boolean isEmpty() { return size==0;}
	public int size() { return size; }
	
	// get value from hashtable via key
	public HashEntry get(int key) {
		int i = Math.abs(key) % capacity; 
		int p = 0; 
		while (p != capacity){ 
			if (table[i] == null)
				return null; 
			else if (table[i].getKey() == key)
				return table[i]; 
			i = (i + 1) % capacity; 
			p++; 
		} 	
		// none found
		System.out.println("get error: HashTable has no entry for a key, " + key);
		return null;
	}
	
	public void put(int key, User value) {
		int i = Math.abs(key) % capacity;
		//System.out.println("index " + i); 
 
		int p = 0; 

		while (p != capacity){ 
		 	if (table[i] == null || table[i] == AVAILABLE){
				HashEntry newEntry =  new HashEntry(key, value); 
				table[i] = newEntry; 
				size++; 
				break;
			} 

			i = (i + 1) % capacity; 
			p++;
 		} 
		if (p == capacity) 
			System.out.println("table full"); 
		
				
		
		
		
	}
	
	public String remove(int key) {
		int i  = Math.abs(key)% capacity; 
		int p = 0; 
		while (p != capacity){ 
			if (table[i] == null) 
				return null; 
			else if (table[i].getKey() == key){
				HashEntry e = table[i]; 
				table[i] = AVAILABLE; 
				size--;
				return e.getValue().toString();
			}  
	
			i = (i +1)% capacity;
			p++; 
			
 
		}	

		
		
		
		// none found: cannot remove
		System.out.println("remove error: HashTable has no entry for a key, " + key);
		return null;
	}
	
	public String toString() {
	
		String outString = "";
		for (int i=0; i<capacity; i++) {
			
			if (table[i]!=null && table[i] != AVAILABLE)
				outString += ("@" + i + ", key: " + table[i].getKey() + ", value: " + table[i].getValue() + "\n");
		}
		return outString;
	}
	
	public static void main(String[] args) {
		
		HashTable ht = new HashTable();
		User noah = new User("Noah", "garrison", "ngarriso@conncoll.edu"); 
		noah.addIdea("say hello"); 
		User abhijeet = new User("abhijeet", "pradhan", "apradha1@conncoll.edu");
		abhijeet.addIdea("code code code"); 
		System.out.println(abhijeet.email().hashCode()); 
		System.out.println(noah.email().hashCode()); 

	 
		ht.put(abhijeet.email().hashCode(), abhijeet);
		ht.put(noah.email().hashCode(), noah); 

		//ht.put("bb".hashCode(), "bb");
		//ht.put("cc".hashCode(), "cc");
		//ht.put("zz".hashCode(), "zz");
		
		System.out.println(ht);
		
		//ht.remove("bb".hashCode());
		
		System.out.println(ht);
		
		//System.out.println(ht.get("bb".hashCode()));

	}
}
