/*
 * Noah Garrison and Abhijeet Pradhan
 * COM212
 * Final Project
 * 14 May 2018
 *
 * User class: Class for Users/Students in our program
 */

public class User {

		//variables keep track of personal user data
	  private String firstName;
  	private String lastName;
  	private String email;

		//ListDQueue keeps track of the users five most recent ideas
  	private ListDQueue <Idea> ideaList = new ListDQueue<Idea>();

  	public User() {}

		//Constructor creates user, assigns variables values
  	public User(String i, String j, String k) {
    		firstName = i;
    		lastName = j;
    		email = k;
  	}

	//method returns list of user's ideas
	public ListDQueue <Idea> listOfIdeas(){
		return ideaList;
	}

	//method returns user's email
	public String email(){
		return email;
	}

	//methods adds a new idea to user's idea list
	public void addIdea(String idea) {
		String owner = firstName + " " + lastName;
		Idea suggestion = new Idea(0, 0, owner, idea);
		ideaList.addLast(suggestion);
		if (ideaList.size() > 5)
 			ideaList.removeFirst();

 	}

	//Method adds an idea which already has a rating and id to the idea list
	public Idea addIdeaRated(String idea, int id, int rating) {
		String owner = firstName + " " + lastName;
		Idea suggestion = new Idea(id, rating, owner, idea);
		ideaList.addLast(suggestion);
		if (ideaList.size() > 5)
 			ideaList.removeFirst();
		return suggestion;
 	}

	//toString method returns user's name and email as a string
	public String toString(){
		String userInfo = firstName + " " + lastName + "\n" + ideaList.toString();
		return userInfo;
	}

}
class userTest{
	public static void main(String [] args){
		User abhijeet = new User("Abhijeet", "pradhan", "apradha1@conncoll.edu");
		abhijeet.addIdea("Host a concert");
		abhijeet.addIdea("hello");
		abhijeet.addIdea("hello");
		abhijeet.addIdea("hello");
		abhijeet.addIdea("hello");
		abhijeet.addIdea("hello");
		System.out.println(abhijeet);

	}
}
