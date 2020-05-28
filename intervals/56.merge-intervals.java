/*
 * @lc app=leetcode id=56 lang=java
 *
 * [56] Merge Intervals
 *
 * https://leetcode.com/problems/merge-intervals/description/
 *
 * algorithms
 * Medium (38.66%)
 * Likes:    3847
 * Dislikes: 272
 * Total Accepted:    566.7K
 * Total Submissions: 1.5M
 * Testcase Example:  '[[1,3],[2,6],[8,10],[15,18]]'
 *
 * Given a collection of intervals, merge all overlapping intervals.
 * 
 * Example 1:
 * 
 * 
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into
 * [1,6].
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 * 
 * NOTE: input types have been changed on April 15, 2019. Please reset to
 * default code definition to get new method signature.
 * 
 */

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {

        if(intervals == null || intervals.length == 0) {
            return new int[0][];
        }
        // Sort array
        Comparator<int[]> comparator = new myComparator();
        Arrays.sort(intervals, comparator);

        // Iterate through each interval:
        // 1. If i-1 and i do not overlap then add i-1 to result
        // 2. If overlap then merge and hold onto the merged interval
        //int[][] results = new int[][];
        List<int[]> results = new ArrayList<int[]>();
        int[] previous = intervals[0];
        for(int i=1; i<intervals.length; i++) {
            int[] current = intervals[i];
            if(current[0] > previous[1]) {
                results.add(previous);
                previous = current;
            } else {
                int[] merged = new int[] {
                    previous[0],
                    Math.max(previous[1], current[1])
                };
                previous = merged;
            }
        }
        results.add(previous);
        int[][] res = new int[results.size()][];
        for(int i = 0; i < results.size(); i++) {
            res[i] = results.get(i);
        }
        return res;
        // If the merged interval is not null then add it to result
    }
    
    class myComparator implements Comparator<int[]> {
        public int compare(int[] i1, int[] i2) {
            if(i1[0] == i2[0]) {
                return i1[1] - i2[1];
            }
            return i1[0] - i2[0];
        }
    }
}
// @lc code=end

