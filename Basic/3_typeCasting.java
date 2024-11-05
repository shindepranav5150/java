public class 3_typeCasting{
    public static void main(String args[]){
        float a = 25.99f;
        int b = (int) a;

        System.out.print(b);
    }
}

/*

type converion -> implicit conversion / widening
    datatypes are compactible
    destination datatype size > source datatype size
    byte -> short -> int -> float -> long -> double
    char -> int
    int a = 10;
    flaot b = a;   ----> possible

    float a = 10.0f;
    int b = a;   -----> not possible

type casting -> explicit conversion / narrowing
    it is lossy conversion
    float a = 25.99f;
    int b = (int) a;    ----> float to int

*/

/*
Type Promotion :
    1) In the expression, if byte, char, short are present then they are converted to int.

    2) if there is long, float, double is preaent the all the operands in the expression are converted to long, float, double respectively.
       long<float<double

*/