class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        PriorityQueue<int[]> minHeap=new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        HashMap<Integer,Integer> map=new HashMap<>();//to store ans for each query
        int i=0;
        for(int q: Arrays.stream(queries).sorted().toArray()){
            //add intervals to minheap whose start<=q
            while(i<intervals.length && intervals[i][0]<=q){
                int l=intervals[i][0];
                int r=intervals[i][1];
                minHeap.add(new int[]{r-l+1,r});//{size,right end}
                i++;
            }
            //remove the intervals which end before q
            while(!minHeap.isEmpty() && minHeap.peek()[1]<q){
                minHeap.poll();
            }
            //answer for q i.e. min interval 
            map.put(q,minHeap.isEmpty()? -1:minHeap.peek()[0]);
        }
        int[] res=new int[queries.length];
        for(int j=0;j<queries.length;j++){
            res[j]=map.get(queries[j]);
        }
        return res;
    }
}