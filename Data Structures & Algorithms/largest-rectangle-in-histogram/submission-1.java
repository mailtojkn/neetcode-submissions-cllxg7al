class Solution {
    public int largestRectangleArea(int[] heights) {

        Deque<Integer> stk = new ArrayDeque<>();
        int n = heights.length;
        int maxArea=0;
        for(int i=0;i<=n;i++)
        {
            int currentHeight = (i==n)?0:heights[i];
            while(!stk.isEmpty() && currentHeight<heights[stk.peek()])
            {
                int height = heights[stk.pop()];
                int leftIndex = (stk.size()==0)?-1:stk.peek();
                int width = i-leftIndex-1;
                maxArea = Math.max(maxArea, height*width);
            }
            stk.push(i);
        }
        return maxArea;      
    }
    
}
