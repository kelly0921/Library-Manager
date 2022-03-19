/**
 * Main method to perform function based on user input and store changes to file
 * @author Kelly Chen
 * @version 0.1
 * CSE 017 Project 1
 * Date of creation: February 28, 2022
 * Last Date Modified: February 28, 2022
 */
package Project1;
import java.util.*;

public class LibraryManager {
	public static void main(String[] args)
	{
		Catalog myLibrary = new Catalog();
		
		//Prompt User Input
		Scanner scan = new Scanner(System.in);
		int input = 0;
		
		//Read in the text file
		myLibrary.readFile();
		
		//Operate until exit or error
		while(input != 9)
		{
			//Menu
			System.out.println("\nSelect an operation:");
			System.out.println("1. View all titles");
			System.out.println("2. Search by call number");
			System.out.println("3. Search by title");
			System.out.println("4. Search by year");
			System.out.println("5. Add new title");
			System.out.println("6. Remove title");
			System.out.println("7. Sort titles by year");
			System.out.println("8. View titles due for restoration");
			System.out.println("9. Exit");
			
			//take in user input
			if(scan.hasNextInt())
			{
				input = scan.nextInt();
			
				//check for user input and execute corresponding actions
				switch(input)
				{
					case 1: //Print all titles
						myLibrary.viewTitles();
						break;
					case 2: //Search By Call Number
						try 
						{
							System.out.println("Enter a Call Number:");
							System.out.println(myLibrary.searchByCallNumber(scan.next()));
						} 
						catch (InvalidDataException e)
						{
							System.out.println(e.getMessage());
						}
						break;
					case 3: //Search by Title
						System.out.println("Enter a Title:");
						scan.nextLine(); //buffer
						myLibrary.searchByTitle(scan.nextLine());
						break;
					case 4: //Search by Year
						try 
						{
							System.out.println("Enter a year:");
							if(scan.hasNextInt()) //Check if it's integer
								myLibrary.searchByYear(scan.nextInt());
							else
							{
								System.out.println("Must be a valid integer");
								scan.next();
								break;
							}
						} 
						catch (InvalidDataException e) //catch if it's invalid year
						{
							System.out.println(e.getMessage());
						}
						break;
					case 5: //Add Title
						System.out.println("Enter the title:");
						scan.nextLine(); //buffer
						String title = scan.nextLine();
						
						System.out.println("Enter the publisher:");
						String publisher = scan.nextLine();
						
						//Check and validate year
						int year = 0;
						try 
						{
							System.out.println("Enter the year of publication:");
							if(scan.hasNextInt()) //check if it's integer
							{
								year = scan.nextInt();
								myLibrary.checkYear(year);
							}
							else
							{
								System.out.println("Must be a valid integer");
								scan.next();
								break;
							}
						} 
						catch (InvalidDataException e) 
						{
							System.out.println(e.getMessage());
							break;
						}
						
						//Check and validate that copies is an integer
						System.out.println("Enter the number of copies:");
						int copies = 0;
						if(scan.hasNextInt())
						{
							copies = scan.nextInt();
						}
						else 
						{
							System.out.println("Must be an integer!");
							scan.next();
							break;
						}
						
						//Check that type can only be book or periodical
						String type = "";
						scan.nextLine();
						try
						{
							System.out.println("Enter the type of title (book/periodical):");
							type = scan.nextLine();
							myLibrary.checkType(type);
						}
						catch (InvalidDataException e) 
						{
							System.out.println(e.getMessage());
							break;
						}
						
						//Check and validate call number
						String callNumber = "";
						if(type.equalsIgnoreCase("book")) //Book
						{
							try
							{
								System.out.println("Enter the call number (B-ddd-ddd-ddd):");
								callNumber = scan.nextLine();
								myLibrary.checkBookCallNumber(callNumber);
							}
							catch (InvalidDataException e) 
							{
								System.out.println(e.getMessage());
								break;
							}
						}
						else //Periodical
						{
							try
							{
								System.out.println("Enter the call number (P-ddd-ddd-ddd):");
								callNumber = scan.nextLine();
								myLibrary.checkPeriodicalCallNumber(callNumber);
							}
							catch (InvalidDataException e) 
							{
								System.out.println(e.getMessage());
								break;
							}
						}
						
						//Depending on type, determine what other inputs are needed
						if(type.equalsIgnoreCase("book")) //Book
						{
							System.out.println("Enter the author:");
							String author = scan.nextLine();
							String ISBN = "";
							//Validate ISBN
							try 
							{
								System.out.println("Enter ISBN (10 digits):");
								ISBN = scan.nextLine();
								myLibrary.checkISBN(ISBN);
							} 
							catch (InvalidDataException e) 
							{
								System.out.println(e.getMessage());
								break;
							}
							myLibrary.addBook(callNumber, title, publisher, year, copies, author, ISBN);
							System.out.println("Title added successfully.");
						}
						else //periodical
						{
							int month = 0;
							scan.nextLine();
							//Validate periodical
							try 
							{
								System.out.println("Enter the month:");
								if(scan.hasNextInt())
								{
									month = scan.nextInt();
									myLibrary.checkMonth(month);
								}
								else
								{
									System.out.println("Must be a valid integer!");
									scan.next();
									break;
								}
							} 
							catch (InvalidDataException e) 
							{
								System.out.println(e.getMessage());
								break;
							}
							int issueNumber = 0;
							if(scan.hasNextInt())
							{
								System.out.println("Enter the issue number:");
								if(scan.hasNextInt())
								{
									issueNumber = scan.nextInt();
								}
							}
							else
							{
								System.out.println("Must be a valid interger!");
								scan.next();
								break;
							}
							myLibrary.addPeriodical(callNumber, title, publisher, year, copies, month, issueNumber);
							System.out.println("Title added successfully.");
						}
						break;
					case 6: //Remove
						try 
						{
							System.out.println("Enter the call number (B-ddd-ddd-ddd or P-ddd-ddd-ddd):");
							String check = scan.next();
							if(check.charAt(0) == 'B')
								myLibrary.checkBookCallNumber(check);
							else
								myLibrary.checkPeriodicalCallNumber(check);
							myLibrary.remove(check);
						} 
						catch (InvalidDataException e)
						{
							System.out.println(e.getMessage());
						}
		                break;
					case 7: //Sort by year
						myLibrary.sortByYear();
						myLibrary.viewTitles();
						break;
					case 8: //check and print all restorables
						System.out.println(myLibrary.restoration());
						break;
					case 9: //Write and save the file
						myLibrary.writeFile();
						System.out.println("Thank you for using my program. Bye!");
						System.exit(0);
					default: //wrong input
						System.out.println("Invalid operation. Try again.");
				}
			}
			else //Invalid input choices
			{
				System.out.println("Invalid operation. Try again.");
				scan.next();
			}
		}
	}
}
