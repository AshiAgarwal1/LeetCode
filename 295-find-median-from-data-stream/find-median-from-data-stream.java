class MedianFinder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    public MedianFinder() {
        minHeap=new PriorityQueue<>();
        maxHeap=new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        if(maxHeap.isEmpty() || num<=maxHeap.peek()) 
        maxHeap.add(num);
        else 
        minHeap.add(num);
        if(maxHeap.size()-minHeap.size()>1) {
            int ele=maxHeap.poll();
            minHeap.add(ele);
            }
        if(minHeap.size()-maxHeap.size()>1){
            int ele=minHeap.poll();
            maxHeap.add(ele);
        }
    }
    
    public double findMedian() {
        if(maxHeap.size()==minHeap.size())
        return ((double)minHeap.peek()+maxHeap.peek())/2.0;
        else if(maxHeap.size()>minHeap.size())
        return (double)maxHeap.peek();
        else
        return (double)minHeap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */