public class Solution {
	/**
	 * Method like 3Sum, time O(N^3)
	 * This Method create a new class and use hashMap
	 * time ~O(N^2) space O(N^2)
	 */

	class TwoSum {
		int i;
		int j;
		int sum;
		public TwoSum(int i, int j, int sum) {
			this.i = i;
			this.j = j;
			this.sum = sum;
		}
		public boolean equals(TwoSum ts) {
			if(i == ts.i || i == ts.j || j == ts.i || j == ts.j)
				return true;
			return false;
		}	
	}
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        Map<Integer, List<TwoSum>> tsMap = new HashMap<Integer, List<TwoSum>>();
        for(int i=0; i<num.length-1; i++) {
        	for(int j=i+1; j<num.length; j++) {
        		int sum = num[i] + num[j];
        		List<TwoSum> list = tsMap.get(sum);
        		if(list == null) {
        			list = new ArrayList<TwoSum>();
        			tsMap.put(sum, list);
        		}
        		list.add(new TwoSum(i, j, sum));
        	}
        }

        for(Integer i : tsMap.keySet()) {
        	if(tsMap.containsKey(target-i)) {
        		List<TwoSum> list1 = tsMap.get(i);
        		List<TwoSum> list2 = tsMap.get(target-i);
        		for(TwoSum ts1: list1) {
        			for(TwoSum ts2: list2) {
        				if(ts1.equals(ts2)) continue;
        				ArrayList<Integer> tmp = new ArrayList<Integer>();
        				tmp.add(num[ts1.i]);
        				tmp.add(num[ts1.j]);
        				tmp.add(num[ts2.i]);
        				tmp.add(num[ts2.j]);
        				Collections.sort(tmp);
        				if(!result.contains(tmp))
        					result.add(tmp);
        			}
        		}

        	}
        }

        return result;
    }
}