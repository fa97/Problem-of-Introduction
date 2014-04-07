package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import main.Acquaintance;
import main.ResultSeries;

import org.junit.Test;
/**
 * 
 * @author Arpana
 * @version 1.0
 *
 */
public class ProgramResultTest
{
	
	@Test
	public void shouldReturnMinusOneWhenEitherNotPresent()
	{
		String[] args = {"input.txt", "robert", "jimmy"};
		Acquaintance acquaintance = new Acquaintance(args);
		ResultSeries result;
		try 
		{
			result = acquaintance.callSmallestSetOfIntroduction();
			assertEquals("-1", result.getSmallestSeries().toString());
		
		} 
		catch (Exception e) 
		{
			fail("Exception");
		}
				
	}
	
	@Test
	public void shouldReturnZeroIfBothAcquainted()
	{
		String[] args = {"input.txt", "robert", "cora"};
		Acquaintance acquaintance = new Acquaintance(args);
		ResultSeries result;
		try 
		{
			result = acquaintance.callSmallestSetOfIntroduction();
			assertEquals("0", result.getSmallestSeries().toString());
		
		} 
		catch (Exception e) 
		{
			fail("Exception");
		}
	}
	
	@Test
	public void testForSmallestSetOfIntrouction()
	{
		String[] args = {"input.txt", "robert", "billy"};
		Acquaintance acquaintance = new Acquaintance(args);
		ResultSeries result;
		try 
		{
			result = acquaintance.callSmallestSetOfIntroduction();
			assertEquals("3", result.getSmallestSeries().toString());
		
		} 
		catch (Exception e) 
		{
			fail("Exception");
		}
	}
	
}
