/*
    Given route containing 4 directions (E,W,N,S)
    find the shortest path distance to reach the destination which is displacment

    if x=3 y=4 shortest distance = 5 (pythagoras)

    e.g. WNEENESENNN  this is the path

    travel 1 unit in the given directions

    start from index (0,0);

*/


class ShortestPath{
    public static void main(String args[]){
        String path = "WNEENESENNN";
        System.out.println(shortestDistance(path));
    }

    public static double shortestDistance(String path){
        int n = path.length();

        int x_axis = 0;
        int y_axis = 0;

        /*
            N -> y+1
            S -> y-1
            E -> x+1
            W -> x-1
        */
        for(int i=0;i<n;i++){
            char dir = path.charAt(i);

            if(dir == 'N')
                y_axis++;
            else if(dir == 'S')
                y_axis--;
            else if(dir == 'E')
                x_axis++;
            else
                x_axis--;
        }

        double ans =  Math.sqrt(Math.pow(x_axis,2) + Math.pow(y_axis,2));

        return ans;
    }
}