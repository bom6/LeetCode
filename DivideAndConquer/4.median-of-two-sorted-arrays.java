class Solution {
    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length, n = B.length;
        if(m > n) {
            int[] tmp = A; A = B; B = tmp;
            int temp = m; m = n; n = temp;
        }
        int iMin = 0, iMax = m, halfLen =(m+n+1)/2;
        while(iMin <= iMax) {
            int i = (iMin+iMax) / 2 ;
            int j = halfLen - i;
            if(i < iMax && B[j-1] > A[i]) { // i is too small
                iMin = i+1;
            } else if (i > iMin && A[i-1] > B[j]) { // i is too big
                iMax = i - 1;
            } else { // i is perfect
                int maxLeft = 0;
                if(i == 0) {
                    maxLeft = B[j-1];
                }   else if(j == 0) {
                    maxLeft = A[i-1];
                } else {
                    maxLeft = Math.max(B[j-1], A[i-1]);
                }
                if((m+n)%2 == 1) return maxLeft;

                int minRight = 0;
                if(i == m) {
                    minRight = B[j];
                } else if(j == n) {
                    minRight = A[i];
                } else {
                    minRight = Math.min(A[i], B[j]);
                }

                return (maxLeft+minRight) / 2.0;
            }
        }
        return 0.0;
    }
}