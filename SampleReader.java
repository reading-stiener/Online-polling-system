/**
 * COM212 Data Structure Final Project sample data reader example
 *
 * Adopt this example code to implement sample data reader for your project
 * You will need to build your own other classes to support required tasks.
 * You do not have to implement this in the same way (main method). It can be
 * one method of your own class. Just see the code snippet in main method here
 *
 * To test this example execute following commands
 *     javac SampleReader.java
 *     java SampleReader sampleData.txt
 *
 * by S. James Lee (25 April 2018)
 */

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;


public class SampleReader {


	public static void main(String[] argv)throws IOException{

		// we need to supply sample data filename as argument for main method
		String datafile = "SampleData.txt";
		if (argv.length < 1) {
			System.out.println("supply sample data filename!");
			System.out.println("will use a default name, SampleData.txt");
			//return;
		}
		else {
			datafile = argv[0];
		}

		Scanner in = new Scanner(new FileReader(datafile));
		String line = "";
		int rating = 0;
		String ideaDesc;
		String firstname, lastname, email;
    int idNums = 1;

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

        n.addIdeaRated(ideaDesc, idNums, rating);
        idNums++;

				// next idea
				line = in.nextLine();

			}

      System.out.println(n);

			System.out.println("===\n");

		}
	}
}
