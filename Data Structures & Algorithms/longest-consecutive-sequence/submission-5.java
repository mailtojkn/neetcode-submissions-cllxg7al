class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int maxLen =0;
        for(int n:nums)
        {
            set.add(n);
        }

        for(int n: nums)
        {
            int currentNum = n;
            int currentstreak =1;
            while(set.contains(currentNum+1))
            {
                currentNum++;
                currentstreak++;
            }
            maxLen= Math.max(maxLen, currentstreak);
        }
        return maxLen;
    }
}
