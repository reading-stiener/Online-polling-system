/*
 * Noah Garrison and Abhijeet Pradhan
 * COM212
 * Final Project
 * 14 May 2018
 *
 * UserMode class: Contains methods for operations to be performed while in userMode
 */
public class UserMode{

	//idea method returns user name and ideas
	private ListDQueue <Idea> recentIdeas = new ListDQueue<Idea>();
	public String idea(User participant){
		return participant.toString();
	}

	//addIdea method adds new idea to user and returns idea 
	public Idea addIdea(User participant, String suggestion, int idNums, int rating){
		Idea newIdea = participant.addIdeaRated(suggestion, idNums, rating);
		recentIdeas.addLast(newIdea); 
		if (recentIdeas.size() > 10)
			recentIdeas.removeFirst(); 
		return newIdea; 
	}

	//other method returns ideas of another user
	public String other(String email, HashTable table){
		String otherInfo = table.get(email.hashCode()).getValue().toString();
		return otherInfo;
	}

	//vote method allows user to vote for for a specifc idea by id
	public int vote(int id, HeapArrayList<Integer, Idea> list){
		for (int i = 1; i <= list.size(); i++){
			if (list.getHeap().get(i).getElement().getId() == id)
				return i;
		}
		return -1;
	}
	public ListDQueue<Idea> recent(){ 
		return recentIdeas; 
	} 

}
