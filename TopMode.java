/** 
 * authors: Noah and Abhijeet
 * com: 212 
 * date: May 14, 2018 
 * 
**/  

// importing modules
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

/** This is the top mode. It puts together all of the other modes like admin mode and user mode and 
 clsses like Users, and Ideas */ 
public class TopMode{ 
	// member variables. 
	public int idNums; 
	public HeapArrayList<Integer, Idea> heapIdeas; 
	public HashTable hashUsers; 	
	
	// constructor 
	public TopMode(){ 
		idNums = 0; 
		heapIdeas = new HeapArrayList(); 
		hashUsers = new HashTable(); 

	} 
	/** this the sample reader method tp create a demo user input of voters and ideas.. for testing purposees */ 
	public int sampleReader(int idNums) throws IOException{ 
		// we need to supply sample data filename as argument for main method
		//try{ 
		String datafile = "sampleData.txt"; 
		
		Scanner in = new Scanner(new FileReader(datafile)); 
	 

		String line = "";
		int rating = 0;
		String ideaDesc;
		String firstname, lastname, email;
		while (in.hasNextLine()) {

			// encountered empty line: move on the next line
			while (line.trim().equals("") && in.hasNextLine())
				line = in.nextLine();

			// first name
			firstname = new String(line);

			// last name
			line = in.nextLine();
			lastname = new String(line);

			// email
			line = in.nextLine();
			email = new String(line);

			// now we have all info for one student
			//System.out.println("===\nnew student record\n" + firstname + " " + lastname + "\n" +  email);

      			User n = new User(firstname, lastname, email);
      			//System.out.println(n);
			
			hashUsers.put(n.email().hashCode(), n); 

			// read in ideas
			line = in.nextLine();
			while (!line.trim().equals("") && in.hasNextLine()) {

				// tokenize: get rating (int) and idea description
			StringTokenizer strtok = new StringTokenizer(line, "|");
				if (strtok.countTokens() != 2) {
					// this is error!!!
					System.out.println("format error: " + line);
				}

				// idea rating
				rating = Integer.parseInt(strtok.nextToken().trim());

				// idea description
				ideaDesc = new String(strtok.nextToken().trim());

				// now we have info for one idea
				// use rating and ideaDesc to create idea instance
				// then, add it to anywhere necessary

				// System.out.println("idea rating: " + rating + " description: " + ideaDesc);
				 
        			Idea newIdea = n.addIdeaRated(ideaDesc, idNums, rating);
				newIdea.setEmail(email); 
				heapIdeas.insert(rating, newIdea);
        			idNums++;

				// next idea
				line = in.nextLine();

			}

      		//	System.out.println(n);

		//	System.out.println("===\n");

		}
	//	} 
	//	catch(FileNotFoundException e){ 
	//		System.out.println("file not found"); 
	//	} 
		//System.out.println(heapIdeas);
		return idNums; 

	}
	public void commands(int i){ 
		if (i == 1){ 
			System.out.println("TOP MODE"); 
			System.out.println("========\n"); 
			System.out.println("admin: takes you to admin mode\n");
			System.out.println(" user takes you to user mode \n");
			System.out.println("login <email>: takes you to user mode\n"); 
			System.out.println("addUser: add a new user and logins him into user mode\n"); 
	
		} 
		else if (i == 2){ 
		
			System.out.println("USERMODE");
			System.out.println("========\n");  
			System.out.println("idea: lists your ideas\n");
 			System.out.println("addIdea: add new idea\n");
			System.out.println("other <email>: shows other people's ideas\n");  
	 
 			System.out.println("vote: allows you to vote for an idea\n");
 			System.out.println("addIdea: add new idea\n");
			System.out.println("top: takes you back to top mode\n");  
		} 
		else if(i == 3){ 
			System.out.println("ADMINMODE"); 
			System.out.println("=========\n"); 
			System.out.println("candidate: show top rated candidate\n"); 
			System.out.println("award: award top rated candidate\n"); 
			System.out.println("top: takes you back to top mode\n"); 
		}
	}  
		
} 
/** this class is the heart of the programs. It accepts users, allows then change modes and input commands */ 
class Tester{ 
	public static void main(String[] args) throws IOException{ 
		// instantiating relevant classes 
		TopMode topMenu = new TopMode(); 
		Scanner input = new Scanner(System.in); 
		UserMode userMenu = new UserMode();
		AdminMode adminMenu = new AdminMode(); 
 
		// declaring tokenizer and mode flags to switch to different modes 
		StringTokenizer tokens;
		topMenu.idNums = topMenu.sampleReader(topMenu.idNums);  	
		boolean running = true;
		boolean userMode = false;
		boolean adminMode = false; 
		// variable to store the current user 
		boolean help = false; 
		User currentUser = null;   
		while(running){
			if (help){ 
				if (!userMode && !adminMode)
					topMenu.commands(1); 
				else if (userMode) 
					topMenu.commands(2); 
				else  
					topMenu.commands(3); 
			} 
			System.out.println("enter 'help' for commands"); 	
			tokens = new StringTokenizer(input.nextLine());
			String tok = tokens.nextToken(); 
			help = false; 
			// login mode 
 			if (tok.compareTo("login") == 0 && !userMode && !adminMode){
				try{ 
					tok = tokens.nextToken();
					// setting up current user and updating hashtable  
					currentUser =  topMenu.hashUsers.get(tok.hashCode()).getValue();
					System.out.println("UserMode");  
					userMode = true; 
				} 
				// handling exceptions
				catch(NullPointerException e){
					userMode = false; 
					System.out.println("email id not found"); 
				} 
				catch(java.util.NoSuchElementException e){ 
					System.out.println("invalid command"); 
				} 

								
			} 
			// other command in usermode
			else if(tok.compareTo("other") == 0 && userMode && !adminMode){ 
				try{ 
					// runs other method in usermode 
					tok = tokens.nextToken(); 
					System.out.println(userMenu.other(tok, topMenu.hashUsers));
				} 
				catch(java.util.NoSuchElementException e){ 
					System.out.println("Invalid command"); 
				} 
 
				
			} 
			// idea command from usermode 
			else if (tok.compareTo("idea") == 0 && userMode && !adminMode){ 
				// runs idea method in usermode 
				System.out.println(userMenu.idea(currentUser)); 
			} 

			// adduser method 
			else if (tok.compareTo("addUser") == 0 && !userMode && !adminMode){

				// collecting all necessary info 
				System.out.println("Enter first name: "); 
				String firstName = input.nextLine(); 
				System.out.println("Enter last name"); 
				String lastName = input.nextLine(); 
				System.out.println("Enter email "); 
				String email = input.nextLine(); 
				// adding new user 
				User newUser =  new User(firstName, lastName, email); 
				// setting up current user 
				currentUser = newUser; 
				// updating hastable 
				topMenu.hashUsers.put(email.hashCode(), newUser); 
				System.out.println("__USERMODE__"); 
				userMode = true; 
			} 
			// addidea method in usermode 
			else if (tok.compareTo("addidea") == 0 && userMode){ 
				// prompts the user the to enter idea 
				System.out.print("enter your idea "); 
				String idea = input.nextLine(); 
				Idea newerIdea = userMenu.addIdea(currentUser, idea, topMenu.idNums, 0); 
				topMenu.heapIdeas.insert(0, newerIdea); 
				topMenu.idNums++; 
			}	
			// admin mode 
			else if (tok.compareTo("admin") == 0)
				// takes to admin 
				adminMode = true; 
			//candidate method implemented in admin mode 
			else if (tok.compareTo("candidate") == 0 && adminMode){ 
				System.out.println(adminMenu.candidate(topMenu.heapIdeas)); 
			}
			// quit 
			else if (tok.compareTo("quit") == 0){ 
				running = false; 
			}
			// sends the user back to topmode 
			else if(tok.compareTo("top") == 0){ 
				userMode = false; 
				adminMode = false; 
			} 
			// implements award method 
			else if(tok.compareTo("award") == 0 && adminMode){ 
				// getting rid of top idea from the heap 
				Idea removedIdea = adminMenu.award(topMenu.heapIdeas);
				
				User ideaPerson = topMenu.hashUsers.get(removedIdea.getEmail().hashCode()).getValue();
				//getting rid of idea from the user's list of ideas 
				ideaPerson.listOfIdeas().remove(removedIdea); 
				//System.out.println(topMenu.heapIdeas); 

				 
			} 
			// vote method 
			else if(tok.compareTo("vote") == 0 && userMode){
				System.out.print("Enter id ");  
				// assigning id and index of idea in heap 
				int id = Integer.parseInt(input.nextLine());
				int index = userMenu.vote(id, topMenu.heapIdeas); 
				Idea votedIdea = topMenu.heapIdeas.getHeap().get(index).getElement(); 
				// idea not available 
				if (index == -1){ 
					System.out.println("cannot find id"); 
				} 
				// idea already voted by the user 
				else if (votedIdea.checkVoters(currentUser.email())){ 
					System.out.println("you already voted for this for this idea"); 
				} 
				// voted successfully 
				else{ 
					votedIdea.addVoter(currentUser.email());
					topMenu.heapIdeas.upHeap(index); 
					topMenu.heapIdeas.getHeap().get(index).setKey(votedIdea.getRating()); 				
			} 
			}
			else if (tok.compareTo("awardedIdeas")== 0 && adminMode){ 
				System.out.println(adminMenu.awardedIdeas());
			} 
			else if (tok.compareTo("recentIdeas") == 0 && userMode){ 
				System.out.println(userMenu.recent().toString()); 
			} 
			else if(tok.compareTo("help") == 0){ 
				help = true; 
			} 	 
				
	 		// final check for invalid command 
 			else{
				System.out.println("invalid command"); 
			} 
		} 
	} 
}
