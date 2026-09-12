class Pair{
    int dist,node;
    Pair(int dist,int node){
        this.dist=dist;
        this.node=node;
    }
}
class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
       //adjacency list
       List<List<Pair>> adj=new ArrayList<>();
       for(int i=0;i<n;i++){adj.add(new ArrayList<>());}
        for(int[] i:edges){
            int u=i[0];
            int v=i[1];
            int wt=i[2];
            adj.get(u).add(new Pair(wt,v));
            adj.get(v).add(new Pair(wt,u));
        }
        int cntMax=n;
        int cityNo=-1;
        //run dijkstra from every city
        for(int city=0;city<n;city++){
            int[] dist=new int[n];
            Arrays.fill(dist,Integer.MAX_VALUE);
            PriorityQueue<Pair> pq=new PriorityQueue<>((x,y)->x.dist-y.dist);
            dist[city]=0;
            pq.add(new Pair(0,city));
            while(!pq.isEmpty()){
                Pair curr=pq.remove();
                int d=curr.dist;
                int node=curr.node;
                if(d>dist[node]) continue;
                for(Pair it:adj.get(node)){
                    int wt=it.dist;
                    int adjNode=it.node;
                    if(d+wt<dist[adjNode]){
                        dist[adjNode]=d+wt;
                        pq.add(new Pair(d+wt,adjNode));
                    }
                }
            }
            int cnt=0;
            for(int adjCity=0;adjCity<n;adjCity++){
                if(dist[adjCity]<=distanceThreshold) cnt++;
            }
            if(cnt<=cntMax){
                cntMax=cnt;
                cityNo=city;
            }
        }
        return cityNo;
    }
}