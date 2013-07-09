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
			try 
			{
				((Die) obj).rollDie();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Die Value = " + ((Die)obj).getvalue());
			
		}
		if (obj1 instanceof ExplodedDie)
		{
			try
			{
				((ExplodedDie) obj1).setExplodeTN(6);
				((ExplodedDie) obj1).rollDie();
			}catch (Exception e)
			{
				e.printStackTrace();
			}
			boolean explode = ((ExplodedDie) obj1).didExplode();
			System.out.println("Die Value = " + ((ExplodedDie) obj1).getvalue());
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
				obj = new ExplodedDie(2,6);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return obj;
	}
}
