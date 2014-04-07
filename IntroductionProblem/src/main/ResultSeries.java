package main;

/**
 * 
 * @author Arpana
 * @version 1.0
 *
 */
public class ResultSeries 
{
	private Integer smallestSeries;
	private String seriesPath;
	
	public ResultSeries(Integer smallestSeries, String seriesPath)
	{
		super();
		this.smallestSeries = smallestSeries;
		this.seriesPath = seriesPath;
	}
	
	public Integer getSmallestSeries() {
		return smallestSeries;
	}

	public String getSeriesPath() {
		return seriesPath;
	}
	
}
