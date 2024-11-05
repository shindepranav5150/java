class FastExponent{
    public static void main(String args[]){
        System.out.println(fastExpo(5,3)); // 5^3
    }


    // time complexity : O(log n)  --> n is no. bit in power
    public static int fastExpo(int a, int n){
        int ans = 1;

        while(n>0){
            if((n&1) != 0){// check LSB
                ans = ans * a;
            }
            a=a*a;
            n=n>>1;
        }

        return ans;
    }
}