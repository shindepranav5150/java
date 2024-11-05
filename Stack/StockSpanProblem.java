/*
    find the span for all given n days

    span - span of given day is  maximum no. of consecutive days just before the given day, for which 
    price of stock on current day is less than or equal to its price on given day

    [100, 80, 60, 70, 60, 75, 85]
    span  = [1,1,1,2,1,4,6]
 */

import java.util.Stack;

public class StockSpanProblem {
    public static void main(String[] args) {
        int stocks[] = {100, 80, 60, 70, 60, 75, 85};
        int span [] = new int[stocks.length];
        stockspan(stocks,span);
        for(int i=0;i<span.length;i++){
            System.out.print(span[i] + " ");
        }
    }

    public static void stockspan(int stocks[], int span[]){
        Stack<Integer> s = new Stack<>();
        span[0] = 1;    // span for 1st day is 1
        s.push(0);

        for(int i=1; i<span.length;i++){
            int currPrice = stocks[i];
            while(!s.empty() && currPrice > stocks[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                span[i] = i+1;
            }
            else{
                int prevHigh = s.peek();
                span[i] = i-prevHigh;
            }

            s.push(i);
        }
    }    
}
