import java.util.Scanner;               // imports the Scanner class from util package

public class 2_userInput{
    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);     // sc is object of Scanner class

        String input1 = sc.next();

        System.out.println(input1);
    }
}


/* 

next()         ->    single word
nextLine()     ->    complete line
nextInt()      ->    Integer
nextByte()     ->    Byte
nextFloat()    ->    Float
nextDouble()   ->    Double
nextBoolean()  ->    Boolean
nextShort()    ->    Short
nextLong()     ->    Long

*/

