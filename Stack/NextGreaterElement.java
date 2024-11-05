/*
    next greater element of some elemnt x is first greater element that is to right of x 

    arr = [6,8,0,1,3]
    next greater = [8,-1,1,3,-1]
 */

import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
        int arr[] = {6,8,0,1,3};
        int nextGreater [] = new int[arr.length];

        findNextGreater(arr,nextGreater);

        for(int i=0;i<nextGreater.length;i++){
            System.out.print(nextGreater[i] + " ");
        }
    }


    // Time complexity O(n)
    public static void findNextGreater(int arr[], int nextGreater[]){
        Stack<Integer> s = new Stack<>();
        for(int i = arr.length-1; i>=0; i--){
            while (!s.isEmpty() && arr[s.peek()] <= arr[i]) {
                s.pop();
            }

            if(s.isEmpty()){
                nextGreater[i] = -1;    // no greater element is present
            }
            else{
                nextGreater[i] = arr[s.peek()];
            }

            s.push(i);
        }
    }
}
