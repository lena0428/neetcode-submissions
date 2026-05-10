class MedianFinder {
    // store the biggest half of stream
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    // store the smallest half of stream
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);


    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        // push number to max heap to find the biggest num
        maxHeap.offer(num);

        // balance the min heap, make the minHeap keep the biggest half of stream
        minHeap.offer(maxHeap.poll());

        // make the two queues' size equal
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        } else {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
    }
}
