class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //create graph 
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
            }

        for(int[] pre:prerequisites){
            adj.get(pre[1]).add(pre[0]);
        }
        
        
        int indegree[]=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            for(int n:adj.get(i)){
                indegree[n]++;
            }
        }
        Queue<Integer> q=new LinkedList<Integer>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0) q.add(i);
        }
        List<Integer> topo=new ArrayList<Integer>();
        while(!q.isEmpty()){
            int node=q.peek();
            q.remove();
            topo.add(node);
            for(int n:adj.get(node)){
                indegree[n]--;
                if(indegree[n]==0) q.add(n);
            }
        }
        if(topo.size()==numCourses) return true;
        return false;
    }
}