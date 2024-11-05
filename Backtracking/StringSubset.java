/*
 * Find all subset of string
 */


class StringSubset{
    public static void main(String args[]){
        findSubset("abcd", new String(""), 0);
    }

    public static void findSubset(String str,String ans,int i){
        if(i==str.length())
        {
            if(ans.length()==0)
            System.out.println("null");
            else
            System.out.println(ans);
            return;
        }

        findSubset(str, ans+str.charAt(i), i+1);
        findSubset(str, ans, i+1);
    }
}