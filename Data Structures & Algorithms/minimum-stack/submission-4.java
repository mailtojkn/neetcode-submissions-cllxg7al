class MinStack {
    private static class Entry{
        Integer value;
        Integer currentMin;
        public Entry(Integer value, Integer currentMin)
        {
            this.value = value;
            this.currentMin = currentMin;
        }
    }

    private Stack<Entry> stk;
    public MinStack() {
        stk= new Stack<>();
    }
    
    public void push(int val) {
        int currentMin = stk.isEmpty()?val: Math.min(stk.peek().currentMin, val);
        stk.push(new Entry(val, currentMin));
    }
    
    public void pop() {
        stk.pop();
    }
    
    public int top() {
        return stk.peek().value;
    }
    
    public int getMin() {
        return stk.peek().currentMin;
    }
}
