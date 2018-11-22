package org.alva.LeetCode;

import javafx.scene.effect.Blend;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * <一句话描述>,
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * <p>
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * <p>
 * You may assume nums1 and nums2 cannot be both empty.
 * <p>
 * <详细介绍>,
 * Example 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * The median is 2.0
 * Example 2:
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * The median is (2 + 3)/2 = 2.5
 *
 * @author 穆国超
 * @since 设计wiki | 需求wiki
 */
public class MedianOfArrays {

    private double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        //保证两个数组中n是最小的,只遍历最小的数组
        if (m < n) {
            return findMedianSortedArrays(nums2, nums1);
        }
        //假设每个数组填充#,数组长度增加到2n,元素下标/2即可得到原下标,该方法可保证数组长度为偶数
        int l1 = 0, l2 = 0, r1 = 0, r2 = 0, c1, c2, lo = 0, hi = 2 * n;
        while (lo <= hi) {
            c1 = (lo + hi) / 2;
            c2 = m + n - c1;
            l1 = (c1 == 0) ? Integer.MIN_VALUE : nums1[(c1 - 1) / 2];
            r1 = (c1 == 2 * n) ? Integer.MAX_VALUE : nums1[c1 / 2];
            l2 = (c2 == 0) ? Integer.MIN_VALUE : nums2[(c2 - 1) / 2];
            r2 = (c2 == 2 * m) ? Integer.MAX_VALUE : nums2[c2 / 2];

            if (l1 > r2) {
                hi = c1 - 1;
            } else if (l2 > r1) {
                lo = c1 + 1;
            } else {
                break;
            }
        }
        return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
    }

    private double findMedianSortedArrays2(int[] A, int[] B) {
        int len = A.length + B.length;
        if (len % 2 == 1) {
            return findKth(A, 0, B, 0, len / 2 + 1);
        }
        return (findKth(A, 0, B, 0, len / 2) + findKth(A, 0, B, 0, len / 2 + 1)) / 2.0;
    }

    private static int findKth(int[] A, int A_start, int[] B, int B_start, int k) {
        if (A_start >= A.length) {
            return B[B_start + k - 1];
        }
        if (B_start >= B.length) {
            return A[A_start + k - 1];
        }
        if (k == 1) {
            return Math.min(A[A_start], B[B_start]);
        }

        int A_key = A_start + k / 2 - 1 < A.length ? A[A_start + k / 2 - 1] : Integer.MAX_VALUE;
        int B_key = B_start + k / 2 - 1 < B.length ? B[B_start + k / 2 - 1] : Integer.MAX_VALUE;
        if (A_key < B_key) {
            return findKth(A, A_start + k / 2, B, B_start, k - k / 2);
        } else {
            return findKth(A, A_start, B, B_start + k / 2, k - k / 2);
        }
    }

    @Test
    public void test() {
        int[] nums1 = new int[]{3};
        int[] nums2 = new int[]{-2, -1};

        System.out.println(findMedianSortedArrays2(nums1, nums2));
    }
}
