class Tuple{
    int first,second;
    Tuple(int first,int second){
        this.first=first;
        this.second=second;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
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
            for(int[] t:times){
                if(t[0]==toNode){
                    if(time+t[2]<dist[t[1]]){
                    q.add(new Tuple(time+t[2],t[1]));
                    dist[t[1]]=time+t[2];}
                }
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