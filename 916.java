class Solution {
    public List<String> wordSubsets(String[] universalSet, String[] subsetWords) {
        int[] maxSubsetFreq = new int[26];
      
        for (String subsetWord : subsetWords) {
            int[] tempFreq = new int[26];
            for (char ch : subsetWord.toCharArray()) {
                tempFreq[ch - 'a']++;
              
                maxSubsetFreq[ch - 'a'] = Math.max(maxSubsetFreq[ch - 'a'], tempFreq[ch - 'a']);
            }
        }
      
        List<String> result = new ArrayList<>();
      
        for (String word : universalSet) {
            int[] wordFreq = new int[26];
            for (char ch : word.toCharArray()) {
                wordFreq[ch - 'a']++;
            }
          
            boolean isUniversal = true;
            for (int i = 0; i < 26; ++i) {
                if (maxSubsetFreq[i] > wordFreq[i]) {
                    isUniversal = false;
                    break;
                }
            }
          
            if (isUniversal) {
                result.add(word);
            }
        }
      
        return result;
    }
}
