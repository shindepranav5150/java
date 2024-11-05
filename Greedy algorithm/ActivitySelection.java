/*
    You are given n activities with their start and end times.Select the maximum number of activities that can be performed
    by single person, assuming that a person can only work on a single ativity at a time.Activities are sorted according to end time

    e.g.
    start = [10,12,30]
    end = [20,25,30]

    ans : 2 acvtivies [A0,A2]
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class ActivitySelection {
    
    public static void main(String[] args) {
        int start[] = {1,3,0,5,8,5};
        int end[] = {2,4,6,7,9,9};

        //Sorted on basis of end time
        int activities[][] = new int[start.length][3];
        // 0->index  1->start  2->end

        for(int i=0;i<start.length;i++){
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }

        //lambda function -> short form
        Arrays.sort(activities,Comparator.comparingDouble(o -> o[2])); //2nd parameter -- on which basis sort is done

        int maxAct = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        //Always select first activity
        maxAct = 1;
        ans.add(activities[0][0]);
        int lastEnd = activities[0][2];
        for(int i=1; i<end.length;i++){
            if(activities[i][1] >= lastEnd){
                //activity selection
                maxAct++;
                ans.add(activities[i][0]);
                lastEnd = activities[i][2];
            }
        }

        System.out.println("Max Activities : "+ maxAct);
        for(int i=0;i<ans.size();i++){
            System.out.print("A"+ans.get(i) + " ");
        }
    }
    
 }