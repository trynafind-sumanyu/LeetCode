class MyQueue {
    private Stack<Integer> main = new Stack<>(); 
    private Stack<Integer> helper = new Stack<>(); 
    public MyQueue() {
        
    }
    
    public void push(int x) {
        main.push(x);
    }
    
    public int pop() {
        while(!main.isEmpty()){
            helper.push(main.pop());
        }
        int removed = helper.pop();
        while(!helper.isEmpty()){
            main.push(helper.pop());
        }
        return removed;
    }
    
    public int peek() {
        while(!main.isEmpty()){
            helper.push(main.pop());
        }
        int p = helper.peek();
        while(!helper.isEmpty()){
            main.push(helper.pop());
        }
        return p;
    }
    
    public boolean empty() {
        return main.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */