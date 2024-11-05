/*
find the maximum profit in the stocks by buying at one day and sell at one day
if there is no profit then return 0 {5,4,3,2,1}
*/


class BuyAndSellStock{
    public static void main(String arg[]){
        int prices [] = {7,1,5,3,6,4};

        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int prices[]){
        int buyPrice = Integer.MAX_VALUE;
        int profit = 0;

        for(int i=0;i<prices.length;i++){
            if(buyPrice<prices[i]){
                profit  = Math.max(profit,(prices[i]-buyPrice));
            }
            else{
                buyPrice = prices[i];
            }
        }

        return profit;

    }
}