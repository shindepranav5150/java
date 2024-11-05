/*
    Reverse String using stack
 */

import java.util.Stack;

public class ReverseString {
    public static void main(String[] args) {
        String str = "abcd";
        
        System.out.println(reverse(str));
    }

    public static String reverse(String str){
        Stack<Character> s = new Stack<>();
        int idx = 0;
        while(idx < str.length()){
            s.push(str.charAt(idx));
            idx++;
        }

        StringBuilder result = new StringBuilder("");
        while (s.isEmpty() != true) {
            result.append(s.pop());
        }

        return result.toString();
    }
}
