package medium;
/*
 * You are given coins of different denominations and a total amount of money.
 * Write a function to compute the number of combinations that make up that amount. 
 */
public class NoOfCombinationsCoin {

	public static void main(String[] args) {
		int[] coins = {1,2,5};
		int amount = 5;
		System.out.println("Number of combinations for amount "+amount );
		System.out.println(nOfCombinationsForAmount(coins,amount));

	}
	public static int nOfCombinationsForAmount(int[] coins, int amount) {
		if(amount< 1)
			return 1;
		int[] combinations = new int[amount+1];
		combinations[0] = 1;
		//since we need to get combinations for a given total for each coin we have coin in the 
		// outer loop and inner loop as amount
		for(int coin : coins) {
			for(int i = 1; i<=amount; i++) {
				if(i >= coin)
					combinations[i] += combinations [i - coin];
			}
		}
		return combinations[amount];
	}
}
