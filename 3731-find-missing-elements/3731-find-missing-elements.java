class Solution {
    public List<Integer> findMissingElements(int[] nums) {

        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);

        int i = nums[0];
        int t = 0;
        int n = nums[nums.length - 1];

        while (i <= n) {
            if (t < nums.length && nums[t] == i) {
                t++;        // move to next array element
            } else {
                list.add(i); // missing number
            }
            i++;
        }

        return list;
    }
}
