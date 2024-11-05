/*
    Given an array of intgers heights repesenting the histogram bar height where the width of each bar is 1,
    return the area of the largest rectangle in histogram
 */

import java.util.Stack;

public class MaxAreaInHistogram {
    public static void main(String[] args) {
        int height[] = {2,1,5,6,2,3};
        System.out.println(findArea(height));
    }

    public static int findArea(int height[]){
        int nsl[] = new int[height.length];   // next smaller left
        int nsr[] = new int[height.length];   // next smaller right
        
        nextSmallerLeft(height, nsl);
        nextSmallerRight(height, nsr);
        
        int maxArea = 0;

        for(int i=0;i<height.length;i++){
            
            int width = nsr[i]-nsl[i]-1;
            int currArea = height[i]*width;
            maxArea = Math.max(maxArea, currArea);
        }

        return maxArea;
    }

    public static void nextSmallerLeft(int height[],int nsl[]){
        Stack<Integer> s = new Stack<>();

        for(int i=0;i<height.length;i++){
            while(!s.empty() && height[i]<=height[s.peek()]){
                s.pop();
            }
            if(s.empty()){
                nsl[i] = -1;
            }
            else{
                nsl[i] = s.peek();
            }
            s.push(i);
        }
    }

    public static void nextSmallerRight(int height[], int nsr[]){
        Stack<Integer> s = new Stack<>();

        for(int i=height.length-1;i>=0;i--){
            while(!s.empty() && height[i]<=height[s.peek()]){
                s.pop();
            }
            if(s.empty()){
                nsr[i] = height.length;
            }
            else{
                nsr[i] = s.peek();
            }
            s.push(i);
        }
    }

}
