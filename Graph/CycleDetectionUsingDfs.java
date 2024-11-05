import java.util.*;

public class CycleDetectionUsingDfs {
    static class Edge{
        int src;
        int dest;
        int weight;

        Edge(int s,int d,int w){
            this.src =s;
            this.dest = d;
            this.weight = w;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph){
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));
        graph[0].add(new Edge(0, 3, 1));
        
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 2, 1));

        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 1, 1));
        
        graph[3].add(new Edge(3, 0, 1));
        graph[3].add(new Edge(3, 4, 1));
        
        graph[4].add(new Edge(4, 3, 1));
    }


    public static boolean detectCycle( ArrayList<Edge>[] graph){
        boolean visited[] = new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!visited[i]){
                if(detectCycleUtil(graph,visited,i,-1)){
                    return true;
                    //cycle exists in one part
                }
            }
        }

        return false;

    }

    public static boolean detectCycleUtil(ArrayList<Edge>[] graph, boolean visited[],int curr, int par){

        visited[curr] = true;

        for(int i=0; i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            
            // neighbour is not visited
            if(!visited[e.dest]){
                if (detectCycleUtil(graph, visited, e.dest, curr))
                    return true;
            }

            //neighbour is visited but it is not parent
            else if(visited[e.dest] && e.dest !=par){
                return true;
            }

            //neighbour is visited but it is parent  --> continue

        }

        return false;
    }

    public static void main(String[] args) {
        int V = 5; //vertex

        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        
        System.out.println(detectCycle(graph));
    } 
}