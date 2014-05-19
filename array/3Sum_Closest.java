public class Solution {
	/**
	 * time O(N^2)
	 * @param  num    
	 * @param  target 
	 * @return        
	 */
    public int threeSumClosest(int[] num, int target) {
    	Arrays.sort(num);
        int min = Integer.MAX_VALUE;
        int result = 0;
        for(int i=0; i<num.length-2; i++) {
        	int j = i+1;
        	int k = num.length-1;
        	while(j < k) {
        		int sum = num[i] + num[j] + num[k];
        		if(Math.abs(sum-target) < min) {
        			min = Math.abs(sum-target);
        			result = sum;
        		}
        		if(sum > target)
        			k--;
        		else if(sum < target)
        			j++;
        		else
        			return sum;
        	}
        }
        return result;
    }
}