class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Deque<Integer> stk = new ArrayDeque<>();

        for(int i=0;i<temperatures.length;i++)
        {
            while(!stk.isEmpty() && temperatures[stk.peek()]<temperatures[i])
            {
                int index = stk.pop();
                result[index] = i-index;
            }
            stk.push(i);
        }
        return result;
    }
}
