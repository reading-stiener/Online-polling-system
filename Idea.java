/*
 * Noah Garrison and Abhijeet Pradhan
 * COM212
 * Final Project
 * 14 May 2018
 *
 * Idea class: Keeps track of Idea and all related variables
 */
public class Idea{

	//Variables
	private int id;
	private int rating;
 	private String description;
  private String owner;
	private String email;
	//List holds emails of user who have voted for this idea
	private SinglyLinkedList <String> voters;

	//Constructor takes required fields to create idea
 	public Idea(int i, int j, String owner, String k) {
    		id = i;
    		rating = j;
    		description = k;
				this.owner = owner;
				voters = new SinglyLinkedList<String>();

  	}

	//getId method returns idea id
	public int getId(){
		return id;
	}

	//getRating method returns idea rating
	public int getRating(){
		return rating;
	}

	//setEmail method allows user to set idea owner's email
	public void setEmail(String email){
		this.email = email;
	}

	//getEmail method returns email of idea owner
	public String getEmail(){
		return email;
	}

	//addVoter method adds the email of a user who has voted for the idea to voters list
	public void addVoter(String email){
		voters.addLast(email);
		rating++;

	}

	//checkVoters method returns true if user (identified by email) has already voted for the idea
	public boolean checkVoters(String email){
		return voters.isInList(email);
	}

	//toString method returns idea in orderly way
	public String toString(){
		return id + " | " + rating + " | " + description + "\n";
	}


}
