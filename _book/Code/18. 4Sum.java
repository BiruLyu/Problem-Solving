public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new LinkedList<>();
        if (nums.length < 4) return res;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++){
            if (i > 0 && nums[i-1] == nums[i]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++){
                if ( j > i + 1 && nums[j-1] == nums[j]) {
                    continue;
                }
                int k = j + 1;
                int l = nums.length - 1;
                while ( k < l){
                    if ( k > j + 1 && nums[k-1] == nums[k]) {
                        k++;
                        continue;
                    }
                    int tempSum = nums[i] + nums[j] + nums[k] + nums[l];
                    if (tempSum == target) {
                        res.add(Arrays.asList(nums[i],nums[j],nums[k],nums[l]));
                        k++;
                        l--;
                    } else if (tempSum > target) {
                        l--;
                    } else {
                        k++;
                    }
                    
                }//while loop
            }//for loop index j
        }//for loop index i
        return res;
    }
}