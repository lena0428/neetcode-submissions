class MinStack {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public MinStack() {
        
    }
    
    public void push(int val) { 
        if (stack.isEmpty()) {
            stack.push(val);
            minStack.push(val);
        } else {
            stack.push(val);
            minStack.push(Math.min(stack.peek(), minStack.peek()));
        }
       
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();
    }
    
    public int top() {
        if (stack.isEmpty()) {
            return -1;
        }
        return stack.peek();
    }
    
    public int getMin() {
        if (minStack.isEmpty()) {
            return -1;
        }
        return minStack.peek();
    }
}
