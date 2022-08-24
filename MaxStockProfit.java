package Coding_Challenges;

import java.util.ArrayList;
import java.util.Scanner;

public class MaxStockProfit {
    static int[] getSortedArray(int n, int[] profits) {
        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (profits[i] < profits[j]) {
                    temp = profits[i];
                    profits[i] = profits[j];
                    profits[j] = temp;
                }
            }
        }
        return profits;
    }

    static int getMaxProfit(int n, int k, int[] profits) {
        int maxProfit = 0;
        int profitStock[] = getSortedArray(n, profits);
        for (int i = 0; i < k; i++) {
            if (profitStock[i] > 0)
                maxProfit += profitStock[i];
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        ArrayList<Integer> stockProfit = new ArrayList<Integer>();
        int profitValue = 0;
        Scanner sc = new Scanner(System.in);
        while (profitValue != -100) {
            profitValue = sc.nextInt();
            stockProfit.add(profitValue);
            stockProfit.remove(-100);
        }
        int[] profits = stockProfit.stream().mapToInt(i -> i).toArray();
        int k = sc.nextInt();
        System.out.println(getMaxProfit(profits.length, k, profits));
    }
}