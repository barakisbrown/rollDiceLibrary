using System;


namespace RollDiceLibrary
{
	public class RollDice
	{
		public static int roll(DiceUtilities.Dice_Types D)
		{
			switch (D)
			{
				case DiceUtilities.Dice_Types.D2:
				case DiceUtilities.Dice_Types.D3:
				case DiceUtilities.Dice_Types.D4:
				case DiceUtilities.Dice_Types.D6:
				case DiceUtilities.Dice_Types.D8:
				case DiceUtilities.Dice_Types.D10:
				case DiceUtilities.Dice_Types.D12:
				case DiceUtilities.Dice_Types.D20:
				case DiceUtilities.Dice_Types.D100:
					{
						break;
					}
					default:
						throw new ArgumentException("D is not allowed DiceType. Please check type");
			}
			var rand = new Random();
			var rolled = (int)D + 1;
			var n = rand.Next(1, rolled);
			Console.WriteLine("Rolled {0}", n);
			return n;
		}
	}
}
