class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dist[i][j]=Integer.MAX_VALUE;
            }
        }
        for(int[] i:edges){
            int u=i[0];
            int v=i[1];
            int wt=i[2];
            dist[u][v]=wt;
            dist[v][u]=wt;
        }
        for(int i=0;i<n;i++) dist[i][i]=0;
        //floyd warshalls algo
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(dist[i][k]==Integer.MAX_VALUE || dist[k][j]==Integer.MAX_VALUE) continue;
                    dist[i][j]=Math.min(dist[i][j],dist[i][k]+dist[k][j]);
                }
            }
        }
        int cntMax=n;
        int cityNo=-1;
        for(int city=0;city<n;city++){
            int cnt=0;
            for(int adjCity=0;adjCity<n;adjCity++){
                if(dist[city][adjCity]<=distanceThreshold) cnt++;
            }
            if(cnt<=cntMax){
                cntMax=cnt;
                cityNo=city;
            }
        }
        return cityNo;
    }
}