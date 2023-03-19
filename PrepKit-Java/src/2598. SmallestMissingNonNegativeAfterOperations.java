class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        TreeSet<Integer> result = new TreeSet<>();
        
        for (int i=0; i<nums.length; i++){
           if (nums[i]<0 && (-1*nums[i])%value==0){
               result.add(0);
           }
           else if (nums[i]<0) continue;
           else{
               System.out.println(nums[i]%value);
               result.add(nums[i]%value);
               result.add(nums[i]);
           }
        }
        int count = 0;
        for (int i: result){
            System.out.println(result);
            if (i!=count)return count;
            count++;
        }
        while (true){
            if (result.contains(count-value)){
                result.add(count);
                count++;
            }
            else {
                break;
            }
        }
        return count;
        
    }
}
