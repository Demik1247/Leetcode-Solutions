class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n= nums.length;
        return solve(nums,0,n-1)>=0;

    }
    private int solve(int[]nums,int left,int right){
        if(left==right)
        //return nums[right];  OR ypu can righte below statement
        return nums[right];


        //if pick  left
        int pleft = nums[left]- solve(nums,left+1,right);

        //if pick right
        int pright=nums[right]-solve(nums,left,right-1);

        return Math.max(pright,pleft);
    }
}