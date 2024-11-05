/*
    We are given a bar of chocolate composed of mxn square pieces. One should break the chocolate into single squares. Each break of a part of the chocolate is charged a cost expressed by a positive integer.
    This cost does not depend on the size of the part that is being broken but only depends on the line the break goes along. Let us denote the costs of breaking along consecutive vertical lines with x1, x2, ..., xm-1 and along horizontal lines with y1, y2, ..., yn-1.
    Compute the minimal cost of breaking the whole chocolate into single squares.
*/

import java.util.Arrays;
import java.util.Collections;

public class ChocolaProblem {
    public static void main(String[] args) {
        // int n=4, m =6;
        Integer costHorizontal[] = {4,1,2};  //n-1
        Integer costVertical[] = {2,1,3,1,4}; //m-1

        Arrays.sort(costHorizontal,Collections.reverseOrder());
        Arrays.sort(costVertical,Collections.reverseOrder());

        int h=0, v=0;
        int horPiceCount = 0;
        int verPiceCount = 0;
        int cost = 0;

        while(h< costHorizontal.length && v<costVertical.length){
           
            if(costVertical[v]<=costHorizontal[h]){  //horizontal cut
                cost += (costHorizontal[h] * verPiceCount);
                horPiceCount++;
                h++;
            }
            else{  //vertical cut
                cost+= (costVertical[v] * horPiceCount);
                verPiceCount++;
                v++;
            }
        }

        while(h < costHorizontal.length){
            cost += (costHorizontal[h] * verPiceCount);
            horPiceCount++;
            h++;
        }

        while(v < costVertical.length){
            cost+= (costVertical[v] * horPiceCount);
            verPiceCount++;
            v++;
        }

        System.out.println("Min cost : " + cost);
    }
}
