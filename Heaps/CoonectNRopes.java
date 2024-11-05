/*
    Given N ropes of different lenghts,the task is to connect these ropes into one rope with minimum cost,such that cost to connect two ropes is equal to the sum of their lenghts.
 */

import java.util.PriorityQueue;

public class CoonectNRopes {
    public static void main(String args[]){
        int ropes[] = {4,3,3,2,6};

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<ropes.length;i++){
            pq.add(ropes[i]);
        }

        int cost = 0;
        while(pq.size()>1){
            int temp = pq.remove()+pq.remove();
            cost += temp;
            pq.add(temp);
        }

        System.out.println("Minimum cost : "+ cost);
    }
}
