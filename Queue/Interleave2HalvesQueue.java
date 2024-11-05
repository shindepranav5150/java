/*
    Interleave 2 halves of Queue(even length)
    e.g.
     1 2 3 4 5 6 7 8
     1 5 2 6 3 7 4 8
 */

import java.util.LinkedList;
import java.util.Queue;

public class Interleave2HalvesQueue {
    
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=1;i<=10;i++){
            q.add(i);
        }

        interleave(q);

        System.out.println(q);
    }

    public static void interleave(Queue<Integer> q){
        int size = q.size();

        Queue<Integer> firstHalf = new LinkedList<>();
        for(int i=0;i<size/2;i++){
            firstHalf.add(q.remove());
        }

        while (!firstHalf.isEmpty()) {
            q.add(firstHalf.remove());
            q.add(q.remove());
        }
    }
}
