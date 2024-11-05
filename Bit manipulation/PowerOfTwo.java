// Check wheater given no. is power of two or not

class PowerOfTwo{
    public static void main(String args[]){
        System.out.println(isPower(7));
    }

    public static boolean isPower(int n){
        return (n & n-1) == 0;
    }

}