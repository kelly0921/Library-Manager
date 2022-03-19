package Project1;

public abstract class Titles implements Comparable<Titles> {
	protected String titles[];
	
	//Data Members
	protected String callNumber;
	protected String title;
	protected String publisher;
	protected int year;
	protected int copies;
	
	//Constructors
	/**
	 * Default constructor
	 */
	public Titles()
	{
		callNumber = "";
		title = "";
		publisher = "";
		year = 0;
		copies = 0;
	}
	
	/**
	 * Constructor with parameters(call number, title, publisher, year, and copies)
	 * @param c value for data member call number
	 * @param t value for data member title
	 * @param p value for data member publisher
	 * @param y value for data member publish year
	 * @param copies value for data member copies
	 */
	public Titles(String c, String t, String p, int y, int copies)
	{
		callNumber = c;
		title = t;
		publisher = p;
		year = y;
		this.copies = copies;
	}
	
	//Getter Methods
	/**
	 * Getter for the call number of a title
	 * @return value of data member callNumber
	 */
	public String getCallNumber()
	{
		return callNumber;
	}
	
	/**
	 * Getter for the title of a title
	 * @return value of data member title
	 */
	public String getTitle()
	{
		return title;
	}
	
	/**
	 * Getter for the publisher of a title
	 * @return value of data member publisher
	 */
	public String getPublisher()
	{
		return publisher;
	}
	
	/**
	 * Getter for the year of a title
	 * @return value of data member year
	 */
	public int getYear()
	{
		return year;
	}
	
	/**
	 * Getter for the copies of a title
	 * @return value of data member copies
	 */
	public int getCopies()
	{
		return copies;
	}
	
	//Setter Methods
	/**
	 * Setter for the call number of a title
	 * @param c to set the data member callNumber
	 */
	public void setCallNumber(String c)
	{
		callNumber = c;
	}
	
	/**
	 * Setter for the title of a title
	 * @param t to set the data member title
	 */
	public void setTitle(String t)
	{
		title = t;
	}
	
	/**
	 * Setter for the publisher of a title
	 * @param p to set the data member publisher
	 */
	public void setPublisher(String p)
	{
		publisher = p;
	}
	
	/**
	 * Setter for the year of a title
	 * @param year to set the data member year
	 */
	public void setYear(int year)
	{
		this.year = year;
	}
	
	/**
	 * Setter for the copies of a title
	 * @param c to set the data member copies
	 */
	public void setCopies(int c)
	{
		copies = c;
	}
	
	/**
	 * Check if a title is restorable
	 * If a title is more than 20 years old, it's restorable
	 * @return whether the title is restorable or not
	 */
	public boolean isRestorable()
	{
		if(this.getYear() < 2002) //more than 20 years
			return true;
		return false;
	}
	
	/**
	 * Method to get the Title information
	 * @return formatted string containing the value of the data members
	 */
	public String toString()
	{
		return String.format("%-13s\t%-45s\t%-22s\t%4d", callNumber, title, publisher, year);
	}
	
	/**
	 * Method to get the Title information
	 * @return formatted string with each data member on its own line
	 */
	public String simpleString()
	{
		String output = "Call Number: " + callNumber;
		output += "\nTitle: " + title;
		output += "\nPublisher: " + publisher;
		output += "\nYear: " + year;
		output += "\nCopies: " + copies;
		return output;
	}
	
	/**
	 * Compare method to help sorting based by year
	 * @param t given object to compare with
	 * @return the difference between current title and given title
	 */
	public int compareTo(Titles t)
	{
		return this.getYear() - t.getYear();
	}
}
