/*
    compression of string
    e.g. aaaabbbdd    ---> a4b3d2
         abc          ---> abc
         aabccd       ---> a2bc2d

*/

class StringCompression{

    public static void main(String args[]){
        String str = "a2b3c2d";
        System.out.println(compress(str));
        // System.out.println(deCompress(str));
    }

    public static String compress(String str){
        StringBuilder sb = new StringBuilder("");

        for(int i=0; i<str.length();i++){
            Integer cnt = 1;

            while(i < str.length()-1 && str.charAt(i) == str.charAt(i+1)){
                cnt++;
                i++;
            }

            sb.append(str.charAt(i));
            if(cnt>1)
            sb.append(cnt);
        }
        
        return sb.toString();
    }


    // Reverse of compression    e.g. a2b3c  --> aabbbc

    public static String deCompress(String str){
        StringBuilder sb = new StringBuilder("");

        for(int i=0;i<str.length();i++){

            char ch = str.charAt(i);
            if( i < str.length()-1 && str.charAt(i+1) >= '2' && str.charAt(i+1) <='9'){
                int cnt = (str.charAt(i+1) - '0');
                while(cnt>0){
                    sb.append(ch);
                    cnt--;
                }
                i++;
            }
            else{
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}
