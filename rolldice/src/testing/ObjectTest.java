package testing;

import com.barakisbrown.rolldice.Die;
import com.barakisbrown.rolldice.ExplodedDie;

public class ObjectTest 
{
	public static void main(String []args)
	{
		Object obj = null, obj1 = null;
		obj  = assignObject(true);
		obj1 = assignObject(false);
		
		// now lets see if I can now work with them this way
		if (obj instanceof Die)
		{
			Die normal = (Die)obj;
			try 
			{
				normal.rollDie();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Die Value = " + normal.getvalue());
			
		}
		if (obj1 instanceof ExplodedDie)
		{
			ExplodedDie exp = (ExplodedDie)obj1;
			try
			{
				exp.setExplodeTN(6);
				exp.rollDie();
			}catch (Exception e)
			{
				e.printStackTrace();
			}
			boolean explode = exp.didExplode();
			System.out.println("Die Value = " + exp.getvalue());
			System.out.println("Did the die explode? " + explode);
		}
	}
	
	public static Object assignObject(boolean isExplodable)
	{
		Object obj = null;
		if (isExplodable == true)
		{
			try 
			{
				obj = new Die(2,6);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			try 
			{
				obj = new ExplodedDie(2,6,6);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return obj;
	}
}
