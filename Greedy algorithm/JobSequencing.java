/*
    Given an array of jobs where every job  has a deadline and profit if the job is finished before the deadline.
    It is also given that every job takes a single unit of time, so the minimum possible deadline for any job is 1
    maximize the total profit if only one job can scheduled at a time.
 */

import java.util.*;
public class JobSequencing{

    static class Job{
        int deadline;
        int profit;
        int id;

        Job(int i, int d, int p){
            id = i;
            deadline = d;
            profit = p;
        }
    }
    public static void main(String[] args) {
        int jobsInfo[][] = {{4,10},{1,10},{1,40},{1,30}};

        ArrayList<Job> jobs = new ArrayList<>();
        for(int i=0; i<jobsInfo.length; i++){
            jobs.add( new Job(i, jobsInfo[i][0], jobsInfo[i][1]));
        }

        Collections.sort(jobs, (obj1,obj2) -> obj2.profit-obj1.profit);  // descending order

        // Find Maximum DeadLine
        int maxDeadLine = 0;
        for(int i=0;i<jobs.size();i++){
            Job curr = jobs.get(i);
            maxDeadLine = Math.max(maxDeadLine, curr.deadline);
        }

        boolean slot[] = new boolean[maxDeadLine];
        Arrays.fill(slot,false);

        ArrayList<Integer> seq = new ArrayList<>();
        int totalProfit = 0;

        for(int i =0; i<jobs.size();i++){
            Job curr = jobs.get(i);
            
            //Find heighest possible time slot avialable
            for(int j=Math.min(curr.deadline-1,maxDeadLine-1); j>=0; j--){

                if(slot[j] == false){  //slot is avilable
                    slot[j] = true;
                    totalProfit += curr.profit;
                    seq.add(curr.id);
                    break;
                }
            }
            
        }
        System.out.println("Max jobs. : " + seq.size());
        System.out.println("Max Profit : " + totalProfit);
        System.out.println(seq);
    }
}
