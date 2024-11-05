// find set bit in given number i.e. how many 1 bit present

class CountSetBit{
    public static void main(String args[]){

        System.out.println(countBit(16));
    }

    public static int countBit(int n){
        int count = 0;
        int bitMask = 1;
        while(n>0){
            if((n&bitMask) != 0)
                count++;
            n = n>>1;
        }
        return count;
    }
}