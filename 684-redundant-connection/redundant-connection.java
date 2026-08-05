class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] degree=new int[n+1];
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
            degree[u]++;
            degree[v]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<=n;i++) {
            if(degree[i]==1) q.add(i);}
        while(!q.isEmpty()){
            int node=q.poll();
            degree[node]--;
            for(int neighbor:adj.get(node)){
                degree[neighbor]--;
                if(degree[neighbor]==1) q.add(neighbor);
            }
        }
        for(int i=edges.length-1;i>=0;i--){
           int u=edges[i][0];
           int v=edges[i][1];
           if(degree[u]==2 && degree[v]==2) return new int[]{u,v};
        }
        return new int[0];
    }
}