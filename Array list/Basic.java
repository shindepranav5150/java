/*
    Dynamic memory
    linear data structure
    uses only object (Integer,Character)  not primitive datatype(int,char)


    operations:
    
    Add element             O(1)
    Get element             O(1)
    Remove element          O(n)
    set element at index    O(n)
    contains element        O(n)
*/

import java.util.ArrayList;
import java.util.Collections;


class Basic{
    public static void main(String[] args) {
        //It  is part of java collection Frameworks
        ArrayList<Integer>  list = new ArrayList<>();

        list.add(1);  // adding element
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(1,12);    //O(n)

        System.out.println(list);

        System.out.println(list.get(3));   //find value at index 3

        list.remove(2);     //remove element at index 2

        list.set(2, 10);   // set element 10 at index 2

        System.out.println(list.contains(10));   //check whether element is present or not

        System.out.println(list.size());   // Give size of ArrayList

        Collections.sort(list);  //sort ArrayList  ascending order

        Collections.sort(list,Collections.reverseOrder());  // Sort in Descending order

        
    }
}

