package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import main.ConnectionGraph;
/**
 * 
 * @author Arpana
 * @version 1.0
 *
 */
public class ConnectionTable
{
	Set<String> setOfperson = new HashSet<String>();
	ConnectionGraph connectionGraph = new ConnectionGraph();
	/**
	 * Reads the input file using BufferedReader. Splits the input given into two variables(person).
	 * Adds these variable(person) to a Set and creates ConnectionGraph.
	 * ConnectionGraph is a class that extends HashMap. It maintains graph of connections between people.
	 * 
	 * @param filePath
	 * @throws Exception
	 */
	@SuppressWarnings({ "resource" })
	public ConnectionTable(String filePath) throws Exception
	{
		BufferedReader bufferedReader = null;
		try 
		{
			bufferedReader = new BufferedReader(new FileReader(filePath));
			String currentLine = bufferedReader.readLine();
			while(currentLine != null)
			{
				if(!currentLine.isEmpty())
				{
					
					String[] namePair = getNamesFromInputLine(currentLine);
					
					if(namePair == null || namePair.length != 2)
						throw new Exception("File consists incorrectly formated input lines.Expected - 'name:name'");
					
					String person1 = namePair[0];
					String person2 = namePair[1];
					
					if(!setOfperson.contains(person1))
					{
						setOfperson.add(person1);
						connectionGraph.put(person1, new HashSet<String>());
					}
					
					if(!setOfperson.contains(person2))
					{
						setOfperson.add(person2);
						connectionGraph.put(person2, new HashSet<String>());
					}
					
					connectionGraph.get(person1).add(person2);
					connectionGraph.get(person2).add(person1);
				}
				currentLine = bufferedReader.readLine();
				
			}
			bufferedReader.close();
			
		} 
		catch (FileNotFoundException e) 
		{
			if(bufferedReader != null)
				bufferedReader.close();
			throw new IOException("File was not found. Check the path specified in the input");
		}
	}


	public boolean isSrcPersonAndDestPersonInAcquaintances(String sourcePerson,String destinationPerson)
	{
		if(!setOfperson.contains(sourcePerson) || !setOfperson.contains(destinationPerson))
			return false;
		return true;
	}


	private String[] getNamesFromInputLine(String currentLine) 
	{
		String[] namePair = null;
		if(!currentLine.isEmpty())
		{
			namePair = currentLine.split(":");
		
		}
		return namePair;
	}

	/**
	 * Calls the method on ConnectionGraph to get shortest connection.
	 * 
	 * @param sourcePerson
	 * @param destinationPerson
	 * @return {@link ResultSeries}
	 */
	public HashMap<String,String> getshortestconnection(String sourcePerson, String destinationPerson)
	{
		HashMap<String,String> path = connectionGraph.getShortestPath(sourcePerson, destinationPerson);
		return path;
	}

}
