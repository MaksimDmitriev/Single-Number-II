package com.app;

public class Main {

    public static void main(String[] args) {
        final int[] nums = {
                12, 4, 12, 12, 7, 7, 7
        };
        System.out.println(singleNumber(nums));
    }

    // https://leetcode.com/problems/single-number-ii/discuss/43297/Java-O(n)-easy-to-understand-solution-easily-extended-to-any-times-of-occurance
    public static int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int numOfOnes = 0;
            for (int j = 0; j < nums.length; j++) {
                if (((nums[j] >> i) & 1) == 1) {
                    numOfOnes++;
                    numOfOnes %= 3;
                }
            }
            if (numOfOnes == 1) {
                res |= (numOfOnes << i);
            }
        }
        return res;
    }
}
