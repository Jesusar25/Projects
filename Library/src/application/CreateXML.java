package application;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;

import javax.xml.bind.JAXB;



public class CreateXML {
	
	public static void main(String[] args) {
		   // open clients.xml, write objects to it then close file
			BufferedWriter output = null ;
			Scanner input = null;
		   try {
			  output = Files.newBufferedWriter(Paths.get("library.xml"));
		      input = new Scanner(System.in);

		      // stores the Accounts before XML serialization
		      Library mylibrary = new Library(); 

		      System.out.printf("%s%n%s%n? ", 
		         "Enter title, author, year.",
		         "Enter end-of-file indicator to end input.");

		      while (input.hasNext()) { // loop until end-of-file indicator
		         try {
		            // create new record
		            Book record = new Book(input.nextLine(),input.nextLine(), input.nextInt());

		            // add to AccountList
		            mylibrary.getBooks().add(record);
		            input.nextLine();
		         } 
		         catch (NoSuchElementException elementException) {
		            System.err.println("Invalid input. Please try again.");
		            input.nextLine(); // discard input so user can try again
		         } 

		         System.out.print("? ");
		      }

		      // write AccountList's XML to output
		      JAXB.marshal(mylibrary, output);
		      
		   }
		   catch (IOException ioException) {
		      System.err.println("Error opening file. Terminating.");
		   } 
		   finally {
			   try {
				   output.close();
			   }	 
			   catch (IOException ioException) {
				   System.err.println(ioException.getMessage());
			   }
			      input.close();
		   }
		} 
	} 


