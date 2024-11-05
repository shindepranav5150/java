import java.util.Stack;

/**
    Push element at boottom of stack
 */
public class PushAtBottom {

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();

        s.push(1);
        s.push(2);
        s.push(3);
        
        System.out.println(s);
        pushAtBottom(s,4);
        System.out.println(s);
    }
    
    //recursion
    public static void pushAtBottom(Stack<Integer> s,int data){
        if(s.isEmpty()){
            s.push(data);
            return;
        }
        int top = s.pop();
        pushAtBottom(s, data);
        s.push(top);
    }
}
