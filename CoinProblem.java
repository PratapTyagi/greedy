import java.util.*;
import java.io.*;

public class CoinProblem {

	static void minCoins(int[] coins, int n, int v) {
		int t = v;
		ArrayList<Integer> al = new ArrayList<>();
		while(t != 0) {
			for(int i=n-1; i>=0; i--) {
				if(t / coins[i] != 0)	{
					int noOfTimes = t / coins[i];								t = t%coins[i];
					while(noOfTimes-- > 0)
						al.add(coins[i]);	
				}
			}
		}

		System.out.println("Coins: ");
		t=0;
		for(; t<al.size(); t++) 
			System.out.print(al.get(t)+" ");	
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] coins = { 1, 2, 5, 10, 20, 50, 100, 500, 1000 };

		System.out.println("Coins varients");
		for(int i: coins)
			System.out.print(i+" ");
		System.out.println();

		System.out.println("Enter value");
		int v = sc.nextInt();

		minCoins(coins, coins.length, v);		
	}

}