package com.barakisbrown;


/***
 * DiceTypes will be which dice that the library and eventually the application will be allowed to generate.
 * They will cover the basics [D3/D4/D6/D8/D10/D12/D20/D100] that could be used in any type of roll playing game.
 * @author barakis
 *
 */
public class DiceTypes 
{
	private static final int []allowedDice = {3,4,6,8,10,12,20,100};
	
	public boolean isAllowed(int dice)
	{
		switch (dice)
		{
		case 3:
		case 4:
		case 6:
		case 8:
		case 10:
		case 12:
		case 20:
		case 100:
			return true;
		default:
			return false;
		}
	}
}
