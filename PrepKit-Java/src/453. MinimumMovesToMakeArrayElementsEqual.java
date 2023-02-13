class Solution {
    public int minMoves(int[] nums) {
        int minValue = Integer.MAX_VALUE;
        for (int i=0; i< nums.length; i++){
            minValue = Math.min(minValue, nums[i]);
        }
        int moves = 0;
        for (int i=0; i< nums.length; i++){
            moves+= nums[i]-minValue;
        }

        return moves;
    }
}
// the minimum element gets updated exactly k times. Hence make each number equal to minimum and add them
// so find min and subtract min from each number
// sum(array) - n*(minimum) = k;
//1,2,3
//minValue+k=
//if all elements equal len*min = sum;
//len*(min+k)=sum+k*(len-1)
// k = sum-len*min
// Increase all except one is like saying decrease only 1 because
// SINCE K-1 AT A TIME, NUMBER - MINVALUE TIMES IS THE TIME EACH NUMBER EXECUTES
// [1,1,100000] = THE SMALLER NUMBERS 1,1 GET CALLED 99999 TIMES
// HENCE 1-1+ 1-1 + 100000-1 = ans

