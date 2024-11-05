class abstractClass{
   

    public static void main(String args[]){
        Horse h = new Horse();
        h.eat();
        h.walk();

        Chicken c = new Chicken();
        c.eat();
        c.walk();
    }
}



abstract class Animal{
    void eat(){
        System.out.println("Animal eats");
    }

    abstract void walk();     // abstract method the derived class need to give its implementaion compulsory
}

class Horse extends Animal{
    void walk(){
        System.out.println("Walks on 4 legs");
    }
}

class Chicken extends Animal{
    void walk(){
        System.out.println("Walks on 2 legs");
    }
}


/* 

Abstraction:
    hides unwanted data & only shows important data

    Done by :
        abstract class
        interface

abstrct class
    only provide the idea not implementation

    properties:
        cannot create the instances/objects of abstract class
        contains both abstract and non-abstract methods
        constructor can be created

*/