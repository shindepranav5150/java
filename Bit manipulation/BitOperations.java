class BitOperations{
    public static void main(String args[]){

        System.out.println(getBit(14,2));

        System.out.println(setBit(10,1));

        System.out.println(clearBit(10,1));

        System.out.println(clearLastBits(15,2));

        System.out.println(clearRangeOfBit(10,2,4));
    }

    // find ith bit
    public static int getBit(int n, int i){
        int bitMask = 1 << i;
        if((n & bitMask) == 0){
            return 0;
        }
        else{
            return 1;
        }
    }

    // set the ith bit with value 1
    public static int setBit(int n, int i){
        int bitMask = 1<<i;

        return n | bitMask;
    }

    // make ith bit 0
    public static int clearBit(int n, int i){
        int bitMask = ~(1<<i);

        return n&bitMask;
    }

    // Update the ith bit according to given condition
    public static int updateBit(int n, int i, int newBit){

        // if (newBit == 0){
        //     return clearBit(n,i);
        // }
        // else{
        //     return set(n,i);
        // }

        n = clearBit(n,i);
        int bitMask = newBit << i;

        return n|bitMask;
    }

    // clear last i bits
    // 1111 i=2      ----> 1100

    // ~0 == -1  == 111111111 (in binary)
    public static int clearLastBits(int n,int i){

        int bitMask = (~0)<<i;
        return n&bitMask;
    }

    // clear range of bits 
    // e.g. n = 101101011  i=2 j=5  --> make 2,3,4,5 bit equal to zero(0)
    //          ans --> 101000011

    /*
        all last i bits are 1 -->  (i<<1)-1
        first j bits are 1    -->  (~0)<<j

        algo:
            bitmask = a|b
            a = all starting bits from j+1 are 1
            b = last i bits are 1

            b = 11000000
            a = 00000011
            bitmask = 11000011

    */

    public static int clearRangeOfBit(int n, int i, int j){
        int a = (~0)<<(j+1);
        int b = (1<<i)-1;
        int bitMask = a|b;
        return n&bitMask;
    }

}