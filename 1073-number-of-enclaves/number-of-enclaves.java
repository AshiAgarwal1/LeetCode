class Pair{
    int first,second;
    Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}
class Solution {
    public int numEnclaves(int[][] grid) {
        Queue<Pair> q=new LinkedList<>();
        int m=grid.length;
        int n=grid[0].length;
        int[][] vis=new int[m][n];
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 || j==0 || i==m-1 || j==n-1){
                    if(grid[i][j]==1){
                    q.add(new Pair(i,j));
                    vis[i][j]=1;}
                }
            }
            }
            while(!q.isEmpty()){
                Pair curr=q.remove();
                int row=curr.first;
                int col=curr.second;
                int[] delRow={-1,0,0,1};
                int[] delCol={0,-1,1,0};
                for(int i=0;i<4;i++){
                    int nrow=row+delRow[i];
                    int ncol=col+delCol[i];
                    if(nrow>=0 && ncol>=0 && nrow<m && ncol<n && vis[nrow][ncol]==0 && grid[nrow][ncol]==1){
                        q.add(new Pair(nrow,ncol));
                        vis[nrow][ncol]=1;
                    }
                }
            }   
        int cnt=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(vis[i][j]==0 && grid[i][j]==1) cnt++;
            }
        }
    return cnt;
    }
}