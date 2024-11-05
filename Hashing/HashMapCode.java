import java.util.*;

public class HashMapCode {
    static class HashMap<K,V>{
        private class Node{
            K key;
            V value;

            public Node(K key,V value){
                this.key = key;
                this.value = value;
            }
        }

        static private int n = 0; // no. of key inserted
        private int N; 
        private LinkedList<Node> buckets[];

        @SuppressWarnings("Unchecked")
        public HashMap(){
            this.N = 4; // size of array
            this.buckets = new LinkedList[4];
            for(int i=0;i<4;i++){
                this.buckets[i] = new LinkedList<>();
            }

        }

        @SuppressWarnings("Unchecked")
        private void reHash(){
            LinkedList<Node> oldBuck[] = buckets;
            buckets = new LinkedList[N*2];
            N = N*2;

            for(int i=0;i<buckets.length;i++){
                buckets[i] = new LinkedList<>();
            }

            for(int i=0;i<oldBuck.length;i++){
                LinkedList<Node> ll = oldBuck[i];
                for(int j=0; j<ll.size(); j++){
                    Node node = ll.remove();
                    put(node.key,node.value);
                }
            }
        }

        private int hashFuction(K key){
            int hc = key.hashCode();
            return Math.abs(hc)%buckets.length;
        }

        private int searchInLL(K key, int bucketIndex){
            LinkedList<Node> ll = buckets[bucketIndex];

            int di = 0;
            for(int i=0; i<ll.size();i++){
                Node node = ll.get(i);
                if(node.key == key){
                    return di;
                }
                di++;
            }

            return -1;
        }
        public void put(K key, V value){
            int bucketIndex = hashFuction(key);
            int dataIndex = searchInLL(key,bucketIndex);  //if data present give index(update value) else give -1(add Node)

            if(dataIndex != -1){
                Node node = buckets[bucketIndex].get(dataIndex);
                node.value = value;
            }
            else{
                buckets[bucketIndex].add(new Node(key,value));
                n++;
            }

            double lambda = (double)n/N;
            if(lambda>2.0){
                reHash();
            }
        }

        public boolean containsKey(K key){
            int bucketIndex = hashFuction(key);
            int dataIndex = searchInLL(key,bucketIndex);
            if(dataIndex == -1){
                return false;
            }
            return true;
        }

        public V get(K key){
            int bucketIndex = hashFuction(key);
            int dataIndex = searchInLL(key,bucketIndex);  //if data present give index(update value) else give -1(add Node)

            if(dataIndex != -1){
                Node node = buckets[bucketIndex].get(dataIndex);
                return node.value;
            }
            else{
                return null;
            }
        }

        public V remove(K key){

            int bucketIndex = hashFuction(key);
            int dataIndex = searchInLL(key,bucketIndex);

            if(dataIndex != -1){
                Node node = buckets[bucketIndex].remove(dataIndex);
                n--;
                return node.value;
            }
            else{
                return null;
            }
        }

        public boolean isEmpty(){
            return n == 0;
        }

        public ArrayList<K> keySet(){

            ArrayList<K> keys = new ArrayList<>();
            for(int i=0;i<buckets.length;i++){
                LinkedList<Node> ll = buckets[i];
                for (Node node : ll) {
                    keys.add(node.key);
                }
            }
            return keys;
        }
    }
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();

        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("US", 50);
        hm.put("Nepal", 5);

        ArrayList<String> keys = hm.keySet();

        for (String key : keys) {
            System.out.println(key);
        }
    }
}