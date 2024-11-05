public class QuickSort {
    public static void main(String[] args) {
        int arr [] = {6,3,9,8,2,5};
        quickSort(arr,0,arr.length-1);
        for(int j=0;j<arr.length;j++){
            System.out.print(arr[j]+" ");
        }
    }

    public static int partition(int arr[],int start,int end){
        int pivot = arr[end];
        int i = start-1;    // used to swap smaller element than pivot
        for(int j=start;j<end;j++){
           if(arr[j]<pivot){
            i++;
            //swap
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            }
            
            //swap
            int temp = arr[i+1];
            arr[i+1] = arr[end];
            arr[end] = temp;
        }
        return i+1;
    }
    public static void quickSort(int arr[],int start,int end){
        if(start<end)
        {
        int p = partition(arr, start, end);

        quickSort(arr, start, p-1);
        quickSort(arr, p+1, end);
        }
    }
}
