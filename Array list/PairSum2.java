/*
    Pair Sum - 2
    find any pair in a sorted and Rotated array has a target sum
 */


import java.util.ArrayList;

public class PairSum2 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);

        int target = 16;
        pairSum2(list,target);
    }

    public static void pairSum2(ArrayList<Integer> list, int target){

        // find the index where the array is rotated
        int bp = -1;  // breaking point
        
        for(int i=0;i<list.size()-1;i++){
            if(list.get(i)>list.get(i+1)){
                bp = i;
                break;
            }
        }
        int left = bp+1;
        int right = bp;

        int n = list.size();
        while(left!=right){
            int temp = list.get(left)+list.get(right);

            if(temp == target){
                System.out.println("(" + list.get(left) + "," + list.get(right) + ")");
                return;
            }
            else if(temp<target){
                left = (left+1)%n;
            }
            else{
                right = (n+right-1)%n;
            }
        }
        System.out.println("Pair cannot exists");
    }
}
