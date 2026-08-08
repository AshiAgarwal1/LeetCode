class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        //doesnt know how many intervals in ans
        List<int[]> ans=new ArrayList<>();
        int i=0;
        int n=intervals.length;
        //if end time less than new interval's start time they are on left region 
        while(i<n && intervals[i][1]<newInterval[0]){
            ans.add(intervals[i]);
            i+=1;
        }
        //overlapping region if start time < new interval's end time
        while(i<n && intervals[i][0]<=newInterval[1]){
            newInterval[0]=Math.min(newInterval[0],intervals[i][0]);
            newInterval[1]=Math.max(newInterval[1],intervals[i][1]);
            i+=1;
        } 
        ans.add(newInterval);
        while(i<n){
            ans.add(intervals[i]);
            i+=1;
        }
        return ans.toArray(new int[ans.size()][]);
    }
}