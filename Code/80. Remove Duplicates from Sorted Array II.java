class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null) return 0;
        if (nums.length < 3) return nums.length;
        int len = nums.length, res = 0;
        for (int i = 0; i < len; i++) {
            if (i > 1 && nums[i] == nums[res - 2]) continue;
            nums[res++] = nums[i];
        }
        return res;
    }
}
