class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
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
        int[] topo=new int[numCourses];
        int idx=0;
        while(!q.isEmpty()){
            int node=q.peek();
            q.remove();
            topo[idx++]=node;
            for(int n:adj.get(node)){
                indegree[n]--;
                if(indegree[n]==0) q.add(n);
            }
        }
        if(idx==numCourses) return topo;
        return new int[0];
    }
}