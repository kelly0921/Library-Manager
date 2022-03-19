/**
 * Define properties of periodical
 * @author Kelly Chen
 * @version 0.1
 * CSE 017 Project 1
 * Date of creation: February 28, 2022
 * Last Date Modified: March 1, 2022
 */

package Project1;

public class Periodical extends Titles {
	//Data Members
	protected int month;
	protected int issueNumber;
	
	/**
	 * Default constructor
	 */
	public Periodical()
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
	 * @param m month to set
	 * @param i issue number to set
	 */
	public Periodical(String c, String t, String p, int y, int copies, int m, int i)
	{
		super(c, t, p, y, copies);
		month = m;
		issueNumber = i;
	}
	
	//Getter Methods
	/**
	 * Getter for data member month
	 * @return data member month
	 */
	public int getMonth()
	{
		return month;
	}
	
	/**
	 * Getter for data member issueNumber
	 * @return data for issue number
	 */
	public int getIssueNumber()
	{
		return issueNumber;
	}
	
	//Setter Methods
	/**
	 * Setter for data member month
	 * @param m given month to set
	 */
	public void setMonth(int m)
	{
		month = m;
	}
	
	/**
	 * Setter for data member issueNumber
	 * @param i given issue number to set
	 */
	public void setIssueNumber(int i)
	{
		issueNumber = i;
	}
	
	/**
	 * Method to get the Periodical information
	 * @return formatted string containing the value of the data members
	 */
	@Override
	public String toString()
	{
		return super.toString();
	}
	
	/**
	 * Method to get the Periodical information
	 * @return formatted string with each data member on its own line
	 */
	@Override
	public String simpleString()
	{
		return super.simpleString() + "\nMonth: " + month + "\nIssue Number: " + issueNumber;
	}
}
