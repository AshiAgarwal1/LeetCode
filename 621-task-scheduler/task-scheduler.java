class Solution {
    public int leastInterval(char[] tasks, int n) {
        //count frequencies
        int[] count=new int[26];
        for(char ch:tasks){
            count[ch-'A']++;
        }
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder());
        for(int c:count){
            if(c>0) maxHeap.add(c);
        }
        //Queue to store cooling period tasks{remaining_count,time}
        Queue<int[]> q=new LinkedList<>();
        int time=0;
        while(!maxHeap.isEmpty() || !q.isEmpty()){
            time++;
            //add to heap if any cooled tasks available time matches
            if(!q.isEmpty() && q.peek()[1]==time) maxHeap.add(q.poll()[0]);
            //execute best available task
            if(!maxHeap.isEmpty()){
                int cnt=maxHeap.poll();
                cnt--;
                //put the executed task into queue if count remains
                if(cnt>0) q.add(new int[]{cnt,time+n+1});
            }
            //if no task in maxHeap i.e. idle time
        }
        return time;
    }
}