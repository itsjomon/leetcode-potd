class Solution {
    public boolean canConstruct(String inputString, int palindromeCount) {
        int length = inputString.length();
      
        if (length < palindromeCount) {
            return false;
        }
      
        int[] characterFrequency = new int[26];
      
        for (int i = 0; i < length; ++i) {
            characterFrequency[inputString.charAt(i) - 'a']++;
        }
      
        int oddCount = 0;
        for (int frequency : characterFrequency) {
            oddCount += frequency % 2;
        }
      
        return oddCount <= palindromeCount;
    }
}
