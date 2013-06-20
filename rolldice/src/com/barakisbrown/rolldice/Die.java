package com.barakisbrown.rolldice;



public class Die 
{
	private int i_sides;
	private int i_value;

	
	public Die(int side,int value) throws Exception
	{
		if (DiceTypes.isAllowed(side) == false)
			throw new Exception("Invalid Dice Type");
		else
		{
			i_sides = side;
			if (value >= 1 && value <= side)
				i_value = value;
			else
				throw new Exception("Invalid Value. Must be between 1 and side");
		}	
	}

	public int getSide() 
	{
		return i_sides;
	}

	public int getvalue() 
	{
		return i_value;
	}
	
	public void setSide(int side) throws Exception
	{
		if (DiceTypes.isAllowed(i_sides) == false)
			throw new Exception("Invalid Dice Type");
		else
			i_sides = side;
	}

	public void setvalue(int value) throws Exception 
	{
		if (value >= 1 && value <= i_sides)
			i_value = value;
		else
			throw new Exception("Invalid Value. Must be between 1 and side");
	}
	
	public String getDie()
	{
		return "D" + i_sides;
	}
	
}
