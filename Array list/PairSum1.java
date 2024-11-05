/*
    Pair Sum
    find any pair in a sorted array has a target sum
 */

import java.util.ArrayList;

public class PairSum1 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        int target = 5;
        pairSum(list,target);
    }

    public static void pairSum(ArrayList<Integer> list, int target){
        int left = 0;
        int right = list.size()-1;

        while(left<right){
            int temp = list.get(left)+list.get(right);

            if(temp == target){
                System.out.println("(" + list.get(left) + "," + list.get(right) + ")");
                return;
            }
            else if(temp<target){
                left++;
            }
            else{
                right--;
            }

        }

        System.out.println("Pair cannot exists");
    }
}
