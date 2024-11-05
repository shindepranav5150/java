
public class MergeSort {
    public static void main(String[] args) {
        int arr [] = {2,1,4,6,2};
        mergeSort(arr, 0, arr.length-1);
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]+" ");
        }
    }

    public static void mergeSort(int arr[],int start, int end){
        int mid = start+(end-start)/2;
        
        if(start>=end)
        return;
        mergeSort(arr,start,mid);
        mergeSort(arr, mid+1, end);

        merge(arr,start,end,mid);
    }

    public static void merge(int arr[],int start,int end,int mid){
        int temp [] = new int[end-start+1];

        int i = start;
        int j = mid+1;
        int k = 0;

        while(i<=mid && j<=end){
            if(arr[i]<arr[j])
            {
                temp[k++]=arr[i++];
            }
            else{
                temp[k++]=arr[j++];
            }
        }

        while(i<=mid){
            temp[k++]=arr[i++];
        }
        while(j<=end){
            temp[k++]=arr[j++];
        }

        for(k=0,i=start;k<temp.length;k++,i++){
            arr[i]=temp[k];
        }
    }
}
