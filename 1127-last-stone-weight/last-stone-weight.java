class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap=new PriorityQueue<>(Collections.reverseOrder());
        for(int stone:stones){
            heap.add(stone);
        }
        //keep smashing until two stones remain
        while(heap.size()>1){
            //remove two heaviest stones
            int first=heap.poll();
            int second=heap.poll();
            if(first!=second) heap.add(first-second);
        }
        return heap.isEmpty() ? 0 : heap.peek();
    }
}