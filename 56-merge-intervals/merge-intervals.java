class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int n=intervals.length;
        List<int[]> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
        while(i<n-1 && intervals[i][1]>=intervals[i+1][0])
        {
            intervals[i+1][0]=Math.min(intervals[i][0],intervals[i+1][0]);
            intervals[i+1][1]=Math.max(intervals[i][1],intervals[i+1][1]);
            i=i+1;
        }
        ans.add(intervals[i]);
        }
        return ans.toArray(new int[ans.size()][]);
    }
}