class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        long sum = 0;
        for (int i=0; i< chalk.length; i++){
            sum+=chalk[i];
        }
        long val = k % sum;

        for (int i=0; i< chalk.length; i++){
            if (val< chalk[i]) return i;
            val-=chalk[i];
        }
        return 0;
    }
}
