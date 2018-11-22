package org.alva.LeetCode;

import org.junit.Test;

import java.util.*;

/**
 * <一句话描述>,
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * <详细介绍>,
 *  * Example:
 *  *
 *  * Given nums = [2, 7, 11, 15], target = 9,
 *  *
 *  * Because nums[0] + nums[1] = 2 + 7 = 9,
 *  * return [0, 1].
 *
 * @author 穆国超
 * @since 设计wiki | 需求wiki
 */
public class TwoSum {

    /**
     * leetcode runtime最小的答案
     *
     * @return
     */
    private int[] twoSum_Fast(int[] nums, int target) {
        final int il = nums.length;
        int il2 = (il >> 2)-1;

        int pot = 2;
        while((il2 >>= 1) > 0)
            pot <<= 1;
        final int bitMod = pot - 1;
        final int[] bucket = new int[pot];
        final int[] linked = new int[il];

        final  int firstVal = nums[0];

        for (int i = 1;i < il;i++){
            int currNum = nums[i];
            int complement = target - currNum;

            if(complement == firstVal){
                return new int[]{0,i};
            }

            int complementLLIndex = bucket[complement & bitMod];
            while (complementLLIndex != 0){
                if(nums[complementLLIndex] == complement){
                    return new int[]{complementLLIndex,i};
                }
                complementLLIndex = linked[complementLLIndex];
            }
            int currNumLLIndex = currNum & bitMod;
            linked[i] = bucket[currNumLLIndex];
            bucket[currNumLLIndex] = i;
        }
        return null;
    }

    private int[] towSum_Simple(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            for (int j = i; j < nums.length; j++) {
                if (temp == nums[j]) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    private int[] towSum_SetAndHashMap(int[] nums, int target) {
        Set<Integer> numSet = new HashSet<>();
        Map<Integer, int[]> indexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (indexMap.keySet().contains(nums[i])) {
                int[] index = new int[2];
                index[0] = indexMap.get(nums[i])[0];
                index[1] = i;
                indexMap.put(nums[i], index);
            } else {
                int[] index = new int[1];
                index[0] = i;
                indexMap.put(nums[i], index);
            }
            numSet.add(nums[i]);
        }

        for (int num : nums) {
            if (numSet.contains(target - num)) {
                if (indexMap.get(target - num).length == 1) {
                    if (target - num != num) {
                        return new int[]{indexMap.get(num)[0], indexMap.get(target - num)[0]};
                    } else {
                        continue;
                    }
                } else {
                    return new int[]{indexMap.get(num)[0], indexMap.get(target - num)[1]};
                }
            }
        }
        return null;
    }

    private int[] twoSum_ArrayList(int[] nums, int target) {
        int[] res = new int[2];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(target - nums[i]);
        }

        for (int i = 0; i < nums.length; i++) {
            Integer num = new Integer(nums[i]);
            int index = list.indexOf(num);
            if (index > -1 && index != i) ;
            {
                res[0] = i;
                res[1] = index;
                break;
            }
        }
        return res;
    }

    public int[] twoSum_HshMap(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0 ; i < nums.length ; i++){
            if (map.containsKey(target-nums[i])){
                result[1] = i;
                result[0] = map.get(target - nums[i]);
                return result;
            }
            map.put(nums[i],i);
        }
        return result;
    }


    @Test
    public void testTwoSum_SetAndHashMap() {
        int[] nums = new int[]{15, 2, 11, 2, 7,15, 2, 11, 2, 7,15, 2, 11, 2, 7,15, 2, 11, 2, 7,15, 2, 11, 2, 7,15, 2, 11, 2, 7,15, 2, 11, 2, 7,15, 2, 11, 2, 7,15, 2, 11, 2, 7};
        int[] result = twoSum_Fast(nums, 9);
        System.out.println(result);
    }

}
