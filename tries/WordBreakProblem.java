/*
    Given an input string and dictionary of words, find out if the input string can be broken into space-seprated sequence of dictionary words.

    words[] = {"i","like","sam","samsung","mobile","ice"}
    key = "ilikesamsung"

    ans = true
 */

public class WordBreakProblem {
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


    public static boolean wordBreak(String key){

        if(key.length()==0){
            return true;
        }
        for(int i=1;i<=key.length();i++){
            if(search(key.substring(0, i)) &&wordBreak(key.substring(i))){
                return true;
            }
        }

        return false;
    }
    public static void main(String[] args) {
        String words[] = {"i","like","sam","samsung","mobile","ice"};

        String key = "ilikesamsung";
        
        for(int i=0;i<words.length;i++){
            insert(words[i]);
        }

        System.out.println(wordBreak(key));
    }
}
