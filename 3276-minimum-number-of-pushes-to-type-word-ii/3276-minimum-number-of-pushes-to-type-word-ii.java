class Solution {
    public int minimumPushes(String word) {
        int[] map = new int[26];

        for (char ch : word.toCharArray()) {
            map[ch - 'a']++; 
        }

        Integer[] mapInteger = Arrays.stream(map).boxed().toArray(Integer[]::new);
        Arrays.sort(mapInteger, Comparator.reverseOrder());

        int ans = 0;
        for (int i = 0; i < 26; i++) {
            ans += mapInteger[i] * ((i / 8) + 1);
        }
        return ans;
    }
}