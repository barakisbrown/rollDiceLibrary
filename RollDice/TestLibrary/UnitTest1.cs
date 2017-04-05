using System;
using Xunit;
using RollDiceLibrary;

namespace TestLibrary
{
    public class UnitTest1
    {
		[Theory]
		[InlineData(4,DiceUtilities.Dice_Types.D4)]
		[InlineData(12,DiceUtilities.Dice_Types.D12)]
		[InlineData(15,DiceUtilities.Dice_Types.D20)]
		[InlineData(22,DiceUtilities.Dice_Types.D100)]
		[InlineData(2,DiceUtilities.Dice_Types.D3)]
		[InlineData(1,DiceUtilities.Dice_Types.D2)]
		[InlineData(10,25)]
		public void Test1(int actual,DiceUtilities.Dice_Types rolled)
        {
			Assert.InRange(actual, 1, (int)rolled);
        }
    }
}
