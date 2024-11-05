/*
We are given an infinite supply of denominaions[1,2,5,10,20,50,100,200,500]
Find min no. of coins/notes to make change for a value V

e.g.
V = 121
ans = 3(100+20+1)

V = 590
ans = 4(500+50+20+20)

*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class IndianCoins {
    public static void main(String[] args) {
        Integer coins[] = {1,2,5,10,20,50,100,200,500};

        Arrays.sort(coins,Comparator.reverseOrder());

        int countOfCoins = 0;
        int amount = 1059;
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i=0;i<coins.length;i++){
            while(coins[i]<=amount){
                countOfCoins++;
                ans.add(coins[i]);
                amount -= coins[i];
            }
        }

        System.out.println("Total Coins: " + countOfCoins);
        System.out.println(ans);
    }
}
