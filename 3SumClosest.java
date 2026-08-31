class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int cloSum = nums[0] + nums[1] + nums[2];
        int n = nums.length;
        for(int i=0;i<n-2;i++){
            int l = i+1;
            int r = n-1;
            while(l<r){
                int sum = nums[i]+nums[l]+nums[r];
                if(sum == target) return sum;
                if(Math.abs(sum - target)<Math.abs(cloSum - target)) cloSum = sum;
                if(sum<target){
                    l++;
                }
                else r--;
            }
        }
    
    return cloSum;
}
}