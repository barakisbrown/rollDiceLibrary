package com.barakisbrown.rolldice;

public class ExplodedDie extends Die 
{
	private boolean exploded;
	private int explode_target_number;

	public ExplodedDie(int value, int side,int TN) throws Exception 
	{
		super(value, side);
		// TODO Auto-generated constructor stub
		exploded = false;
		explode_target_number = TN;
	}

	public void setExplodeTN(int targetNumber)
	{
		if ((targetNumber < 1) || (targetNumber > getSide()))
				return;
		else
			explode_target_number = targetNumber;
	}
	
	public boolean didExplode()
	{
		return exploded;
	}
	
	public void rollDie() throws Exception
	{
		super.rollDie();
		
		if (explode_target_number == 0)
			throw new Exception("Exploded not defined");
		else
		{
			int value = getvalue();
			if (value == explode_target_number)
				exploded = true;
		}
		
	}
	
}

