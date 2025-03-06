class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int pairCount = 0;
        int wordCount = words.length;
      
        for (int i = 0; i < wordCount; ++i) {
            String currentWord = words[i];
          
            for (int j = i + 1; j < wordCount; ++j) {
                String comparisonWord = words[j];
              
                if (comparisonWord.startsWith(currentWord) && comparisonWord.endsWith(currentWord)) {
                    pairCount++;
                }
            }
        }
      
        return pairCount;
    }
}
