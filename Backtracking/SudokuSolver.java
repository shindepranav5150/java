public class SudokuSolver {
    public static void main(String[] args) {
        int sudoku[][] = {{0,0,8,0,0,0,0,0,0},
                          {4,9,0,1,5,7,0,0,2},
                          {0,0,3,0,0,4,1,9,0},
                          {1,8,5,0,6,0,0,2,0},
                          {0,0,0,0,2,0,0,6,0},
                          {9,6,0,4,0,5,3,0,0},
                          {0,3,0,0,7,2,0,0,4},
                          {0,4,9,0,3,0,0,5,7},
                          {8,2,7,0,0,9,0,1,3}};

        if(solver(sudoku,0,0)){
            System.out.println("Solution exists");
            printBoard(sudoku);
        }
        else{
            System.out.println("Solution not exist");
        }
    }
    public static boolean solver(int sudoku[][],int row, int col){

        // base case
        if(row == 9 && col == 0)
            return true;

        // recursion 
        int nextRow = row, nextCol = col+1;
        if(col+1== 9){   // if all columns are filled
            nextCol = 0;
            nextRow = row+1;
        }

        if(sudoku[row][col] != 0){   // already element is present
            return solver(sudoku, nextRow, nextCol);
        }

        for(int digit=1;digit<=9;digit++){
            if(isSafe(sudoku, row, col,digit)){
                sudoku[row][col] = digit;
                if(solver(sudoku, nextRow, nextCol)){
                    return true;
                }
                sudoku[row][col] = 0;
            }
        }
        return false;
        
    }

    public static boolean isSafe(int sudoku[][],int row, int col,int digit){
        // in row
        for(int i=0;i<9;i++){
            if(sudoku[row][i] == digit)
                return false;
        }

        // in column
        for(int i=0;i<9;i++){
            if(sudoku[i][col] == digit)
                return false;
        }

        // in 3x3 grid
        int sr = (row/3)*3;  // starting row of grid
        int sc = (col/3)*3;  // starting col of grid

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(sudoku[sr+i][sc+j] == digit)
                return false;
            }
        }
        return true;
     }
    public static void printBoard(int sudoku[][]){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++)
                System.out.print(sudoku[i][j] + " ");
            System.out.println();
        }
    }
}
