package main;

import java.util.HashMap;
import java.util.Stack;
import main.ResultSeries;
import main.ConnectionTable;
/**
 * 
 * @author Arpana
 * @version 1.0
 *
 */
public class Acquaintance 
{
	private String filePath;
	private String sourcePerson;
	private String destinationPerson;
	
	public String getFilePath()
	{
		return filePath;
	}

	public String getSourcePerson() 
	{
		return sourcePerson;
	}

	public String getDestinationPerson() 
	{
		return destinationPerson;
	}
	
	public Acquaintance(String[] args) 
	{
		filePath = args[0];
		sourcePerson = args[1];
		destinationPerson = args[2];
			
	}

	/**
	 * Creates a connection table and calls the method to print the result as number of connection and path.
	 * @return {@link ResultSeries}
	 * @throws Exception
	 */
	public ResultSeries callSmallestSetOfIntroduction() throws Exception 
	{
		ConnectionTable connectionTable = new ConnectionTable(filePath);
		ResultSeries result = smallestSetOfIntrocuction(connectionTable);
		return result;
		
	}

	/**
	 * Checks if the two person is present in the list. If they are the method proceeds to get the shortest connection between the two.
	 * It receives the HashMap of path, it then gets builds the result set by counting the connections and building the path.
	 * 
	 * @param connectionTable
	 * @return {@link ResultSeries}
	 */
	private ResultSeries smallestSetOfIntrocuction(ConnectionTable connectionTable) 
	{
		ResultSeries result;
		if(!connectionTable.isSrcPersonAndDestPersonInAcquaintances(sourcePerson, destinationPerson))
		{
			result = new ResultSeries(-1, "Either of the two people is not present in the list of acquaintances");
			return result;
		}
		
		HashMap<String,String> path = connectionTable.getshortestconnection(sourcePerson, destinationPerson);
		
		if(path == null)
		{
			result = new ResultSeries(-1, "There does not exist set of people who could introduce " + sourcePerson + " and " + destinationPerson);
			return result;
		}
		
		Integer connectionCount = 0;
		Stack<String> series = new Stack<String>();
		String person = path.get(destinationPerson);
		series.add(destinationPerson);
		series.add(person);
		while(!person.equals(sourcePerson))
		{
			connectionCount++;
			person = path.get(person);
			series.add(person);
		}
		
		StringBuilder seriesPath = new StringBuilder(series.pop());
		
		while(!series.isEmpty())
		{
			seriesPath.append( "->" + series.pop());
		}
		
		result = new ResultSeries(connectionCount, seriesPath.toString());
		return result;
	}

}
