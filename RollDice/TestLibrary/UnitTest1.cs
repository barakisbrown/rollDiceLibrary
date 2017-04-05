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
		public void Test1(int actual,DiceUtilities.Dice_Types rolled)
		{
		    var n = RollDice.Roll(rolled);
		    Assert.InRange(n, 1, (int) rolled);
		}

        [Theory]
        [InlineData(6,DiceUtilities.Dice_Types.D6)]
        [InlineData(4, DiceUtilities.Dice_Types.D8)]
        [InlineData(10, DiceUtilities.Dice_Types.D10)]
        [InlineData(0,DiceUtilities.Dice_Types.D4)]
        public void AddMultipliDiceTogether(int number, DiceUtilities.Dice_Types whichTypes)
        {
            var min = (number == 0) ? 1 : number;
            var max = number * (int) whichTypes;
            var rolled = RollDice.Roll(number, whichTypes);
            Assert.InRange(rolled, min, max);
        }
    }
}
