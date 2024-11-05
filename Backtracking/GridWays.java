/*
 * Find number of ways to reach from (0,0) to (n-1,m-1) in a nXm Grid.
 * Allowed moves  - right or down
 */

public class GridWays {
    public static void main(String[] args) {
        // System.out.println(possibleWays(2,2, 0, 0));
        System.out.println(optimalSol(3, 3));
    }

    // exponential complexity 2^(n+m)
    public static int possibleWays(int n,int m ,int i, int j){
        if(i==n-1 && j == m-1){    // present at target position
            return 1;
        }
        else if(i==n || j == m){   // Boundary cross condition
            return 0;
        }
        

        return possibleWays(n,m, i+1, j) + possibleWays(n,m, i, j+1);    
    }

    //optimal solution by maths
    /*
        each path has n-1 down turns  m-1 right turns
        which means that we have 
        n-1    D -char
        m-1    R -char
        arrange the all character
        so each possible combination is the path
        possible ways = (n-1+m-1)!/((n-1)! * (m-1)!)
     */

    public static int optimalSol(int n, int m){
        int ans = fact(n-1+m-1)/(fact(n-1)*fact(m-1));

        return ans;
    }

    public static int fact(int n){
        int ans = 1;
        for(int i=1;i<=n;i++){
            ans *=i;
        }
        return ans;
    }
}
