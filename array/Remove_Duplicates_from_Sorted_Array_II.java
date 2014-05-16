public class Solution {
	/**
	 * time O(N) space O(1)
     * appear twice
	 * @param  A array
	 * @return   length
	 */
    public int removeDuplicates(int[] A) {
        int len = A.length;
        if(len < 3) return len;
        int index = 2;
        for(int i=2; i<len; i++) {
        	if(A[i] != A[index-2]) // care the difference
        		A[index++] = A[i];
        }
        return index;
    }
}