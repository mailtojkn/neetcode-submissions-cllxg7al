class Solution {
    public boolean hasDuplicate(int[] nums) {
        if(nums == null) return false;
        Set<Integer> set = new HashSet<Integer>();
        for(int num : nums)
        {

            if(set.contains(num))
            {
                return true;
            }
            set.add(num);
        }
        return false;
    }
}