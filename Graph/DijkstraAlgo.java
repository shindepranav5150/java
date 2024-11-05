import java.util.ArrayList;
import java.util.PriorityQueue;

public class DijkstraAlgo {
     static class Edge{
        int src;
        int dest;
        int wt;

        Edge(int s,int d,int w){
            this.src =s;
            this.dest = d;
            this.wt = w;
        }
    }


    public static void createGraph(ArrayList<Edge>[] graph){
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 3, 7));
        graph[1].add(new Edge(1, 2, 1));

        graph[2].add(new Edge(2, 4, 3));
        
        graph[3].add(new Edge(3, 5, 1));
        
        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));

    }

    static class Pair implements Comparable<Pair>{
        int n;  //node
        int path;
        // String str;

        Pair(int n, int path){
            this.n = n;
            this.path = path;
        }
        // Pair(int n, int path,String str){
        //     this.n = n;
        //     this.path = path;
        //     this.str = str;
        // }

        @Override
        public int compareTo(Pair s2){
            return this.path - s2.path;
        }
    }

    // O(V + E*logV)
    public static void dijkstra(ArrayList<Edge>[] graph, int src){
        boolean visited[] = new boolean[graph.length];
        int dist[] = new int[graph.length];
        // String sb[] = new String[graph.length];
    
        //starting distance of each node from source
        for(int i=0;i<dist.length;i++){
            dist[i] = Integer.MAX_VALUE;
            // sb[i] = new String(""+src);
        }
        dist[src] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));
        // pq.add(new Pair(src, 0,""+src));
        
        while(!pq.isEmpty()){
            Pair curr = pq.remove();

            if(!visited[curr.n]){
                for(int i=0;i<graph[curr.n].size();i++){
                    Edge e = graph[curr.n].get(i);
                    // u->v
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;
                    
                    if(dist[u]+wt < dist[v]){
                        dist[v] = dist[u]+wt;
                        pq.add(new Pair(v, dist[v]));
                        // pq.add(new Pair(v, dist[v],curr.str+v));
                        // sb[v]=(curr.str+Integer.toString(v));
                    }
                }
            }
        }

        //Print shortest distance from src

        for(int i=0;i<dist.length;i++){
            System.out.print(dist[i] + " ");
        }

        // System.out.println();
        // //print path
        // for(int i=0;i<sb.length;i++){
        //     System.out.println(sb[i]);
        // }
    }
    public static void main(String[] args) {
        int V = 6; //vertex

        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph(graph);
        dijkstra(graph, 0);
    } 
}
