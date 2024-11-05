import java.util.Comparator;
import java.util.Arrays;

public class FractionalKnapsack {
    public static void main(String[] args) {
        int weight [] = {10,20,30};
        int value [] = {60,100,120};
        int W = 50;

        //find value/weight ratio

        double ratio[][] = new double[value.length][2];
        // 0 --> idx   1--> ratio

        for(int i=0;i<value.length;i++){
            ratio[i][0] = i;
            ratio[i][1] = value[i]/(double)weight[i];
        }

        //sort the array on basic of ratio
        Arrays.sort(ratio,Comparator.comparingDouble(o -> o[1]));

        int capacity = W;
        int finalVal = 0;
        for(int i=ratio.length-1; i>=0 ;i--){
            int idx = (int)ratio[i][0];
            if(capacity>=weight[idx]){
                //include full item
                finalVal += value[idx];
                capacity -= weight[idx];
            }
            else{
                //include fractional item
                finalVal += (ratio[i][1] * capacity);
                capacity = 0;
                break;
            }
        }

        System.out.println(finalVal);
        
    }
}
