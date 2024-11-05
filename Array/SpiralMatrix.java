class SpiralMatrix {
    public static void printSpiralMatrix(int matrix[][]) {

        int startRow = 0;
        int endRow = matrix.length - 1;
        int startCol = 0;
        int endCol = matrix[0].length - 1;

        while (startRow <= endRow && startCol <= endCol) {

            // top
            for (int j = startCol; j <= endCol; j++) {

                System.out.print(matrix[startRow][j] + " ");
            }
            startRow++;

            // right
            for (int i = startRow; i <= endRow; i++) {
                System.out.print(matrix[i][endCol] + " ");
            }
            endCol--;

            // bottom
            for (int j = endCol; j >= startCol; j--) {
                if (startRow > endRow)
                    break;
                System.out.print(matrix[endRow][j] + " ");
            }
            endRow--;

            // left
            for (int i = endRow; i >= startRow; i--) {
                if (startCol > endCol)
                    break;
                System.out.print(matrix[i][startCol] + " ");
            }
            startCol++;
        }
    }

    public static void main(String args[]) {
        int cnt = 1;
        int n = 5;
        int m = 3;
        int arr[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = cnt++;
            }
        }

        printSpiralMatrix(arr);
    }
}