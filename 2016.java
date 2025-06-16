class Solution {
    public int maximumDifference(int[] nums) {
        int minVal = Integer.MAX_VALUE;
        int maxDiff = -1;

        for (int num : nums) {
            if (num > minVal) {
                maxDiff = Math.max(maxDiff, num - minVal);
            } else {
                minVal = num;
            }
        }

        return maxDiff;
    }
}
