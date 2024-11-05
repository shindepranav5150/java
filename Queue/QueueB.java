// import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
public class QueueB {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        // Queue<Integer> q = new ArrayDeque<>();    Other way

        q.add(0);
        q.add(1);
        q.add(2);

        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}
