class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length<=1) return intervals;

        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        List<int[]> merged = new ArrayList();

        int[] prev = intervals[0];
        merged.add(prev);

        for(int[] interval: intervals)
        {
            int[] current = interval;
            if(current[0]<=prev[1])
            {
                prev[1] = Math.max(prev[1],current[1]);
            }
            else
            {
                prev = current;
                merged.add(prev);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
