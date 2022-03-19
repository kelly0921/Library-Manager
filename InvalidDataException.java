/**
 * Define InvalidDataException
 * @author Kelly Chen
 * @version 0.1
 * CSE 017 Project 1
 * Date of creation: February 28, 2022
 * Last Date Modified: February 28, 2022
 */
package Project1;

public class InvalidDataException extends Exception{
	/**
	 * Exception constructor
	 */
	public InvalidDataException()
	{
		super("Invalid Data.");
	}
	
	/**
	 * Constructor when given specific message to display
	 * @param message to output when exception is thrown
	 */
	public InvalidDataException(String message)
	{
		super(message);
	}
}
