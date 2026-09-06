class Tuple{
    int distance,row,col;
    Tuple(int distance,int row,int col){
        this.distance=distance;
        this.row=row;
        this.col=col;
    }
}
class Solution {
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<Tuple> pq=new PriorityQueue<Tuple>((a,b)->a.distance-b.distance);
        int n=heights.length;
        int m=heights[0].length;
        int[][] dist=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dist[i][j]=(int)(1e9);
            }
        }
        dist[0][0]=0;
        pq.add(new Tuple(0,0,0));
        int[] dr={-1,0,1,0};
        int[] dc={0,1,0,-1};
        while(!pq.isEmpty()){
            Tuple curr=pq.peek();
            pq.remove();
            int diff=curr.distance;
            int r=curr.row;
            int c=curr.col;
            if(r==n-1 && c==m-1) return diff;
            for(int i=0;i<4;i++){
                int newr=r+dr[i];
                int newc=c+dc[i];
                if(newr>=0 && newc>=0 && newr<n && newc<m){
                    int newEffort=Math.max(Math.abs(heights[r][c]-heights[newr][newc]),diff);
                    if(newEffort<dist[newr][newc]){
                        dist[newr][newc]=newEffort;
                        pq.add(new Tuple(newEffort,newr,newc));
                    }
                }
            }
        }
        return 0;
    }
}