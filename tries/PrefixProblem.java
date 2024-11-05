/*
    Find shortest unique prefix for every word in given list.Assume no word is prefix of another.

    arr[] = {"zebra","dog","duck","dove"};

    ans[] = {"z","dog","du","dov"}
 */

public class PrefixProblem {
    static class Node {
        Node children[] = new Node[26];
        boolean eow = false; // endOfWord
        int freq;

        Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
            freq = 1;
        }

    }

    public static Node root = new Node();

    // Insert in trie O(L) L--> largest word length
    public static void insert(String word) {
        Node curr = root;

        for (int level = 0; level < word.length(); level++) {
            int idx = word.charAt(level) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }else{
                curr.children[idx].freq +=1;
            }

            curr = curr.children[idx];
        }

        curr.eow = true;
    }

    // search in trie O(L)
    public static String findPrefix(String word) {
        Node curr = root;
        
        StringBuilder ans = new StringBuilder("");

        for(int i=0;i<word.length();i++){
            int idx = word.charAt(i)-'a';
            ans.append(word.charAt(i));
            
            if(curr.children[idx].freq == 1){
                break;
            }
            
            curr = curr.children[idx];
        }
        return ans.toString();
    }

    public static void findPrefix2(Node root,String ans) {

        if(root == null){
            return;
        }
        if(root.freq == 1){
            System.out.println(ans);
            return;
        }
        for(int i=0;i<26;i++){
            if(root.children[i] != null){
                findPrefix2(root.children[i], ans+(char)(i+'a'));
            }
        }
    }
    public static void main(String args[]) {
        String words[] = {"zebra","dog","duck","dove"};

        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }
        root.freq = -1;
        String ans [] = new String[words.length];

        for (int i = 0; i < words.length; i++) {
            ans[i] = findPrefix(words[i]);
        }

        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }

}
