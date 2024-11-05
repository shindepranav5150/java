/*
    we are given N points in 2D plan which are locatons of N cars. If we are at the origin, print the nearest K cars. 
 */

import java.util.PriorityQueue;

public class NearbyPoints {

    static class Point implements Comparable<Point>{
        int x;
        int y;
        int distSq;
        int idx;

        public Point(int x,int y,int idx){
            this.x = x;
            this.y = y;
            this.distSq = x*x+y*y;
            this.idx = idx;
        }

        @Override
        public int compareTo(Point p2){
            return this.distSq - p2.distSq;  // ascending order
        }
    }
    public static void main(String[] args) {
        int pts[][] ={{3,3},{5,-1},{-2,4}};
        int k=2;

        PriorityQueue<Point> pq = new PriorityQueue<>();
        for(int i=0;i<pts.length;i++){
            pq.add(new Point(pts[i][0],pts[i][1],i));
        }


        //nearest k points
        for(int i=0; i<k;i++){
            System.out.println("C"+pq.remove().idx );
        }
    }
}
