public class Solution {
	/**
     * time O(log(m+n)) space O(1)
     * @param  A[] 
     * @param  B[] 
     * @return     
     */
    public double findMedianSortedArrays(int A[], int B[]) {
        int aLen = A.length;
        int bLen = B.length;
        if((aLen + bLen) % 2 == 1)
        	return findKth(A, B, 0, aLen-1, 0, bLen-1, (aLen+bLen)/2);
        else
        	return (findKth(A, B, 0, aLen-1, 0, bLen-1, (aLen+bLen)/2) +
        		   findKth(A, B, 0, aLen-1, 0, bLen-1, (aLen+bLen)/2 -1))*0.5;
    }

    public int findKth(int[] A, int[] B, int aStart, int aEnd, int bStart, int bEnd, int k) {
    	int aLen = aEnd - aStart + 1;
    	int bLen = bEnd - bStart + 1;
    	if(aLen == 0) return B[bStart+k];
    	if(bLen == 0) return A[aStart+k];
    	if(k == 0) return A[aStart] < B[bStart] ? A[aStart]:B[bStart];

    	int aMid = k*aLen/(aLen+bLen);
    	int bMid = k - aMid - 1;

    	aMid = aStart+aMid;
    	bMid = bStart+bMid;

    	if(A[aMid] > B[bMid]) {
    		k = k - (bMid - bStart + 1);
    		bStart = bMid + 1;
    		aEnd = aMid;
    	}
    	else if(A[aMid] < B[bMid]) {
    		k = k - (aMid - aStart + 1);
    		aStart = aMid + 1;
    		bEnd = bMid;
    	}
    	else
    		return A[aMid];

    	return findKth(A, B, aStart, aEnd, bStart, bEnd, k);
    }
}