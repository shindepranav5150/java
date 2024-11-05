public class DoublyCircularLinkedList {
    public class Node{
        int data;
        Node next;
        Node prev;

        public Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }

        
    }
    public static Node head;
    public static Node tail;
    public static int size;

    //add
    public void addFirst(int data){
        Node newNode = new Node(data);
        if(head==null){
            head = tail = newNode;
            head.prev = tail;
            tail.next = head;
            size++;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
        head.prev = tail;
        tail.next = head;
        size++;
    }

    public void addLast(int data){
        Node newNode = new Node(data);
        if(head==null){
            head = tail = newNode;
            head.prev = tail;
            tail.next = head;
            size++;
            return;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
        tail.next = head;
        head.prev = tail;
        size++;
    }

    //remove
    public int deleteFirst(){
        if(head == null){
            System.out.println("List is empty");
            return Integer.MIN_VALUE;
        }
        else if(head == tail){
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }
        int val = head.data;
        head = head.next;
        head.prev = tail;
        tail.next = head;
        size--;
        return val;
    }

    public int deleteLast(){
        if(head == null){
            System.out.println("List is empty");
            return Integer.MIN_VALUE;
        }
        else if(head == tail){
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }
        int val = tail.data;
        tail = tail.prev;
        tail.next = head;
        head.prev = tail;
        size--;
        return val;
    }

    public void print(){
        Node temp = head;
        do{
            System.out.print(temp.data  + " ");
            temp=temp.next;
        }while(temp!=head);
        System.out.println();
    }

    public void reverse(){
        if(head == null || head == tail){
            return;
        }
    
        Node curr = head;
        Node prevNode = tail;
        Node nextNode;
        do{
            nextNode = curr.next;
            curr.next = prevNode;
            curr.prev = nextNode;
            prevNode = curr;
            curr = nextNode;
        }while(prevNode != tail);
        head = prevNode;
        tail = curr;
    }

    public static void main(String[] args) {
        DoublyCircularLinkedList cll = new DoublyCircularLinkedList();

        cll.addFirst(2);
        cll.addFirst(1);
        cll.addLast(3);
        cll.addLast(4);
        // cll.deleteFirst();
        // cll.deleteLast();
        // System.out.println(size);
        cll.print();
        cll.reverse();
        cll.print();
    }
}
