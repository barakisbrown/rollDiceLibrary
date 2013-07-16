package testing;

import java.util.ArrayList;

import com.barakisbrown.rolldice.Die;
import com.barakisbrown.rolldice.ExplodedDie;

/***
 * Test with a 2D8 + 1D6
 * @author barakis
 *
 */
public class ArrayTest 
{
	private int total = 0;
	private ArrayList<Object> list = null;
	private StringBuilder diceList;
	
	public ArrayTest()
	{
		total = 0;
		list = new ArrayList<Object>();
		diceList = new StringBuilder();
		
	}
	
	public void addDie(Object single)
	{
		list.add(single);
	}
	
	public int getTotal() { return total; }
	public String getOutput() { return diceList.toString(); }
	
	public void generate()
	{
		int value;
		for (Object obj : list)
		{
			if (obj instanceof ExplodedDie)
			{
				ExplodedDie explode = (ExplodedDie)obj;
				try
				{
					explode.rollDie();
					value = explode.getvalue();
					total += value;
					diceList.append(value).append(" ");
					if (explode.didExplode() == true)
					{
						ExplodedDie newDice = new ExplodedDie(1,6,6);
						newDice.rollDie();
						value = newDice.getvalue();
						total += value;
						diceList.append(value).append(" ");
					}
					
				}
				catch (Exception e)
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
					total += value;
					diceList.append(value).append(" ");
				} 
				catch (Exception e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
	}
	
	public static void main(String []args)
	{
		System.out.println("Test 1 .. Rolling 2D8 + 1D6[non exploding]");
		ArrayTest.Test1();
		System.out.println("Test 2 .. Rollnig 2D8[Exploding]");
		ArrayTest.Test2();
		System.out.println("Test 3 .. Rolling 2D8[Exploding] + 1D4[Non]");
		ArrayTest.Test3();
	}
	
	public static void Test1()
	{
		ArrayTest T1 = new ArrayTest();
		try
		{
			// non exploding dice to see if I just add different value of dice
			T1.addDie(new Die(1,8));
			T1.addDie(new Die(1,8));
			T1.addDie(new Die(1,6));
			T1.generate();
			System.out.println("2D8 + 1D6 = " + T1.getTotal());
			System.out.println("Output of dice rolled : " + T1.getOutput());
		}
		catch(Exception e)
		{
			System.err.println("Error:" + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static void Test2()
	{
		ArrayTest T2 = new ArrayTest();
		try
		{
			T2.addDie(new ExplodedDie(1,8,8));
			T2.addDie(new ExplodedDie(1,8,8));
			T2.generate();
			System.out.println("2D8 = " + T2.getTotal());
			System.out.println("Output of dice rolled : " + T2.getOutput());
		}
		catch(Exception e)
		{
			System.err.println("Error:" + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static void Test3()
	{
		ArrayTest T3 = new ArrayTest();
		try
		{
			T3.addDie(new ExplodedDie(1,8,8));
			T3.addDie(new ExplodedDie(1,8,8));
			T3.addDie(new Die(1,4));
			T3.generate();
			System.out.println("2D8+1D4 = " + T3.getTotal());
			System.out.println("Output of dice rolled : " + T3.getOutput());
		}
		catch(Exception e)
		{
			System.err.println("Error:" + e.getMessage());
			e.printStackTrace();
		}
		
		
		
	}
	
}
