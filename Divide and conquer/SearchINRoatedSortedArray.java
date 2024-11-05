public class SearchINRoatedSortedArray {
    public static void main(String args[]){
        int arr[] = {4,5,6,7,1,2,3};
        int target = -1;
        System.out.println(search(arr,target,0,arr.length-1));
    }

    // Time complexity O(log n)
    public static int search(int arr[],int target, int si, int ei){
        
        if(si>ei)
        return -1;
        int mid = si+(ei-si)/2;

        if(arr[mid]==target)
        return mid;

        //mid on Line l1
        if(arr[si]<=arr[mid]){
            // search left
            if(arr[si]<=target && target <= arr[mid]){
                return search(arr, target, si, mid);
            }
            // search right
            else{
                return search(arr, target, mid+1, ei);
            }
        }
        
        //mid on line 2
        else{
            // search right
            if(arr[mid]<=target && target <= arr[ei]){
                return search(arr, target, mid, ei);
            }
            // serach left
            else{
                return search(arr, target, si, mid-1);
            }
        }
    }
}
