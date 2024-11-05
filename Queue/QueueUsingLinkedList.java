
public class QueueUsingLinkedList {

    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    static class Queue{
        static Node front = null;
        static Node rear = null;

        public static boolean isEmpty(){
            return rear == null;
        }

        public static void add(int data){
            Node newNode = new Node(data);
            if(front == null){
                front = rear = newNode;
                return;
            }
            rear.next = newNode;
            rear = newNode;
        }

        public static int remove(){
            if(isEmpty()){
                System.out.println("Empty Queue");
                return -1;
            }
            int val = front.data;
            if(rear == front){
                rear = front =null;
            }
            else{
                front = front.next;
            }
            return val;
        }
        public static int peek(){
            if(isEmpty()){
                System.out.println("Empty Queue");
                return -1;
            }
            return front.data;
        }
    }
    public static void main(String[] args) {
        Queue q = new Queue();

        q.add(0);
        q.add(1);
        q.add(2);

        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
    
}