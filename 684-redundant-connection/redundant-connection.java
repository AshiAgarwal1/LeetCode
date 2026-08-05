class Solution {
    //to check if we can already reach from u to v 
    private boolean dfs(int u,int v,ArrayList<ArrayList<Integer>> adj,boolean[] vis){
        if(u==v) return true;
        vis[u]=true;
        for(int neighbor: adj.get(u)){
            if(!vis[neighbor]) {
                if(dfs(neighbor,v,adj,vis)) return true;
        }
    }
    return false;
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            boolean[] vis=new boolean[n+1];
            if(dfs(u,v,adj,vis)) return edge;//if there is already path from u to v return this edge as it will create a cycle
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        return new int[0];
    }
}