class MinStack {

    public int[] stack;
    public int top;
    PriorityQueue<Integer> pq;

    public MinStack() {
        stack = new int[100000];
        top = -1;
        pq = new PriorityQueue();
    }
    
    public void push(int val) {
        top++;
        stack[top] = val;
        pq.offer(val);  
    }
    
    public void pop() {
        pq.remove(stack[top]);
        top--;
    }
    
    public int top() {
        return stack[top];
    }
    
    public int getMin() {
        return pq.peek();
    }
}
