public class N_QueensPrloblem {
    static int count = 0;
    public static void main(String[] args) {
        int n = 4;

        char board[][] = new char[n][n];

        for(int i=0;i<n;i++){
            for(int col=0;col<n;col++){
                board[i][col] = 'x';
            }
        }
        
        allSolutions(board,0);
        System.out.println("Total ways : " + count);

        if(singleSolution(board, 0)){
            System.out.println("Solution is poosible");
            printBoard(board);
        }else{
            System.out.println("solution not possible");
        }
    }

    public static void printBoard(char board[][]){
        System.out.println("---------------Chess Board---------------");
        int n = board.length;
        for(int i=0;i<n;i++){
            for(int col=0;col<n;col++){
                System.out.print(board[i][col]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean isSafe(char board[][], int row, int col){

        // vertically up
        for(int i=row-1;i>=0;i--){
            if(board[i][col] == 'Q')
            return false;
        }

        // left diagonal up
        for(int i=row-1, j=col-1;i>=0 && j>=0;i--,j--){
            if(board[i][j] == 'Q')
            return false;
        }
        //right diagonal up
        for(int i=row-1,j=col+1;i>=0 && j<board.length;i--,j++){
            if(board[i][j]=='Q')
            return false;
        }

        return true;
    }

    public static void allSolutions(char board[][],int row){
        if(row == board.length)
        {
            count++;
            printBoard(board);
            return;
        }

        for(int col=0;col<board.length;col++){
            if(isSafe(board, row, col))
            {
                board[row][col] = 'Q';
                allSolutions(board, row+1);
                board[row][col] = 'x';
            }
        }
    }

    public static boolean singleSolution(char board[][],int row){
        if(row == board.length)
        {
            return true;
        }

        for(int col=0;col<board.length;col++){

            if(isSafe(board, row, col))
            {
                board[row][col] = 'Q';
                if(singleSolution(board, row+1)){
                    return true;
                }
                board[row][col] = 'x';
            }
        }
        return false;
    }

}
