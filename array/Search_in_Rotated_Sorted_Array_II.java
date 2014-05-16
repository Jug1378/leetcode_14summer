public class Solution {
	/**
	 * time O(logn) space O(1)
     * has duplicates
	 * @param  A      array
	 * @param  target 
	 * @return        index
	 */
    public int search(int[] A, int target) {
        int i = 0, j = A.length-1;
        while(i <= j) {
        	int mid = i + (j-i)/2;
        	if(A[mid] == target)
        		return mid;
        	if(A[i] < A[mid]) {
        		if(target >= A[i] && target < A[mid])
        			j = mid - 1;
        		else
        			i = mid + 1;
        	}
        	else if(A[i] > A[mid]) {
        		if(target > A[mid] && target <= A[j])
        			i = mid + 1;
        		else
        			j = mid - 1;
            }
            else
                i++;
        }
        return -1;
    }
}