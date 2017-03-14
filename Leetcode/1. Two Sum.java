public class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        HashMap<Integer,Integer> bufferMap = new HashMap<Integer,Integer>();
        int[] res = new int[2];
        
        for(int i = 0; i< nums.length; i++){
            if(bufferMap.containsKey(nums[i])){
                res[0] = bufferMap.get(nums[i]);
                res[1] = i;
                return res;
            }
            
            bufferMap.put(target - nums[i],i);
            
        }
        return res;
    }
}