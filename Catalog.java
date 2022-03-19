/**
 * Method to assists with Library Manager roles
 * @author Kelly Chen
 * @version 0.1
 * CSE 017 Project 1
 * Date of creation: February 28, 2022
 * Last Date Modified: March 1, 2022
 */

package Project1;
import java.io.*;
import java.util.*;

public class Catalog extends Titles
{
	//Data Members
	protected Titles[] titles = new Titles[50];
	protected int count = 0;
	
	/**
	 * Given a text file, read through file and update availability
	 */
	public void readFile()
	{
		try
		{
			File file = new File("titles.txt");
			Scanner sc = new Scanner(file);
			String callNumber, title, publisher, author,ISBN;
			int year, copies, month, issueNumber;
			char type;
			//Read the file when there are more to read
			while(sc.hasNextLine())
			{
				callNumber = sc.nextLine();
				type = callNumber.charAt(0);
				title = sc.nextLine();
				publisher = sc.nextLine();
				year = Integer.parseInt(sc.nextLine());
				copies = Integer.parseInt(sc.nextLine());
				
				if(type == 'B')
				{
					author = sc.nextLine();
					ISBN = sc.nextLine();
					titles[count] = new Book(callNumber, title, publisher, year, copies, author, ISBN);
					count++;
				}
				else if(type == 'P')
				{
					month = Integer.parseInt(sc.nextLine());
					issueNumber = Integer.parseInt(sc.nextLine());
					titles[count] = new Periodical(callNumber, title, publisher, year, copies, month, issueNumber);
					count++;
				}
				else
				{
					System.out.println("Invalid Type! Can only be Book(B) or Periodical(P).");
					System.exit(0);
				}
			}
			sc.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File not found.");
			//If file not found, initialize mediaList to empty values
		}
	}
	
	/**
	 * Print all the titles
	 */
	public void viewTitles()
	{
		System.out.printf("%-13s\t%-45s\t%-22s\t%-41s\n", "Call Number", "Title", "Publisher", "Year");
		for(int i = 0; i < count; i++)
		{
			System.out.println(titles[i].toString());
		}
	}
	
	/**
	 * Check for validate call number (Book)
	 * @param callNumber give to search
	 * @return whether the given matches the pattern
	 * @throws InvalidDataException
	 */
	public boolean checkBookCallNumber(String callNumber) throws InvalidDataException
	{
		if(callNumber.matches("B-\\d{3}-\\d{3}-\\d{3}"))
        {
			return true;
        }
        else
        {
        	 throw new InvalidDataException("Invalid Call Number for type book. Must be B-ddd-ddd-ddd");
        }
	}
	
	/**
	 * Check for variable call number (Periodical)
	 * @param callNumber given to search
	 * @return whether the given matches the pattern
	 * @throws InvalidDataException
	 */
	public boolean checkPeriodicalCallNumber(String callNumber) throws InvalidDataException
	{
		if(callNumber.matches("P-\\d{3}-\\d{3}-\\d{3}"))
        {
			return true;
        }
        else
        {
        	throw new InvalidDataException("Invalid Call Number for type periodical. Must be P-ddd-ddd-ddd");
        }
	}
	
	/**
	 * Check if it's an valid type
	 * @param type to check
	 * @return true if the type input is valid
	 * @throws InvalidDataException if the type input is invalid
	 */
	public boolean checkType(String type) throws InvalidDataException
	{
		if(type.equalsIgnoreCase("book") || type.equalsIgnoreCase("periodical"))
		{
			return true;
		}
		else
			throw new InvalidDataException("Invalid type of title. Must be a book or periodical.");
	}
	
	/**
	 * check if the ISBN is an valid input
	 * @param ISBN to check
	 * @return true if ISBN is valid
	 * @throws InvalidDataException if the ISBN is invalid
	 */
	public boolean checkISBN(String ISBN) throws InvalidDataException
	{
		if(ISBN.matches("[0-9]{10}"))
		{
			return true;
		}
		else
			throw new InvalidDataException("Invalid ISBN. Must be 10 digits.");
	}
	
	/**
	 * Check if the year is an valid input
	 * @param year to check
	 * @return true if the year is an valid year
	 * @throws InvalidDataException if year is invalid
	 */
	public boolean checkYear(int year) throws InvalidDataException
	{
		if(year >= 1900 && year <= 2022)
		{
			return true;
		}
		else
			throw new InvalidDataException("Invalid Year. Must be between 1900 and 2022.");
	}
	
	/**
	 * Check if the month input is an valid input
	 * @param month to check
	 * @return true if the input is valid
	 * @throws InvalidDataException if the input is not valid
	 */
	public boolean checkMonth(int month) throws InvalidDataException
	{
		if(month >= 1 && month <= 12)
		{
			return true;
		}
		else
			throw new InvalidDataException("Invalid Month. Must be between 1 and 12.");
	}
	
	/**
	 * Search for a title by call number
	 * @param callNumber to search
	 * @return the title found
	 * @throws InvalidDataException if an invalid input is encountered
	 */
	public String searchByCallNumber(String callNumber) throws InvalidDataException
	{
		if(callNumber.matches("[P|B]-\\d{3}-\\d{3}-\\d{3}"))
        {
			for(int i = 0; i < count; i++)
			{
				if(titles[i].getCallNumber().equalsIgnoreCase(callNumber))
				{
					return "Title found: \n" + titles[i].simpleString();
				}
			}
			return "Title not found.";
        }
        else
        {
        	 throw new InvalidDataException("Invalid Call Number. Must be B-ddd-ddd-ddd or P-ddd-ddd-ddd");
        }
	}
	
