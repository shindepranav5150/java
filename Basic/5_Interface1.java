class Interface1{
    public static void main(String args[]){
        Queen q = new Queen();
        q.moves();
    }
}

interface ChessPlayer{
    void moves();
}
class Queen implements ChessPlayer{
    public void moves(){
        System.out.println("up,down,left,right,diagonal");
    }
}
class Rook implements ChessPlayer{
    public void moves(){
        System.out.println("up,down,left,right,diagonal");
    }
}
class King implements ChessPlayer{
    public void moves(){
        System.out.println("up,down,left,right,diagonal(by 1 step)");
    }
}
/*
Interface
    - It is the blue print of class
    - Used to implement Multiple Inheritance
    - Used to Achive total abstraction

to inherits interface use keyword "implements"

Properties:
    - all methods are public, abstrct & without   implementation
    - Varibles in interace are final, public & static


final keyword:
    - final variables -> create constant variables. We cannot change there value once they are intialized
    - final methods -> Prevent method overriding by subclass
    -final classes -> Prevent inheritance. class defined as final, cannot be extended by subclass

static: 
    - used to share the same variable or method of given class among all of its object

    we make following things static:
        properties, functions, Blocks, Nested Classes

        nested class: 
        class A{
            class B{

            }
            class C{

            }
        }

super keyword :
    - used to refer immediate class object

    - uesd to access parent properties, functions, construtor

*/