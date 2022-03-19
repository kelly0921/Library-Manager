/**
 * Define properties of book
 * @author Kelly Chen
 * @version 0.1
 * CSE 017 Project 1
 * Date of creation: February 28, 2022
 * Last Date Modified: March 1, 2022
 */
package Project1;

public class Book extends Titles{
	//Data Member
	protected String author;
	protected String ISBN;
	
	/**
	 * Default constructor
	 */
	public Book()
	{
		super();
	}
	
	/**
	 * Constructor with given inputs
	 * @param c call number to set
	 * @param t title to set
	 * @param p publisher to set
	 * @param y year to set
	 * @param copies to set
	 * @param a author to set
	 * @param i ISBN to set
	 */
	public Book(String c, String t, String p, int y, int copies, String a, String i)
	{
		super(c, t, p, y, copies);
		author = a;
		ISBN = i;
	}
	
	//Getter Methods
	/**
	 * Getter for data member author
	 * @return data member author
	 */
	public String getAuthor()
	{
		return author;
	}
	
	/**
	 * Getter for data member ISBN
	 * @return data member ISBN
	 */
	public String getISBN()
	{
		return ISBN;
	}
	
	//Setter Methods
	/**
	 * Setter for data member author
	 * @param a author to set
	 */
	public void setAuthor(String a)
	{
		author = a;
	}
	
	/**
	 * Setter for data member ISBN
	 * @param ISBN to set
	 */
	public void setISBN(String ISBN)
	{
		this.ISBN = ISBN;
	}
	
	/**
	 * Method to get the Book information
	 * @return formatted string containing the value of the data members
	 */
	@Override
	public String toString()
	{
		return super.toString();
	}
	
	/**
	 * Method to get the Book information
	 * @return formatted string with each data member on its own line
	 */
	@Override
	public String simpleString()
	{
		return super.simpleString() + "\nAuthor: " + author + "\nISBN: " + ISBN;
	}
}
