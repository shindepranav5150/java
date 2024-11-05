// sum of element on both diagonal of nXn matrix

class DiagonalSum{
    public static void main(String args[]){
        int n = 3;
        int cnt=0;
        int arr[][] = new int [n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++){
                arr[i][j] = cnt++;
            }
        }

        System.out.print(diagonalSum(arr));
    }

    public static int diagonalSum(int arr[][]){
        int n = arr.length;
        int result = 0;

        for(int i=0;i<n;i++){
            // primary diagonal
            result+=arr[i][i];
            
            //secondary diagonal
            if(i != n-1-i)       // for overlapping condition in odd length matrix
                result +=arr[i][n-1-i];
        }

        return result;
    }
}