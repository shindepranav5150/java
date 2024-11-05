/*
 * find all possible combination of string
 */

class StringPermutation {
    public static void main(String[] args) {
        findPermutation("abc", new String(""));
    }

    public static void findPermutation(String str, String ans){

        if(str.length()==0)
        {
            System.out.println(ans);
            return;
        }

        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            String newStr = str.substring(0, i)+str.substring(i+1); // remove char at ith place
            findPermutation(newStr, ans+ch);
        }
    }
}
