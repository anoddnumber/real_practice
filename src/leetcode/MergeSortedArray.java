package leetcode;

public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        /*
            Time Complexity - O(n + m)
            Space Complexity - O(1)
         */
        int mIndex = m - 1;
        int nIndex = n - 1;
        int index;

        while (mIndex >= 0 || nIndex >= 0) {
            index = mIndex + nIndex + 1;
            if (mIndex >= 0 && nIndex >=0) {
                if (nums1[mIndex] >= nums2[nIndex]) {
                    nums1[index] = nums1[mIndex];
                    mIndex--;
                } else {
                    nums1[index] = nums2[nIndex];
                    nIndex--;
                }
            } else if (mIndex >= 0) {
                nums1[index] = nums1[mIndex];
                mIndex--;
            } else if (nIndex >= 0){
                nums1[index] = nums2[nIndex];
                nIndex--;
            }
        }
    }

//    public void merge(int[] nums1, int m, int[] nums2, int n) {
//        int mIndex = 0;
//        int nIndex = 0;
//        int index;
//
//        while (mIndex < m || nIndex < n) {
//            index = mIndex + nIndex;
//            if (mIndex >= m) {
//                nums1[index] = nums2[nIndex];
//            } else if (nIndex >= m) {
//                nums1[index] = nums1[mIndex];
//            } else {
//                if (nums1[mIndex] <= nums2[nIndex]) {
//                    mIndex++;
//                } else {
//                    int tmp = nums1[mIndex];
//                    nums1[mIndex] = nums2[nIndex];
//                    nums2[nIndex] = tmp;
//                    mIndex++;
//                }
//            }
//        }
//    }
}
