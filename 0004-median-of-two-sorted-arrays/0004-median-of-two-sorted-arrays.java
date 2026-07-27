class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int [] ans = new int[n+m];
        int k = 0;
        int i =0;
        int j = 0;
        while(i < n && j < m){
            if(nums1[i] < nums2[j]){
                ans[k++] = nums1[i++];
            }
            else{
                ans[k++] = nums2[j++];
            }
        }
        while(i < n){
            ans[k++] = nums1[i++];
        }
        while(j < m){
            ans[k++] = nums2[j++];
        }
        int t = ans.length;
        double median = 0.0;
        if(t %2 != 0){
            median = (double)(ans[t/2]);
        }
        else{
            median = (double)((ans[t/2]+ans[t/2-1])/2.0);
        }
        return median;
    }
}