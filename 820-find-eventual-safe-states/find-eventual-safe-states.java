class Solution {
    private boolean dfs(int i,int[][] graph,int[] vis,int[] pathVis,int[] check){
        vis[i]=1;
        pathVis[i]=1;
        check[i]=0;
        //traverse for adjacent nodes
        for(int it:graph[i]){
            //if the node is not visited
            if(vis[it]==0){
                if(dfs(it,graph,vis,pathVis,check)==true) return true;//if cycle
            }
            //if node is visited but on the same path to be a cycle
            else if(pathVis[it]==1) return true;
        }
        check[i]=1;//safe node
        pathVis[i]=0;
        return false;//no cycle
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        int[] vis=new int[n];
        int[] pathVis=new int[n];
        int[] check=new int[n];
        for(int i=0;i<n;i++){
            if(vis[i]==0){
                dfs(i,graph,vis,pathVis,check);
            }
        }
        List<Integer> safeNodes=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(check[i]==1) safeNodes.add(i);
        }
        return safeNodes;
    }
}