/*
    Given an intger array size n, find all elements that appear more than (n/3) times
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class MajorityElement {
    public static void main(String[] args) {
        int nums[] = {1,3};
        HashMap<Integer,Integer> hm = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            // if(hm.containsKey(nums[i])){
            //     hm.put(nums[i],hm.get(nums[i])+1);
            // }
            // else{
            //     hm.put(nums[i], 1);
            // }

            hm.put(nums[i],hm.getOrDefault(nums[i], 0)+1); 
            //getOrDefault -> if key present in map then return its value else it return default value (in Our case default value is 0)
        }

        int n = nums.length/3;
        Set<Integer> keys = hm.keySet();
        ArrayList<Integer> result = new ArrayList<>();
        for (Integer key : keys) {
            if(hm.get(key) > n){
                result.add(key);
            }
        }

        for(int i=0;i<result.size();i++){
            System.out.print(result.get(i)+" ");
        }
    }
}
