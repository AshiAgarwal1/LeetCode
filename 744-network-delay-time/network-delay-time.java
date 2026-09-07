class Tuple{
    int first,second;
    Tuple(int first,int second){
        this.first=first;
        this.second=second;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Tuple>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++){adj.add(new ArrayList<>());}
        for(int []t:times){
            adj.get(t[0]).add(new Tuple(t[1],t[2]));
        }
        int[] dist=new int[n+1];//shortest time known
        Arrays.fill(dist,(int)(1e9));
        PriorityQueue<Tuple> q=new PriorityQueue<Tuple>((a,b)->a.first-b.first);//to process smallest time first
        q.add(new Tuple(0,k));
        dist[k]=0;
        while(!q.isEmpty()){
            Tuple curr=q.remove();
            int time=curr.first;
            int toNode=curr.second;
            if(time>dist[toNode]) continue;
            for(Tuple it:adj.get(toNode)){// visit adj nodes
                    int adj_node=it.first;
                    int adj_time=it.second;
                    if(time+adj_time<dist[adj_node]){
                    q.add(new Tuple(time+adj_time,adj_node));
                    dist[adj_node]=time+adj_time;}
            }
        }
        int max_time=0;//time when all node received signal
        for(int i=1;i<dist.length;i++){
            if(dist[i]==(int)(1e9)) return -1;
            max_time=Math.max(max_time,dist[i]);
        }
        return max_time;
    }
}