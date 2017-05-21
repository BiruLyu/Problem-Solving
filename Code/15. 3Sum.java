public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        
        if(nums.length < 3) return res;
        
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length-2; i++){
            if (i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int element1 = nums[i];
            int j = i + 1;
            int k = nums.length - 1;
            while(j < k){
                if (j > i + 1 && nums[j] == nums[j-1]){
                    j++;
                    continue;
                }
                int tempSum = element1 + nums[j] + nums[k];
                if (tempSum == 0) {
                    res.add(Arrays.asList(element1, nums[j], nums[k]));
                    k--;
                    j++;
                }else if(tempSum > 0) {
                    k--;
                }else {
                    j++;
                }
            }// while loop
        }//for loop
        
        return res;
    }
}