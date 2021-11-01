package cs460;

public class MedianOfTwoSortedArrays {

    /*
     * 10/11/21
     * Finds the median of the two sorted arrays in O(logn) time. n = A.length
     * Assumptions given by professor:
     *      n is power of 2
     *      the median is the one with rank n (n-1 below, n above)
     *      A.length = B.length
     *      all elements are distinct
     */
    public static int findMedian(int[] A, int[] B, int subA, int subB, int subLen) {
        int midA = subA + (subLen - 1)/2;
        int midB = subB + (subLen - 1)/2;
        int aVal = findValue(A, B, midA);
        int bVal = findValue(A, B, midB);
        if (subLen == 1)
            return Math.min(aVal, bVal);
        if (aVal < bVal)
            return findMedian(A, B, midA+1, subB, subLen/2);
        if (aVal > bVal)
            return findMedian(A, B, subA, midB+1, subLen/2);
        return aVal;
    }
    public static int findValue(int[] A, int[] B, int index) {
        if (index < A.length)
            return A[index];
        return B[index - A.length];
    }

    public static void main(String[] args) {
        System.out.println(findMedian(new int[]{1, 2, 3, 4}, new int[]{5, 6, 7, 8}, 0, 4, 4)); //4
        System.out.println(findMedian(new int[]{1, 4, 7, 12}, new int[]{2, 5, 9, 10}, 0, 4, 4)); //5
    }
}

