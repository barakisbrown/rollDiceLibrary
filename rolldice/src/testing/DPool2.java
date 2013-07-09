package testing;

import java.util.ArrayList;
import com.barakisbrown.rolldice.Die;
import com.barakisbrown.rolldice.ExplodedDie;


public class DPool2 
{
	private int totalRolled;
	private int numDiceInPool;
	private int timesPoolRolled;
	private String diceString;
	
	private ArrayList<Object> pool;
	private boolean Init = false;
	private static DPool2 obj = null;
	
	
	protected DPool2()
	{
		totalRolled = 0;
		numDiceInPool = timesPoolRolled = 0;
		diceString = "";
		Init = true;
		pool = new ArrayList<Object>();
	}
	
	public static DPool2 initPool()
	{
		if (obj == null)
		{
			obj = new DPool2();	
		}
		return obj;
	}
	
	public boolean isInit() { return Init; }
	
	public int getTotalRolled() { return totalRolled; }
	public int getNumdiceInPool() { return numDiceInPool; }
	public int getTimesRolled() { return timesPoolRolled; }
	public String getDiceString() { return diceString; }
	
	public boolean addDice(Object objDie)
	{
		return false;
	}
	
	public void generate()
	{
		
	}
	
}
