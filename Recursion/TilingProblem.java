/*
 * floor size 2xn
   tile size 2x1
 */

class TilingProblem{
    public static void main(String[] args) {
        int n = 4;
        System.out.println(countTiles(n));
    }

    public static int countTiles(int n){

        if(n==0 || n==1)
            return 1;
        return countTiles(n-1) + countTiles(n-2);
                // vertical       horizontal
    }
}