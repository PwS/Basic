package LeetCode;

import java.util.Arrays;

public class MedianOfTwoSortedArrays {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int nums1Length = nums1.length;
        int nums2Length = nums2.length;
        int[] both = new int[nums1Length + nums2Length];


        System.arraycopy(nums1, 0, both, 0, nums1Length);
        System.arraycopy(nums2, 0, both, nums1Length, nums2Length);

        Arrays.sort(both);


        double resultMedian;
        int indexMiddleValue = both.length / 2;

        if (both.length % 2 == 0) {
            resultMedian = ((double) both[indexMiddleValue - 1] + (double) both[indexMiddleValue]) / 2;
        } else {
            resultMedian = both[indexMiddleValue];
        }

        return resultMedian;
    }

    public static void main(String[] args) {
        int[] test1 = new int[]{1, 2};
        int[] test2 = new int[]{3, 4};

        System.out.println(findMedianSortedArrays(test1, test2));
    }
}
