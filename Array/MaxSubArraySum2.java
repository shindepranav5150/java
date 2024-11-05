/*

Kadane's Algorithm:

if currSum<0 then make currSum =0;
currSum = currSum + arr[currIndex]

Tmie complexity : O(n)
*/


class MaxSubArraySum2{

    public static int kadanes(int arr[]){
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;

        boolean flag = true; // all no. are negative
        for(int i=0;i<arr.length;i++){
            if(arr[i]>=0)
            {
                flag = false;
                break;
            }
        }

        //if all the no. are negative
        if(flag){
            for(int i=0;i<arr.length;i++){
                maxSum = Math.max(maxSum,arr[i]);
            }
            return maxSum;
        }


        for(int i=0;i<arr.length;i++){
            currSum+=arr[i];
            if(currSum<0)
            currSum = 0;

            maxSum = Math.max(currSum,maxSum);
        }
        return maxSum;
    }
    public static void main(String args[]){
        int arr[] = {-2,1,-3,4,-1,2,1,-5,4};

        System.out.println(kadanes(arr));
    }
}