/*
    always start form 
    case 1: right top cell which is(0,m-1)
    in which 
    cell value > key 
        move left side
    cell value < key
        move bottom side


    case 2 : left bottom cell which is (n-1,0)

     cell value > key
        move top side
    
    cell value < key
        move right side


    this algorithm also known as "Staircase search"

    time complexity : O(n+m)
*/

class SearchInSortedMatrix{
    public static void main(String args[]){

        int arr[][] = {{10,20,30,40},
                       {15,25,35,45},
                       {27,29,37,49},
                       {32,33,39,50}};
        int key = 3;
        stairCaseSearch1(arr,key);
    }

    // case 1
    public static Boolean stairCaseSearch(int arr[][],int key){

        int row = 0;
        int col = arr[0].length-1;

        while(row<arr.length && col >= 0){
            if(arr[row][col] == key){
                System.out.println("Key found at ("+ row + " , "+ col +")");
                return true;
            }

            else if(arr[row][col] < key){
                row++;
            }
            else{
                col--;
            }
        }

        System.out.println("Key not found!");
        return false;
    }

    // case 2

    public static Boolean stairCaseSearch1(int arr[][],int key){
        int row = arr.length-1;
        int col = 0;

        while(row>=0 && col < arr[0].length){
            if(arr[row][col] == key)
            {
                System.out.println("Key found at (" + row + "," + col + ")");
                return true;
            }
            else if(arr[row][col] < key)
                col++;
            else
                row--;
        }

        System.out.println("Key not found");
        return false;
    }
}