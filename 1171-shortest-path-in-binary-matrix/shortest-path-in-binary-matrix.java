class Tuple{
int first,second,third;
Tuple(int first,int second,int third){
    this.first=first;
    this.second=second;
    this.third=third;
}
}
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        if(grid[0][0]==1 || grid[n-1][n-1]==1) return -1;
        if(n==1) return 1;
        Queue<Tuple> q=new LinkedList<>();
        int[][] dist=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dist[i][j]=(int)(1e9);
            }
        }
        dist[0][0]=1;
        q.add(new Tuple(1,0,0));
        int[] dr={-1,-1,-1,0,1,1,1,0};
        int[] dc={-1,0,1,1,1,0,-1,-1};
        while(!q.isEmpty()){
            Tuple curr=q.peek();
            q.remove();
            int dis=curr.first;
            int r=curr.second;
            int c=curr.third;
            for(int i=0;i<8;i++){
                int newr=r+dr[i];
                int newc=c+dc[i];
                if(newr>=0 && newr<n && newc>=0 && newc<n && grid[newr][newc]==0 && dis+1<dist[newr][newc]){
                    dist[newr][newc]=dis+1;
                    if(newr==n-1 && newc==n-1) return dis+1;
                    q.add(new Tuple(dis+1,newr,newc));
                }
            }
        }
        return -1;
    }
}