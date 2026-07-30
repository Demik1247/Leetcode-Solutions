class Solution {
    public int removeDuplicates(int[] nums) {
        // HashSet<Integer> set = new HashSet<>();

        // int index = 0;
        // for (int n : nums) {
        //     if (set.add(n)) {   // add returns false if duplicate
        //         nums[index++] = n;
        //     }
        // }
        // return index;

        int n=nums.length;
        int i=0;
        for(int j=1;j<n;j++){
            if(nums[j]!=nums[i]){
                i++;
                nums[i]=nums[j];
            }
            
        }
        return i+1;
    }
}
