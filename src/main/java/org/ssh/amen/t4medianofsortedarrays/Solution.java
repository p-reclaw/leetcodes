package org.ssh.amen.t4medianofsortedarrays;

public class Solution {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] resultArray = new int[nums1.length + nums2.length];

        int index1 = 0;
        int index2 = 0;
        int indexResult = 0;
        do{
            if(nums1.length == index1){
                // rewrite 2
                resultArray[indexResult++] = nums2[index2++];
                continue;
            }
            if(nums2.length == index2){
                // rewrite 1
                resultArray[indexResult++] = nums1[index1++];
                continue;
            }
            if (nums1[index1] <= nums2[index2]){
                resultArray[indexResult++] = nums1[index1++];
            }else{
                resultArray[indexResult++] = nums2[index2++];
            }
        }while (indexResult < resultArray.length);

        double median = resultArray[resultArray.length/2];
        if (resultArray.length%2 == 0){
            median =( resultArray[resultArray.length/2]+ resultArray[resultArray.length/2-1] )/ 2.0;
        }
        return median;
    }

    public static void main(String[] args) {
        findMedianSortedArrays(new int[]{1, 3}, new int[]{2});
        findMedianSortedArrays(new int[]{1, 2}, new int[]{3,4 });
    }
}
