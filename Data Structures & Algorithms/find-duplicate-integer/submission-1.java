class Solution {
    public int findDuplicate(int[] nums) {
        
        
        //1  3   4  2  2
//index-> 0  1   2  3  4

        //1  3   2  4  2

        int slow = nums[0];
        int fast = nums[0];


        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while(slow!=fast);
        slow = nums[0];

        while(slow!=fast)
        {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
