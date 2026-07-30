class Solution {
    private boolean check(int start,int[][] graph,int[] color){
        Queue<Integer> q=new LinkedList<Integer>();
        q.add(start);
        color[start]=0;
        while(!q.isEmpty()){
            int node=q.remove();
            for(int i:graph[node]){
                if(color[i]==-1){
                    color[i]=1-color[node];
                    q.add(i);
                }
                else if(color[i]==color[node]) return false;
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int[] color=new int[graph.length];
        for(int i=0;i<graph.length;i++) color[i]=-1;
        for(int i=0;i<graph.length;i++){
            if(color[i]==-1){
                if(!check(i,graph,color)) return false;
            }
        }
        return true;
    }
}