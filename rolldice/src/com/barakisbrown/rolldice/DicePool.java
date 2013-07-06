package com.barakisbrown.rolldice;

import java.util.ArrayList;
import java.util.Iterator;

public class DicePool 
{
	private ArrayList<Die> pool;
	private int numDice;
	private int total;
	private int timesRolled;
	private String diceString;
	
	public DicePool()
	{
		pool = new ArrayList<Die>();
		numDice = 1;
		total = 0;
	}
	
	public DicePool(int number,int sides)
	{
		numDice = number;
		pool = new ArrayList<Die>();
		diceString = number + "D" + sides;
		total = 0;
		
		try
		{
			for (int loop = 0;loop < numDice;loop++)
			{
				pool.add(new Die(1,sides));			
			}
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
		}
	}
	
	public void addDice(int number,int sides)
	{
		try
		{
			Die newDie = new Die(1,sides);
			pool.add(newDie);
			
		}catch(Exception e)
		{
			System.err.println(e.getMessage());
		}

		if (numDice != 1)
			numDice++;

	}
	
	public void generate()
	{
		for (Die dice : pool)
		{
			try {
				dice.rollDie();
			} catch (Exception e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			total += dice.getvalue();
		}
		timesRolled++;
	}
	
	public int getTotal()
	{
		if (timesRolled == 0)
			return 0;
		else
			return total;
	}
	
	public Iterator<Die> getDice()
	{
		return pool.iterator();
	}
	
	public String getDiceString()
	{
		return diceString;
	}
}
