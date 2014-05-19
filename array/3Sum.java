public class Solution {
	/**
	 * time O(N^2)
	 * @param  num 
	 * @return     
	 */
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        for(int i=0; i<num.length-2; i++) {
        	int j = i+1;
        	int k = num.length-1;
        	while(j < k) {
        		if(num[i] + num[j] + num[k] < 0)
        			j++;
        		else if(num[i] + num[j] + num[k] > 0)
        			k--;
        		else {
        			ArrayList<Integer> arr = new ArrayList<Integer>();
        			arr.add(num[i]);
        			arr.add(num[j]);
        			arr.add(num[k]);
                    if(!result.contains(arr))
                        result.add(arr);
                    j++;
                    k--;
                    while(j < k && num[k] == num[k+1]) k--; // solution set contains no duplicates
                    while(j < k && num[j] == num[j-1]) j++;
        		}

        	}
        }
        return result;
    }
}