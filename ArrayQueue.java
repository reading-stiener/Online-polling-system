public class Array Queue <E> {

  private int f, r;
  private E[] aArray;
  private int size;
  private int capacity;

  public ArrayQueue() {
    aArray = new E[5]);
    capacity = 5;
  }

  public int size() { return size; }

  public boolean isEmpty() { return (size == 0); }

  public void enqueue(E e) {
    if(size == capacity) {
      System.out.println("Queue is full.");
      return;
    }
    aArray[r] = e;
    r = (r+1) % capacity;
    size++;
  }

  public E dequeue() {
    if(size == 0) {
      System.out.println("Queue is empty.");
      return null;
    }
    E e = aArray[f];
    aArray[f] = null;
    f = (f+1) % capacity;
    size++;
    return e;
  }

  public E front() {
    if(size == 0) {
      System.out.println("Queue is empty");
      return null;
    }
    return aArray[f];
  }
  public String toString() {
    String str = "";
    for(int i = f; i < size; i++)
  }
}
