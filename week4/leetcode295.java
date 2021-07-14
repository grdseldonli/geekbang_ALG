class MedianFinder {

    public PriorityQueue<Integer> minque;
    public PriorityQueue<Integer> maxque;

    public MedianFinder() {

        minque = new PriorityQueue<Integer>();
        maxque = new PriorityQueue<Integer>((o1,o2) -> {return  o2 - o1;});

    }
    
    public void addNum(int num) {

        maxque.add(num);
        minque.add(maxque.remove());
        if (minque.size() > maxque.size())
            maxque.add(minque.remove());

    }
    
    public double findMedian() {

        if (maxque.size() == minque.size())

            return (maxque.peek() + minque.peek())/2.0;
        else 
            return maxque.peek();
    }
}