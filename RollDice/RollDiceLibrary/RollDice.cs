using System;


namespace RollDiceLibrary
{
	public class RollDice
	{
        /// <summary>
        /// Rolls D 1 time. 
        /// Ex: 1D4[If D is a D4]
        /// </summary>
        /// <returns>The roll [1 to D]</returns>
        /// <param name="D">Enum D .. Dice from D2 to D100</param>
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

        /// <summary>
        /// Roll DiceType D amount times 
        /// Ex: If D is D4 and Amount is 5, then roll 5D4
        /// </summary>
        /// <returns>The roll of D amount times.</returns>
        /// <param name="amount">Amount of times to rolled</param>
        /// <param name="D">Enum DiceType [D2 to D100]</param>
	    public static int Roll(int amount, DiceUtilities.Dice_Types D)
	    {
	        if (amount < 1)
                throw new ArgumentException("Amount must be greater than or equal to 1.");
	        else
	        {
	            var total = 0;
	            for (var Loop = 0; Loop < amount; Loop++)
	                total += Roll(D);
	            return total;
	        }
	    }

		/// <summary>
		/// Roll DiceType D amount times 
		/// Ex: If D is D4 and Amount is 5, then roll 5D4
        /// If Results is not empty, it will then store the results in there
        /// in case the user wants to see what were rolled or display them somehow
		/// </summary>
		/// <returns>The roll amount times .. ex 5D4</returns>
		/// <param name="amount">Amount of dice to be rolled</param>
		/// <param name="D">Enum DiceType [D2 to D100]</param>
		/// <param name="Results">Results [Array of DiceRoll]</param>
		public static int Roll(int amount, DiceUtilities.Dice_Types D, out int []Results)
        {
            // Destroy results so that I can use them to store the whats been rolled
            Results = new int[amount];

            // Check to make sure amount is not less than 1
            if (amount < 1)
                throw new ArgumentException("Amount must be greater than or equal to 1.");
            else
            {
                var total = 0;
                for (var loop = 0; loop < amount;loop++)
                {
                    var roll = Roll(D);
                    total += roll;
                    Results[loop] = roll;
                }

                // return the total rolled plus the results in the argument
                return total;
            }
        }
	}
}
