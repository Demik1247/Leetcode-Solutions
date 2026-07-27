class Solution {
    public int search(int[] nums, int target) {
        int i=Arrays.binarySearch(nums,target);
        if(i>=0){
        return i;
        }
        return -1;
    }
}