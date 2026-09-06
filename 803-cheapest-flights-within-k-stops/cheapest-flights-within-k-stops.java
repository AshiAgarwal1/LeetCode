class Pair{
    int first,second;
    Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}
class Tuple{
    int first,second,third;
    Tuple(int first,int second,int third){
        this.first=first;
        this.second=second;
        this.third=third;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] f:flights){
            adj.get(f[0]).add(new Pair(f[1],f[2]));
        }
        Queue<Tuple> q=new LinkedList<>();
        q.add(new Tuple(0,src,0));
        int[] dist=new int[n];
        for(int i=0;i<n;i++){
            dist[i]=(int)(1e9);
        }
        dist[src]=0;
        while(!q.isEmpty()){
            Tuple curr=q.peek();
            q.remove();
            int stops=curr.first;
            int node=curr.second;
            int cost=curr.third;
            if(stops>k) continue;
            for(Pair x:adj.get(node)){
                int adjNode=x.first;
                int edWt=x.second;
                if(cost+edWt<dist[adjNode]){
                    dist[adjNode]=cost+edWt;
                    q.add(new Tuple(stops+1,adjNode,cost+edWt));
                }
            }
        }
        if(dist[dst]==1e9) return -1;
        return dist[dst];
    }
}