package leetcode.dp;

import java.util.Collections;

public class BestRimeStockIII {
	public static int maxProfit(int[] prices, int start, int end){
		int maxProfit = 0;
		int minPrices = Integer.MAX_VALUE;
		for(int i =start;i<end;i++){
			minPrices = Math.min(minPrices, prices[i]);
			maxProfit = Math.max(maxProfit, prices[i]-minPrices);
		}
		
		return maxProfit;
	}
	
	public static int maxProfit(int[] prices){
		int n = prices.length;
		int maxProfit = 0;
		for(int i=0;i<n;i++){
			maxProfit = Math.max(maxProfit, maxProfit(prices,0,i)+maxProfit(prices,i,n));
		}
		return maxProfit;
	}
	
	public static int maxProfitII(int[] prices){
		int n = prices.length;
		int[] leftProfits = new int[n];
		int minPrice = prices[0];
		
		for(int i=1;i<n;i++){
			
			leftProfits[i] = Math.max(leftProfits[i-1], prices[i]-minPrice);
			minPrice = Math.min(minPrice, prices[i]);
			
		}
		
		int maxPrice = prices[n-1];
		int maxVal = 0;
		for(int i=n-2;i>=0;i--){
			maxPrice = Math.max(maxPrice, prices[i]);
			maxVal = Math.max(maxVal, maxPrice-prices[i]+leftProfits[i]);
		}
		
		return maxVal;
	}
	
	public static void main(String[] args) {
		int[] prices = {12,43,545,534,2,3,2,34};
		System.out.println(maxProfitII(prices));
	}
}
