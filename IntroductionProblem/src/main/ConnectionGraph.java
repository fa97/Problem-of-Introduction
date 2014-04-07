package main;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 
 * @author Arpana
 * @version 1.0
 *
 */
public class ConnectionGraph extends HashMap<String, Set<String>>
{
	private static final long serialVersionUID = 1L;
	
	Queue<String> queue = null;
	HashSet<String> visited = new HashSet<String>();
	HashMap<String,String> path = new HashMap<String,String>();
	
	/**
	 * Implements a variation of BFS to get the shortest path of introduction between two people.
	 * This methods uses the graph as HashMap already created(extends HashMap).
	 * It starts from the source person and adds all his connection not already visited to queue.
	 * It also keeps track of the order of visit as HashMap path(person introduced -> introduced by).
	 * If there is no connection between the two return null.
	 * 
	 * @param sourcePerson
	 * @param destinationPerson
	 * @return HashMap<String, String> path
	 */
	public HashMap<String, String> getShortestPath(String sourcePerson, String destinationPerson) 
	{
		queue = new LinkedList<String>();
		Set<String> connections = get(sourcePerson);
		
		visited.add(sourcePerson);
		for (String connectedPerson : connections) 
		{
			queue.add(connectedPerson);
			path.put(connectedPerson, sourcePerson);
			visited.add(connectedPerson);
		}
		
		while(!queue.isEmpty())
		{
			String person = queue.remove();
			
			if(person.equals(destinationPerson))
			{
				return path;
			}
			else
			{
				for (String connectedPerson : get(person)) 
				{
					
					if(!visited.contains(connectedPerson))
					{
						queue.add(connectedPerson);
						visited.add(person);
						path.put(connectedPerson, person);
					}
				}
			}
			
		}
		
		return null;
	}
	
}
