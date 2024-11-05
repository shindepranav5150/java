// Print n size binary number without consecutive 1

public class NoConsecutive1 {
    public static void main(String[] args) {
        printBinStrings(3, 0, new String(""));
    }

    public static void printBinStrings(int n,int lastplace,String sb){

        if(n == 0){
            System.out.println(sb);
            return;
        }

        printBinStrings(n-1, 0, sb+"0");

        if(lastplace == 0)
            printBinStrings(n-1, 1, sb+"1");
    }
}
