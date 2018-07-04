/*
 * Noah Garrison and Abhijeet Pradhan
 * COM212
 * Final Project
 * 14 May 2018
 *
 * AdminMode class: Keeps track of methods for adminMode commands
 */
// a little bit of modification 
public class AdminMode{
	private SinglyLinkedList <String> awardedIdeas = new SinglyLinkedList<String> (); 
	
	//candidate method returns the best idea in the idea heap
	public String candidate(HeapArrayList<Integer, Idea> topIdea){
		Idea bestIdea  = topIdea.getMax();
		return bestIdea.toString();
	}

	//award method returns the top idea and removes it from the heap
	public Idea award(HeapArrayList<Integer, Idea> awardIdea){
		Idea bestIdea  = awardIdea.removeMax();
		awardedIdeas.addLast(bestIdea.toString()); 
		return bestIdea;
	}
	public String awardedIdeas(){ 
		return awardedIdeas.toString(); 
	}

}
