class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ans=0;
        int count=0;
        for(int n : nums){
            if(n==1){
                count++;
            }else{
                ans=Math.max(ans,count);
                count=0;
            }
        }
        
        return Math.max(ans,count);
    }
}