package testing;


import java.util.Iterator;

import com.barakisbrown.rolldice.DicePool;
import com.barakisbrown.rolldice.Die;

public class DiceTest 
{
	private DicePool testPool;
	private int sides = 10;
	private int times = 100;
	private double total = 0.0;
	private double avgrolled = 0.0;
	
	public DiceTest()
	{
		testPool = new DicePool(times,sides);
		testPool.generate();
		total = (double)testPool.getTotal();
		avgrolled = total / 10.0;
	}

	public void displayResults()
	{
		Die single;
		int []numberPool = new int[10];
		
		System.out.println("Test Begin");
		System.out.println("I am doing a dice test which I will see how well the random generator is working.");
		System.out.println("DiceString I am using : " + testPool.getDiceString());
		System.out.println("---------------------------------------------------------------------------------");
		Iterator<Die> itor = testPool.getDice();
		
		while (itor.hasNext())
		{
			single = itor.next();
			numberPool[single.getvalue() - 1]++;
			itor.remove();
		}
		
		for (int loop=0;loop<10;loop++)
			System.out.println(loop + 1 + "'s rolled = " + numberPool[loop]);
		
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("Average Rolled = " + avgrolled);
		System.out.println("Test Ending");
		
	}
	
	public static void main(String []args)
	{
		DiceTest test = new DiceTest();
		test.displayResults();
	}
	
}
