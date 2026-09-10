class Solution {
    int m;
    int n;
    int[] delRow={-1,0,0,1};
    int[] delCol={0,-1,1,0};
    private void dfs(int row,int col,int[][] grid,int[][] vis){
        vis[row][col]=1;
        //check neighbours
        for(int i=0;i<4;i++){
            int nrow=row+delRow[i];
            int ncol=col+delCol[i];
            if(isValid(nrow,ncol) && vis[nrow][ncol]==0 && grid[nrow][ncol]==1){
                dfs(nrow,ncol,grid,vis);
            }
        }

    }
    private boolean isValid(int r,int c){
        return r>=0 && c>=0 && r<m && c<n;
    }
    public int numEnclaves(int[][] grid) {
        m=grid.length;
        n=grid[0].length;
        int[][] vis=new int[m][n];
        //traverse first and last row
        for(int j=0;j<n;j++){
            //first row
            if(vis[0][j]==0 && grid[0][j]==1)
            dfs(0,j,grid,vis);
            //last row
            if(vis[m-1][j]==0 && grid[m-1][j]==1)
            dfs(m-1,j,grid,vis);
        }
        //traverse first col and last col
        for(int i=0;i<m;i++){
            //first col
            if(vis[i][0]==0 && grid[i][0]==1)
            dfs(i,0,grid,vis);
            //last col
            if(vis[i][n-1]==0 && grid[i][n-1]==1)
            dfs(i,n-1,grid,vis);
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