public class Solution {
    public int threeSumClosest(int[] nums, int target) {
         int res = nums[0] + nums[1] + nums[2];
         Arrays.sort(nums);
         
         for (int i = 0; i < nums.length - 2; i++) {
             //element1 = nums[i];
             int j = i + 1;
             int k = nums.length - 1;
             while (j < k) {
                 int tempSum = nums[i] + nums[j] + nums[k];
                 if (tempSum == target) {
                     return target;
                 }else if (Math.abs(tempSum - target) < Math.abs(res - target)) {
                     res = tempSum;
                 }
                 if (tempSum > target) {
                     k--;
                 }else {
                     j++;
                 }
             }// while loop
         }//for loop
         return res;
         
    }
}