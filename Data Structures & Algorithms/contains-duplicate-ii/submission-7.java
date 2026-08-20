class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int left=0;
        for(int right=0;right<nums.length;right++)
        {
            if(map.containsKey(nums[right]))
            {
                int prevIndex = map.get(nums[right]);
                if(right-prevIndex <= k)
                {
                    return true;
                }
            }
            
                map.put(nums[right],right);
            
        }
        return false;
    }
}