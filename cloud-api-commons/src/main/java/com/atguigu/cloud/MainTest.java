package com.atguigu.cloud;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author：daxue0929
 * @Date：2024/3/12 15:25
 */
public class MainTest {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 5, 5, 7};
        List<List<Integer>> result = findThreeSum(nums);
        for (List<Integer> triple : result) {
            System.out.println(triple);
        }

    }

    public static List<List<Integer>> findThreeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                tempList.add(nums[i]);
            }
        }
        // {1, 2, 3, 5, 7};
        for (int i = 0; i < tempList.size()-2; i++) {
            for (int j = i+1; j <  tempList.size()-1; j++) {
                for (int k = j+1; k < tempList.size(); k++) {
                    result.add(Arrays.asList(tempList.get(i), tempList.get(j), tempList.get(k)));
                }
            }
        }
        return result;
    }


}
