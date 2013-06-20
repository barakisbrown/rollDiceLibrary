package com.barakisbrown.rolldice;

import java.util.ArrayList;

public class DicePool 
{
	private ArrayList<Die> pool;
	private int numDice;
	
	public DicePool()
	{
		pool = new ArrayList<Die>();
		numDice = 1;
	}
	
	public DicePool(int number,int sides)
	{
		numDice = number;
		pool = new ArrayList<Die>();
		
		try
		{
			for (int loop = 0;loop < numDice;loop++)
			{
				pool.add(new Die(number,sides));			
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
			
			pool.add(new Die(number,sides));
			
		}catch(Exception e)
		{
			System.err.println(e.getMessage());
		}
	}
	
	public void generate()
	{

		for (Die dice : pool)
		{
			dice.rollDie();
		}
			
	}
	
}
