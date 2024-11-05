/*
    Given n pairs of number.
    In evry pair,the first number is always smaller than the second number. A paair (c,d) can come after pair(a,b) if b<c.
    Finde the longest chaain which can be formed from a given set of pairs.

    e.g.

    pairs
    ( 5,24)
    (39,60)
    ( 5,28)
    (27,40)
    (50,90)

    ans = 3

 */

import java.util.Arrays;
import java.util.Comparator;

public class ChainOfPairs {
    public static void main(String[] args) {
        int pairs[][] = {{ 5,24},{39,60},{ 5,28},{27,40},{50,90}};

        Arrays.sort(pairs,Comparator.comparingDouble(o -> o[1]));

        int chainLen = 1;
        int pairEnd = pairs[0][1];  //chain end

        for(int i=1; i<pairs.length;i++){
            if(pairEnd < pairs[i][0])
            {
                chainLen++;
                pairEnd = pairs[i][1];
            }
        }

        System.out.println(chainLen);
    }
}
