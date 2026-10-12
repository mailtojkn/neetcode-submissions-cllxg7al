public class Solution {
    public bool hasDuplicate(int[] nums) {
        if(nums == null || nums.Length ==0) return false;
        HashSet<int> set = new HashSet<int>();
        foreach( var num in nums)
        {
            if(set.Contains(num))
            {
                return true;
            }
            set.Add(num);
        }
        return false;
    }
}