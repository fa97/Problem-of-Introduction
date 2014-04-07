package main;

import main.Acquaintance;

/**
 * 
 * @author Arpana
 * @version 1.0
 *
 */
public class EntryMain 
{
	public static String illegalArgumentMsg = "Accepts 3 arguments - '<fileName.txt>,<Name of Person X>,<Name of Person Y>'";
	
	/**
	 * Problem - Given a set of people, two people X and Y out of that set who wish to
	 * speak to each other, and a list of pairs of people who are acquainted (i.e. have already been formally introduced), 
	 * find the smallest set of people required to perform the (series of) introductions necessary to
	 * allow X and Y to speak to each other.
	 * 
	 * Runs as: <PROGRAM> <INPUT.TXT> <X> <Y>
	 * The first argument is a plain text file of acquaintance relationships in the format:
	 * NAME:NAME
	 * NAME:NAME
	 * .........
	 * 
	 * @param args - Expects 3 arguments of the form '<fileName.txt>,<Name of Person X>,<Name of Person Y>'
	 * @throws Exception
	 */
	public static void main(String args[]) throws Exception
	{
		new EntryMain(args);
	}
	
	/**
	 * 
	 * @param args
	 * Constructor for EntryMain class. This checks the validity of input arguments before passing it over to Acquaintance class.
	 * Sets the Acquaintance class with arguments and calls the function to get the smallest set of introduction necessary.
	 * Prints the results - then number of smallest set of people and the path connecting them.
	 * 
	 */
	public EntryMain(String[] args)
	{
		if(isArgumentsNullOrEmpty(args))
			throw new IllegalArgumentException(illegalArgumentMsg);
		
		if(!containsThreeArguments(args))
			throw new IllegalArgumentException(illegalArgumentMsg);
		
		if(!isOtherTwoArgumentValid(args))
			throw new IllegalArgumentException("The last two arguments are empty.Input valid names");

		if(!isFirstArgumentValidTextFile(args))
			throw new IllegalArgumentException("Filepath is either empty or is not a '.txt' format file");
		
		Acquaintance acquaintance = new Acquaintance(args);
		ResultSeries result;
		
		try 
		{
			result = acquaintance.callSmallestSetOfIntroduction();
			System.out.println("Smallest number of other people to perform introductions: " + result.getSmallestSeries());
			System.out.println("Series of People: " + result.getSeriesPath());
		
		} 
		catch (Exception e) 
		{
			System.out.println("Something went wrong : " + e.getMessage());
		}
		
	}

	public EntryMain() 
	{
	}


	public Boolean isArgumentsNullOrEmpty(String[] args) 
	{
		if(args != null && args.length > 0)
			return false;
		return true;
	}

	public Boolean containsThreeArguments(String[] args) 
	{
		if(args.length == 3)
			return true;
		return false;
	}

	/**
	 * 
	 * @param args
	 * Checks the filename argument is a path to txt file.
	 * @return true or false;
	 */
	public Boolean isFirstArgumentValidTextFile(String[] args) 
	{
		
		if(args[0] ==null && args[0].isEmpty())
			return false;
		
		try
		{
			String fileExt = args[0].split("\\.")[1];
			if(!fileExt.equals("txt"))
				return false;
		}
		catch(Exception e)
		{
			return false;
		}
		
		return true;
	}
	
	private boolean isOtherTwoArgumentValid(String[] args) 
	{
		if(args[1] ==null && args[2] ==null && !args[1].isEmpty() && !args[2].isEmpty())
			return false;
		return true;
	}
}
