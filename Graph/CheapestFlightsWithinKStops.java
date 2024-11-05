/*
    There are n cities connectd by some number of flights. You are given an array flights where flights[i] = [from, to,prices]
    You are also given there intgers src,dst and k, return cheapest price from src to dst with at most k stops.If there is no such route, retuen -1;
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CheapestFlightsWithinKStops {
    static class Edge{
        int src;
        int dst;
        int price;

        public Edge(int src,int dst,int price){
            this.src = src;
            this.dst = dst;
            this.price = price;
        }
    }

    public static void createGraph(int flights[][],ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0;i<flights.length;i++){
            int src = flights[i][0];
            int dest = flights[i][1];
            int cost = flights[i][2];

            Edge e =  new Edge(src, dest, cost);
            graph[src].add(e);
        }
    }


    static class Info{
        int vertex;
        int cost;
        int stops;

        public Info(int vertex,int cost,int stops){
            this.vertex = vertex;
            this.cost = cost;
            this.stops = stops;
        }  
    }
    // dijkstra algorithm
    public static int cheapestFlight(int n,int flights[][],int src, int dest,int k){

        ArrayList<Edge> graph[] = new ArrayList[n];
        createGraph(flights,graph);

        int dist[] = new int[flights.length];
        for(int i=0;i<dist.length;i++){
            if(src!=i){
                dist[i] = Integer.MAX_VALUE;
            }
        }

        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src, 0,0));
        while(!q.isEmpty()){
            Info curr = q.remove();

            if(curr.stops > k){
                break;
            }

            for(int i=0; i<graph[curr.vertex].size();i++){
                Edge e = graph[curr.vertex].get(i);
                int u = e.src;
                int v = e.dst;
                int price = e.price;

                if(curr.cost+price < dist[v] && curr.stops <= k){
                    dist[v] = curr.cost+price;
                    q.add(new Info(v, dist[v], curr.stops+1));
                }
            }
        }

        if(dist[dest] != Integer.MAX_VALUE){
            return dist[dest];
        }
        return -1;
    }

    public static void main(String args[]){
        int n = 4;
        int k = 1;
        int flights[][] = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        
        System.out.println(cheapestFlight(n,flights,0,3,1));
    }
}
