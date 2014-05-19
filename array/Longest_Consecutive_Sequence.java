public class Solution {
	/**
	 * time O(n)
	 * @param  num 
	 * @return     
	 */
    public int longestConsecutive(int[] num) {
        Set<Integer> set = new HashSet<Integer>();
        int max = 1;
        for(int i:num)
        	set.add(i);
        for(int i:num) {

        	set.remove(i);

        	int count = 1;
        	int left = i-1;
        	int right = i+1;

        	while(set.contains(left)) {
        		set.remove(left);
        		count++;
        		left--;
        	}

        	while(set.contains(right)) {
        		set.remove(right);
        		count++;
        		right++;
        	}

        	max = Math.max(max, count);
        }
        return max;
    }
}