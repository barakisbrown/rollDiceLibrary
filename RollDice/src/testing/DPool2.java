package testing;

import java.util.ArrayList;
import java.util.Iterator;
import library.*;


public class DPool2 
{
	private int totalRolled;
	private int numDiceInPool;
	private int timesPoolRolled;
	private String diceString;
	private StringBuilder output;
	
	private ArrayList<Object> pool;
	private boolean Init = false;
	private static DPool2 obj = null;
	
	
	protected DPool2()
	{
		totalRolled = 0;
		numDiceInPool = timesPoolRolled = 0;
		diceString = "";
		Init = true;
		output = new StringBuilder();
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
	public String getOutput() { return output.toString(); }
	
	public boolean addDice(Object objDie)
	{
		numDiceInPool++;
		return pool.add(objDie);
	}
	
	public boolean addDice(int times,Object objDie)
	{
		boolean rtnValue = false;
		numDiceInPool += times;
		for (int loop = 0;loop < times; loop++)
		{
			rtnValue = pool.add(objDie);
		}
		return rtnValue;
	}
	
	public Iterator<Object> getPool()
	{
		return pool.iterator();
	}

	
	public void generate()
	{
		int value;
		for (Object obj : pool)
		{
			if (obj instanceof ExplodedDie)
			{
				ExplodedDie explode = (ExplodedDie)obj;
				boolean repeat = false;
				try
				{
					explode.rollDie();
					value = explode.getvalue();
					totalRolled += value;
					output.append(value).append(" ");
					// only if does explode is true
					if (explode.didExplode())
					{
						do
						{
							int side = explode.getSide();
							int TN = side;
							numDiceInPool++;
							ExplodedDie die = new ExplodedDie(1,side,TN);
							die.rollDie();
							repeat = die.didExplode();
							value = die.getvalue();
							totalRolled += value;
							output.append(value).append(" ");
						}while(repeat);
					}
					
				}
				catch(Exception e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
				
			}
			else if (obj instanceof Die)
			{
				Die simple = (Die)obj;
				try
				{
					simple.rollDie();
					value = simple.getvalue();
					totalRolled += value;
					output.append(simple).append(" ");
				}
				catch(Exception e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		timesPoolRolled++;
	}
	
}
