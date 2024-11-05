
import java.util.*;

public class CycleDetectionInDirectedGraph {
    static class Edge{
        int src;
        int dest;

        Edge(int s,int d){
            this.src =s;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph){
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 2));
    
        graph[1].add(new Edge(1, 0));

        graph[2].add(new Edge(2, 3));
    
        graph[3].add(new Edge(3, 0));
    }

    public static boolean isCylce( ArrayList<Edge>[] graph){
        boolean visited[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];

        for(int i=0;i<graph.length;i++){
            if(!visited[i]){
                if(isCylceUtil(graph,i,visited,stack)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isCylceUtil(ArrayList<Edge>[] graph,int curr, boolean visited[],boolean stack[]){

        visited[curr] = true;
        stack[curr] = true;

        for(int i=0; i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(stack[e.dest]){
                return true;  // cycle present
            }
            if(!visited[e.dest] && isCylceUtil(graph, e.dest, visited, stack)){
                return true;
            }
        }
        stack[curr] = false;
        return false;
    }

    public static void main(String[] args) {
        int V = 5; //vertex

        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        
        System.out.println(isCylce(graph));
    } 
}