	/**
	 * Search for a title by title
	 * @param title to search
	 */
	public void searchByTitle(String title)
	{
		int counter = 0;
		Titles[] matches = new Titles[20];
		for(int i = 0; i < count; i++)
		{
			if(titles[i].getTitle().equalsIgnoreCase(title))
			{
				matches[counter] = titles[i];
				counter++;
			}
		}
		if(counter == 0)
			System.out.println("no titles found.");
		else
		{
			System.out.println("List of titles found:" + counter);
			System.out.printf("%-13s\t%-45s\t%-22s\t%-41s\n", "Call Number", "Title", "Publisher", "Year");
			for(int i = 0; i < counter; i++)
			{
				System.out.println(matches[i].toString());
			}
		}
	}
	
	/**
	 * Search for a title by year
	 * @param year to search
	 * @throws InvalidDataException if an invalid year is inputed
	 */
	public void searchByYear(int year) throws InvalidDataException
	{
		if(year >= 1900 && year <= 2022)
		{
			int counter = 0;
			Titles[] matches = new Titles[20];
			for(int i = 0; i < count; i++)
			{
				if(titles[i].getYear()==year)
				{
					matches[counter] = titles[i];
					counter++;
				}
			}
			if(counter == 0)
				System.out.println("no titles found.");
			else
			{
				System.out.println("List of titles found:" + counter);
				System.out.printf("%-13s\t%-45s\t%-22s\t%-41s\n", "Call Number", "Title", "Publisher", "Year");
				for(int i = 0; i < counter; i++)
				{
					System.out.println(matches[i].toString());
				}
			}
		}
		else
			throw new InvalidDataException("Invalid Year. Must be between 1900 and 2022.");
	}
	
	/**
	 * Add a book
	 * @param c call number to set
	 * @param t title to set
	 * @param p publisher to set
	 * @param y year to set
	 * @param copies to set
	 * @param a author to set
	 * @param i ISBN to set
	 */
	public void addBook(String c, String t, String p, int y, int copies, String a, String i)
	{
		titles[count] = new Book(c, t, p, y, copies, a, i);
		count++;
	}
	
	/**
	 * Add a periodical
	 * @param c call number to set
	 * @param t title to set
	 * @param p publisher to set
	 * @param y year to set
	 * @param copies to set
	 * @param m month to set
	 * @param i issue number to set
	 */
	public void addPeriodical(String c, String t, String p, int y, int copies, int m, int i)
	{
		titles[count] = new Periodical(c, t, p, y, copies, m, i);
		count++;
	}
	
	/**
	 * Sort the list by year using comparable
	 */
	public void sortByYear()
	{
		Arrays.sort(titles, 0, count);
	}
	
	/**
	 * Search and remove a title
	 * @param callNumber input of callNumber to remove
	 * @throws InvalidDataException if input is an invalid call number
	 */
	public void remove(String callNumber) throws InvalidDataException
	{
		int index = -1;
		for(int i = 0; i < count; i++)
		{
			if(titles[i].getCallNumber().equalsIgnoreCase(callNumber))
			{
				index = i;
			}
		}
		if(index == -1)
		{
			System.out.println("Title not found.");
		}
		else
		{
			 for(int i = index; i < count - 1; i++)
             {
                 titles[i] = titles[i+1];
             }
             count--;
             System.out.println("Title removed successfully.");
		}
	}
	
	/**
	 * Print out all restorable titles
	 * @return a string containing all restorable titles
	 */
	public String restoration()
	{
		String output = "";
		Titles[] restorable = new Titles[50];
		int index = 0;
		for(int i = 0; i < count; i++)
		{
			if(titles[i].isRestorable())
			{
				restorable[index] = titles[i];
				index++;
			}
		}
		output += "List of titles found: " + index;
		output += String.format("\n%-13s\t%-45s\t%-22s\t%-41s", "Call Number", "Title", "Publisher", "Year");
		for(int i = 0; i < index; i++)
		{
			output += "\n" + restorable[i].toString();
		}
		return output;
	}
	
	/**
	 * Write all updates to file (save)
	 */
	public void writeFile()
	{
		File file = new File("titles.txt");
        try
        {
            PrintWriter write = new PrintWriter(file);
            for (int i = 0; i < count; i++)
            {
            	write.println(titles[i].getCallNumber());
        		write.println(titles[i].getTitle());
        		write.println(titles[i].getPublisher());
        		write.println(titles[i].getYear());
        		write.println(titles[i].getCopies());
            	//write based on type
            	if(titles[i].getCallNumber().charAt(0)=='B')
            	{
            		Book temp = (Book)titles[i];
            		write.println(temp.getAuthor());
            		write.println(temp.getISBN());
            	}
            	else
            	{
            		Periodical temp = (Periodical)titles[i];
            		write.println(temp.getMonth());
            		write.println(temp.getIssueNumber());
            	}
            }
            write.close();
        }
        catch(FileNotFoundException e){
            System.out.println("Cannot write to file.");
        }   
	}
}
