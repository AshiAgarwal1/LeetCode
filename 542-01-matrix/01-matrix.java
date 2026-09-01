class Pair{
    int first,second,third;
    Pair(int first,int second,int third){
        this.first=first;
        this.second=second;
        this.third=third;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        int[][] vis=new int[n][m];
        int[][] dis=new int[n][m];
        Queue<Pair> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    q.add(new Pair(i,j,0));//dist of 0 from nearest 0 is itself
                    vis[i][j]=1;
                }
                else vis[i][j]=0;
            }
        }
        // using bfs algo visit neighbours(only allowed in 4 directions)
        int[] rows={-1,0,1,0};
        int[] cols={0,-1,0,1};
        while(!q.isEmpty()){
            int r=q.peek().first;
            int c=q.peek().second;
            int steps=q.peek().third;
            q.remove();
            dis[r][c]=steps;
            for(int i=0;i<4;i++){
                int nrow=r+rows[i];
                int ncol=c+cols[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0){
                    vis[nrow][ncol]=1;
                    q.add(new Pair(nrow,ncol,steps+1));
                }
            }
        }
        return dis;
    }
}