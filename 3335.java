class Solution {
    private static final int MOD = 1_000_000_007;
    public int lengthAfterTransformations(String s, int t) {
        int[][] dp = new int[t + 1][26];
        for (int c = 0; c < 26; c++) {
            dp[0][c] = 1;
        }
        for (int i = 1; i <= t; i++) {
            for (int c = 0; c < 26; c++) {
                if (c == 25) {
                    dp[i][c] = (dp[i - 1][0] + dp[i - 1][1]) % MOD;
                } else {
                    dp[i][c] = dp[i - 1][c + 1];
                }
            }
        }
        long result = 0;
        for (char ch : s.toCharArray()) {
            result = (result + dp[t][ch - 'a']) % MOD;
        }
        return (int) result;
    }
}
