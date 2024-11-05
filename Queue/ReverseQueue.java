/*
    Reverse the Queue

    e.g.  1 2 3 4 5 6
          6 5 4 3 2 1
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseQueue {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=1;i<=10;i++){
            q.add(i);
        }

        reverse(q);
        System.out.println(q);
    }

    public static void reverse(Queue<Integer> q){
        Stack<Integer> s = new Stack<>();

        while(!q.isEmpty()){
            s.push(q.remove());
        }
        while(!s.isEmpty()){
            q.add(s.pop());
        }
    }
}
