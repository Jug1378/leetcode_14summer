public class Solution {
	/**
	 * time O(N) space O(1)
     * appear only once
	 * @param  A array
	 * @return   length
	 */
    public int removeDuplicates(int[] A) {
    	int len = A.length;
    	if(len < 2) return len;
    	int index = 1;
    	for(int i=1; i<len; i++) {
    		if(A[i] != A[i-1])
    			A[index++] = A[i];
    	}
    	return index;
    }
}