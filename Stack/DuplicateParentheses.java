/*
    Given balanced expression, find if it contains duplicate parantheses or not.
    A set of parantheses are duplicate if the same subexpression is surrounded by multiple parantheses
    
    e.g.   ((a+b))           true
           ((a+b) + (c+d))   false
           (((a+b)) + c)     true
 */

import java.util.Stack;

public class DuplicateParentheses {
    public static void main(String[] args) {
        String str = "(((a+b)) + c)";
        System.out.println(checkDuplicate(str));
    }

    public static boolean checkDuplicate(String str){
        Stack<Character> s = new Stack<>();

        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);

            if(ch != ')')
                s.push(ch);
            else{
                int count = 0;
                while(s.pop() != '('){
                    count++;
                }
                if(count == 0){
                    return true;
                }
            }
        }

        return false;
    }
}
