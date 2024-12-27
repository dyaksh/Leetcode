class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int maxScore = 0;
        int maxPrev = values[0]; // Track the max value of values[i] + i

        for (int j = 1; j < values.length; j++) {
            maxScore = Math.max(maxScore, maxPrev + values[j] - j);
            maxPrev = Math.max(maxPrev, values[j] + j); // Update maxPrev for the next iteration
        }

        return maxScore;
    }
}
