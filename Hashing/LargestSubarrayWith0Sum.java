/*
    Find length of largest subarray with zero sum

    sum[i+1,j] = sum[0,j] - sum[0,i]
    if sum[i+1,j] = 0 
    then sum[0,j] = sum[0,i]

*/
 
import java.util.HashMap;

public class LargestSubarrayWith0Sum {   //O(n)
    public static void main(String[] args) {
        int arr[] = {15,-2,2,-8,1,7,10};
        HashMap<Integer,Integer> map = new HashMap<>();
        //(sum,idx)

        int sum = 0;
        int len = 0;

        for(int j=0;j<arr.length;j++){
            sum+=arr[j];
            if(map.containsKey(sum)){
                len = Math.max(len, j-map.get(sum));
            }
            else{
                map.put(sum, j);
            }
        }

        System.out.println(len);
    }
}
