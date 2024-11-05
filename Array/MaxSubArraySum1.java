// Find the maximum Subarray Sum
/*
 Prefix Array -> sum of all element from start to curr index
 CurrSum = prefix[end] - prefix[start-1]


 e.g.  arr =        {-1,3,-2,4,-2,5}
       prefix arr = {-1,2, 0,4, 2,7}
    
 Time complexity O(n^2)
*/


class MaxSubArraySum1{
    public static int maxSum(int arr[]){
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int prefix[] = new int[arr.length];
        prefix[0]=arr[0];
        for(int i=1;i<arr.length;i++){
            prefix[i] = prefix[i-1]+arr[i];
        }

        for(int i=0;i<arr.length;i++){
            for(int j=i;j<arr.length;j++)
            {
                currSum = i==0?prefix[j]:prefix[j]-prefix[i-1];
                if(currSum>maxSum){
                    maxSum = currSum;
                } 
            }
        }
        return maxSum;
    }

    public static void main(String args[]){
        int arr[] = {-1,3,-2,4,-2,5};

        System.out.println(maxSum(arr));
    }
}