class MedianFinder {
    // 2 priorityqueue
    // 2 heap
    // min heap
    // max heap
    // 10 1 2 9 4
    // 10 -> min heap -> max heap (balance)
    // 1 -> min heap -> max heap(balance)
    //  min heap < max heap -> 1 , 10
    // 1 2 3 4 5 (max heap have the final value)

    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
    PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        maxHeap.offer(num);
        // balance
        minHeap.offer(maxHeap.poll());
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
