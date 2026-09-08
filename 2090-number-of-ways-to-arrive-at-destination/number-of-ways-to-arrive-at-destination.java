class Pair{
    long first;
    int second;
    Pair(long first,int second){
        this.first=first;
        this.second=second;
    }
}
class Solution {
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] road:roads){
            adj.get(road[0]).add(new Pair(road[2],road[1]));
            adj.get(road[1]).add(new Pair(road[2],road[0]));
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>((x,y)->Long.compare(x.first,y.first));
        long[] dist=new long[n];
        long[] ways=new long[n];
        Arrays.fill(dist,Long.MAX_VALUE);
        dist[0]=0;
        ways[0]=1;
        pq.add(new Pair(0,0));
        int mod=(int)(1e9+7);
        while(!pq.isEmpty()){
            Pair curr=pq.remove();
            long dis=curr.first;
            int node=curr.second;
            for(Pair it:adj.get(node)){
                long edWt=it.first;
                int adjNode=it.second;
                
                if(dis+edWt<dist[adjNode]){
                    dist[adjNode]=dis+edWt;
                    pq.add(new Pair(dis+edWt,adjNode));
                    ways[adjNode]=ways[node];
                }
                else if(dis+edWt==dist[adjNode]){
                    ways[adjNode]=(ways[adjNode]+ways[node])%mod;
                }
            }
        }
        return (int)ways[n-1]%mod;
    }
}