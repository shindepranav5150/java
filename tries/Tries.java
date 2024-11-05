class Tries{
    static class Node {
        Node children [] = new Node[26];
        boolean eow = false; //endOfWord

        Node(){
            for(int i=0;i<26;i++){
                children[i] = null;
            }
        }
        
    }

    public static Node root = new Node();


    //Insert in trie   O(L)  L--> largest word length
    public static void insert(String word){ 
        Node curr = root;

        for(int level = 0; level<word.length();level++){
            int idx = word.charAt(level) - 'a';
            if(curr.children[idx] == null){
                curr.children[idx] = new Node();
            }

            curr = curr.children[idx];
        }

        curr.eow = true;
    }

    //search in trie  O(L)
    public static boolean search(String word){
        Node curr = root;
        for(int level = 0;level<word.length();level++){
            int idx = word.charAt(level)-'a';
            if(curr.children[idx] == null){
                return false;
            }

            curr = curr.children[idx];
        }

        return curr.eow;
    }

    public static void main(String args[]){
        String words[] = {"the","a","there","their","any","thee"};

        for(int i=0;i<words.length;i++){
            insert(words[i]);
        }

        System.out.println(search("any"));
        System.out.println(search("an"));
    }
}