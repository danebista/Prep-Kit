class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int maj1 = 0;
        int maj2 = 0;
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < nums.length; i++) {

            if (maj1 == nums[i]) {
                count1++;
            } else if (maj2 == nums[i]) {
                count2++;
            } else if (count1 == 0) {
                maj1 = nums[i];
                count1 = 1;
            } else if (count2 == 0) {
                maj2 = nums[i];
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        int n1 = 0;
        int n2 = 0;

        for (int num : nums) {
            if (num == maj1)
                n1++;
            else if (num == maj2)
                n2++;
        }

        List<Integer> result = new ArrayList();
        if (n1 > nums.length / 3)
            result.add(maj1);
        if (n2 > nums.length / 3)
            result.add(maj2);

        return result;
    }
}
