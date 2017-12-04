import java.util.HashMap;

/**
 * No1_Two_Sum
 */
public class No1_Two_Sum {

    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<nums.length;i++) {
            //store the num that nums[i] needs to be target
            int complement = target - nums[i];
            // if map contains the num that nums[i] needs
            if(map.containsKey(complement))
                return new int[]{map.get(complement), i};
            //if not, then put the nums[i]
            map.put(nums[i], i);
        }
        //if not exists
        return new int[]{-1, -1};
    }
    
}