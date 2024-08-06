class Solution {
    public int minimumPushes(String word) {
        if (word.length() <= 8) {
            return word.length();
        }

        int count = 0;
        Map<Integer, Integer> mp = new HashMap<>();

        int assign = 2;
        for (char ch : word.toCharArray()) {
            if (assign > 9) {
                assign = 2;
            }

            mp.put(assign, mp.getOrDefault(assign, 0) + 1);
            count += mp.get(assign);
            assign++;
        }

        return count;
    }
}