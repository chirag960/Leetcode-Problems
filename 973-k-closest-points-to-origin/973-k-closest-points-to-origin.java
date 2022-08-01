class Solution {
    
        public static class Points{
        int ind;
        double dist;

        public Points(int ind, double dist){
            this.ind = ind;
            this.dist = dist;
        }
        }
    
    public static int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Points> heap = new PriorityQueue<>((o1, o2) -> (int)(o1.dist - o2.dist));

        for(int i=0;i< points.length;i++){
            double dist = Math.pow(points[i][0],2) + Math.pow(points[i][1],2);
            Points p = new Points(i,dist);
            heap.add(p);
        }

        int[][] ans = new int[k][2];

        for(int i=0;i<k;i++){
            Points p = heap.poll();
            ans[i] = points[p.ind];
        }

        return ans;
    }
    
    
}