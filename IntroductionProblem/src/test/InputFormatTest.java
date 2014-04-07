package test;

import static org.junit.Assert.*;
import main.EntryMain;

import org.junit.Test;
/**
 * 
 * @author Arpana
 * @version 1.0
 *
 */
public class InputFormatTest 
{

	String[] args = {"input.txt", "robert", "jimmy"};
	EntryMain entryMain = new EntryMain();
	
	@Test
	public void ensureArgumentsNotNullOrEmpty()
	{
		assertEquals(false, entryMain.isArgumentsNullOrEmpty(args));
		
	}
	
	@Test
	public void shouldContain3Arguments()
	{
		assertEquals(true, entryMain.containsThreeArguments(args));
		
	}
	
	@Test
	public void shouldEnsureFirstArgumentIsValidTextFile()
	{
		assertEquals(true, entryMain.isFirstArgumentValidTextFile(args));
	}
	

}
