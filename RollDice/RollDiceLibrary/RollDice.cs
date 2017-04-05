using System;


namespace RollDiceLibrary
{
	public class RollDice
	{
		public static int Roll(DiceUtilities.Dice_Types D)
		{
			switch (D)
			{
                case DiceUtilities.Dice_Types.None:
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
			return n;
		}

	    public static int Roll(int amount, DiceUtilities.Dice_Types D)
	    {
	        if (amount < 1)
                throw new ArgumentException("Amount must be greater than or equal to 1. Can not roll 0 Dice");
	        else
	        {
	            var total = 0;
	            for (var Loop = 0; Loop < amount; Loop++)
	                total += Roll(D);
	            return total;
	        }
	    }
	}
}
