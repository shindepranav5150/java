/*
    First non-repeating letter in a stream of characters.

    e.g.: aabccxb         output  a-1bbbbx
          a                 a
          aa                -1
          aab               b
          aabc              b
          aabcc             b
          aabccx            b
          aabccxb           x
*/

import java.util.LinkedList;
import java.util.Queue;

public class FirstNonRepeating {
    public static void main(String[] args) {
        String str = "aabccxb";
        firstNonRepeating(str);
    }

    public static void firstNonRepeating(String str){
        int freq[] = new int[26]; 

        Queue<Character> q = new LinkedList<>();

        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            q.add(ch);
            freq[ch-'a']++;

            while(!q.isEmpty() && freq[q.peek()-'a'] > 1){
                q.remove();
            }

            if(q.isEmpty()){
                System.out.print(-1 + " ");
            }else{
                System.out.print(q.peek() + " ");
            }
        }
    }
}
 